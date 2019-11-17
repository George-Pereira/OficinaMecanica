package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Cliente;

public class DaoCliente implements InterfaceCliente
{
	private Connection conexao;
	
	public DaoCliente() throws DaoException, ClassNotFoundException, SQLException
	{
		try {
			interfaceGenerica i = new DaoGenerico();
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
			String sql = "INSERT INTO cliente " + " (cpf, cnh, telefone) " + " VALUES (?,?,?)";
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setString(1, cli.getCPF());
			statement.setString(2, cli.getCNH());
			statement.setString(3, cli.getTelefone());
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
			String sql = "SELECT * FROM cliente WHERE = ?";
			PreparedStatement state = conexao.prepareStatement(sql);
			state.setString(1, varpesq);
			ResultSet rs = state.executeQuery();
			cli.setId(rs.getLong("id_cliente"));
			cli.setCNH(rs.getString("cnh"));
			cli.setCPF(rs.getString("cpf"));
			cli.setTelefone(rs.getString("telefone"));
		} catch (SQLException e) 
		{
			e.printStackTrace();
			throw new DaoException(e);
		}
		return cli;
	}
}
