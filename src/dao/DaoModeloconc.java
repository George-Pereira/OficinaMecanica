package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import entity.Marca;
import entity.Modelo;

public class DaoModeloconc implements DaoModelo
{
	private Connection conexao;
	public DaoModeloconc() throws DaoException, ClassNotFoundException, SQLException
	{
		DaoGenerica i = new DaoGenericoconc();
		conexao = i.getConnection();
	}
	@Override
	public boolean consultaExistencia(String modelo) throws DaoException 
	{
		try {
			String query = "SELECT nome_Modelo FROM modelo WHERE nome_Modelo = ?";
			PreparedStatement state = conexao.prepareStatement(query);
			state.setString(1, modelo);
			ResultSet result = state.executeQuery();
			state.close();
			if(!result.first()) 
			{
				return false;
			}
			else
			{
				return true;
			}
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public List<Modelo> getModelos(long marca) throws DaoException 
	{
		List<Modelo> modelos = new LinkedList<Modelo>();
		try {
			String sql = "SELECT * FROM modelo WHERE id_Marca= ?";
			PreparedStatement state = conexao.prepareStatement(sql);
			state.setLong(1, marca);
			ResultSet results = state.executeQuery();
			while(results.next()) 
			{
				Modelo model = new Modelo();
				model.setId(results.getLong("id_Modelo"));
				model.setNome_Modelo(results.getString("nome_Modelo"));
				modelos.add(model);
			}
			state.close();
			results.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
			throw new DaoException(e);
		}
		return modelos;
	}

	@Override
	public void adicionaModelo(Modelo model, long marca) throws DaoException 
	{
		if(!consultaExistencia(model.getNome_Modelo())) 
		{
			try {
				String commando = "INSERT INTO modelo " + "(id_Marca, nome_Modelo) " + " VALUES (?,?)";
				PreparedStatement state = conexao.prepareStatement(commando);
				state.setLong(1, marca);
				state.setString(2, model.getNome_Modelo());
				state.execute();
				state.close();
			} 
				catch (SQLException e) 
			{
					e.printStackTrace();
			}
		}
	}
	public Modelo pesqModelo(String model) 
	{
		Modelo modelo = new Modelo();
		try {
			String sql = "SELECT nome_Modelo, id_Modelo FROM modelo WHERE nome_Modelo = ?";
			PreparedStatement state = conexao.prepareStatement(sql);
			state.setString(1, model);
			ResultSet result = state.executeQuery();
			result.next();
			modelo.setId(result.getLong("id_Modelo"));
			modelo.setNome_Modelo(result.getString("nome_Modelo"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelo;
	}
}
