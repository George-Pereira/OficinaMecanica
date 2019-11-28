package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import entity.Marca;

public class DaoMarcaconc implements DaoMarca
{
	private Connection conexao;
	
	public DaoMarcaconc() throws DaoException, SQLException 
	{
		DaoGenerica i = new DaoGenericoconc();
		conexao = i.getConnection();
	}
	@Override
	public void adicionarMarca(String marca) throws DaoException 
	{
		try {
			String sql = "INSERT INTO Marca" + " (nome_Marca)" + " VALUES " + "(?)";
			PreparedStatement state = conexao.prepareStatement(sql);
			state.setString(1, marca);
			state.execute();
			state.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Marca> getMarca() throws DaoException
	{
		List<Marca> marcas = new LinkedList<Marca>();
		try {
			String sql = "SELECT * FROM Marca";
			PreparedStatement state = conexao.prepareStatement(sql);
			ResultSet results = state.executeQuery();
			while(results.next()) 
			{
				Marca marca = new Marca();
				marca.setNome_Marca(results.getString("nome_Marca"));
				marca.setId(results.getLong("id_Marca"));
				marcas.add(marca);
			}
			state.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return marcas;
	}
	@Override
	public Marca procMarca(long id) 
	{
		Marca marc = new Marca();
		String sql = "SELECT id_Marca, nome_Marca FROM marca WHERE id_Marca = ?";
		PreparedStatement state = conexao.prepareStatement(sql);
		state.setLong(1, id);
		ResultSet result = state.executeQuery();
		result.next();
		return marc;
	}
}
