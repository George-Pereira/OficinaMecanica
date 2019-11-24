package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import entity.Cliente;

public class DaoClienteconc implements DaoCliente
{
	private Connection conexao;
	
	public DaoClienteconc() throws DaoException, ClassNotFoundException, SQLException
	{
		try {
			DaoGenerica i = new DaoGenericoconc();
			conexao = i.getConnection();
		} catch (SQLException e) 
		{
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

	@Override
	public void adicionarCliente(Cliente cli) throws DaoException 
	{
		try 
		{
			String sql = "INSERT INTO cliente " + " (cpf, cnh, telefone,nome_Cliente) " + " VALUES (?,?,?,?)";
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setString(1, cli.getCPF());
			statement.setString(2, cli.getCNH());
			statement.setString(3, cli.getTelefone());
			statement.setString(4, cli.getNome());
			statement.executeUpdate();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

	@Override
	public void editarCliente(Cliente cli) throws DaoException 
	{
		try {
			String sql = "Update cliente SET telefone = ? Where nome_Cliente = ? OR cpf = ? OR cnh = ?";
			PreparedStatement state = conexao.prepareStatement(sql);
			state.setString(1, cli.getTelefone());
			state.setString(2, cli.getNome());
			state.setString(3, cli.getCPF());
			state.setString(4, cli.getCNH());
			state.executeUpdate();
		} catch (SQLException e) 
		{
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

	@Override
	public Cliente pesquisarCliente(String varpesq) throws DaoException 
	{
		Cliente cli = new Cliente();
		try {
			String sql = "SELECT * FROM cliente WHERE cnh = ? OR cpf = ? OR nome_Cliente = ?";
			PreparedStatement state = conexao.prepareStatement(sql);
			state.setString(1, varpesq);
			state.setString(2, varpesq);
			state.setString(3, varpesq);
			ResultSet rs = state.executeQuery();
			if(rs.next()) 
			{
				cli.setId(rs.getLong("id_cliente"));
				cli.setCNH(rs.getString("cnh"));
				cli.setCPF(rs.getString("cpf"));
				cli.setTelefone(rs.getString("telefone"));
				cli.setNome(rs.getString("nome_Cliente"));
			}
		} catch (SQLException e) 
		{
			e.printStackTrace();
			throw new DaoException(e);
		}
		return cli;
	}
	@Override
	public List<Cliente> getClientes() throws DaoException
	{
		List<Cliente> clientes = new LinkedList();
		try {
			String sql = "SELECT * FROM Cliente";
			PreparedStatement state = conexao.prepareStatement(sql);
			ResultSet clients = state.executeQuery();
			while(clients.next()) 
			{
				Cliente cli = new Cliente();
				cli.setNome(clients.getString("nome_Cliente"));
				cli.setId(clients.getLong("id_Cliente"));
				cli.setCNH(clients.getString("cnh"));
				cli.setCPF(clients.getString("cpf"));
				cli.setTelefone(clients.getString("telefone"));
				clientes.add(cli);
			}
			clients.close();
			state.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new DaoException(e);
		}
		return clientes;
	}
}
