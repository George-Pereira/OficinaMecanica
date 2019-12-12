package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import entity.Gerente;

public class DaoGerenteconc implements DaoGerente
{
	private Connection conexao;
	public DaoGerenteconc() throws DaoException, SQLException 
	{
		DaoGenerica dao = new DaoGenericoconc();
		conexao = dao.getConnection();
	}
	@Override
	public void adicionarGerente(Gerente ger) throws DaoException 
	{
		try {
			String sql = "INSERT INTO gerente " + "(nome_gerente, cartTrab, cpf, salario, ativo, telefone) " + "VALUES " + "(?,?,?,?,?,?)";
			PreparedStatement state = conexao.prepareStatement(sql);
			state.setString(1, ger.getNome_Gerente());
			state.setString(2, ger.getCartTrab());
			state.setString(3, ger.getCpf());
			state.setDouble(4, ger.getSalario());
			state.setBoolean(5, ger.isAtivo());
			state.setString(6, ger.getTelefone());
			state.execute();
			state.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	@Override
	public void editarGerente(Gerente ger) throws DaoException 
	{
		try {
			String sql = "UPDATE gerente SET nome_Gerente = ?, cartTrab = ?, salario = ?, telefone = ? WHERE id_gerente = ?";
			PreparedStatement state = conexao.prepareStatement(sql);
			state.setString(1, ger.getNome_Gerente());
			state.setString(2, ger.getCartTrab());
			state.setDouble(3, ger.getSalario());
			state.setBoolean(4, ger.isAtivo());
			state.setString(5, ger.getTelefone());
			state.setLong(6, ger.getId());
			state.execute();
			state.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	@Override
	public void desativaGerente(long ger) throws DaoException 
	{
		try {
			String sql = "UPDATE Gerente SET ativo = 0 WHERE id_Gerente = ?";
			PreparedStatement state = conexao.prepareStatement(sql);
			state.setLong(1, ger);
			state.execute();
			state.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	@Override
	public List<Gerente> getGerente() throws DaoException 
	{
		List<Gerente> admins = new LinkedList<Gerente>();
		try {
			String sql = "SELECT * FROM gerente";
			PreparedStatement state = conexao.prepareStatement(sql);
			ResultSet results = state.executeQuery();
			while(results.next()) 
			{
				Gerente gerente = new Gerente();
				gerente.setAtivo(results.getBoolean("ativo"));
				gerente.setCartTrab(results.getString("cartTrab"));
				gerente.setNome_Gerente(results.getString("nome_gerente"));
				gerente.setSalario(results.getDouble("salario"));
				gerente.setTelefone(results.getString("telefone"));
				gerente.setId(results.getLong("id_Gerente"));
				admins.add(gerente);
			}
			results.close();
			state.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return admins;
	}
	@Override
	public Gerente pesquisaGerente(String varpesq) throws DaoException 
	{
		Gerente gestor = new Gerente();
		try 
		{
			String sql = "SELECT * FROM GERENTE WHERE id_gerente = ?";
			PreparedStatement state = conexao.prepareStatement(sql);
			ResultSet results = state.executeQuery();
			results.next();
			gestor.setAtivo(results.getBoolean("ativo"));
			gestor.setCartTrab(results.getString("cartTrab"));
			gestor.setNome_Gerente(results.getString("noem_gerente"));
			gestor.setSalario(results.getDouble("salario"));
			gestor.setTelefone(results.getString("telefone"));
			gestor.setId(results.getLong("id_Gerente"));
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return gestor;
	}
}
