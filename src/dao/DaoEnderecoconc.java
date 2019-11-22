package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import entity.Cliente;
import entity.Endereco;

public class DaoEnderecoconc implements DaoEndereco
{
	private Connection conection;
	public DaoEnderecoconc() throws DaoException, SQLException 
	{
		DaoGenerica Dao = new DaoGenericoconc();
		conection = Dao.getConnection();
	}
	@Override
	public void adicionarEndereco(Cliente cli, Endereco end) throws DaoException 
	{
		try {
			String sql = "INSERT INTO endereco " + "(id_Cliente, logradouro, num_Resid, bairro) " + "VALUES " + "(?, ?, ?, ?)";
			PreparedStatement statement = conection.prepareStatement(sql);
			statement.setLong(1, cli.getId());
			statement.setString(2, end.getLogradouro());
			statement.setInt(3, end.getNumero());
			statement.setString(4, end.getBairro());
			statement.execute();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	@Override
	public List<Endereco> enderecosCliente(Cliente cli) throws DaoException 
	{
		List<Endereco> enderecos = new LinkedList<Endereco>();
		try {
			String comando = "SELECT * FROM enderecos WHERE id_Cliente = ?";
			PreparedStatement state = conection.prepareStatement(comando);
			state.setLong(1, cli.getId());
			ResultSet result = state.executeQuery();
			while(result.next())
			{
				Endereco end = new Endereco();
				end.setBairro(result.getString("bairro"));
				end.setLogradouro(result.getString("logradouro"));
				end.setNumero(result.getInt("num_Resid"));
				enderecos.add(end);
			}
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return enderecos;
	}

	@Override
	public void removeEndereco(Cliente cli, Endereco end) throws DaoException 
	{
		
	}

}
