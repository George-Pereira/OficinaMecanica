package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import entity.Funcionario;
import entity.Gerente;
import entity.Servico;

public class DaoFuncionarioconc implements DaoFuncionario
{
	private Connection conexao;
	public DaoFuncionarioconc() throws DaoException, SQLException 
	{
		DaoGenerica dao= new DaoGenericoconc();
		conexao = dao.getConnection();
	}
	@Override
	public void adicionarFuncionario(Funcionario func, Gerente ger) throws DaoException 
	{
		if(!existenciaFuncionario(func)) 
		{
			try {
				String sql = "INSERT INTO funcionario " + "(nome_func, cartTrab, cpf, salarioHora,telefone, id_Gerente) " + "VALUES " + "(?,?,?,?,?,?)";
				PreparedStatement state = conexao.prepareStatement(sql);
				state.setString(1, func.getNomeFunc());
				state.setString(2, func.getCartTrab());
				state.setString(3, func.getCpf());
				state.setDouble(4, func.getSalario());
				state.setString(5, func.getTelefone());
				state.setLong(6, ger.getId());
				state.close();
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}

	@Override
	public void editarFuncionario(Funcionario func) throws DaoException 
	{
		try {
			String sql = "UPDATE funcionario SET nome_func = ?, salarioHora = ?, telefone = ? WHERE id_func = ?";
			PreparedStatement state = conexao.prepareStatement(sql);
			state.setString(1, func.getNomeFunc());
			state.setDouble(2, func.getSalario());
			state.setString(3, func.getTelefone());
			state.execute();
			state.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public void removerFuncionario(Funcionario func) throws DaoException 
	{
		
	}

	@Override
	public List<Funcionario> getFuncionarios() throws DaoException 
	{
		List<Funcionario> funcs = new LinkedList<Funcionario>();
		try {
			String sql = "SELECT id_func, nome_func, cartTrab, salarioHora, cpf, telefone FROM Funcionario";
			PreparedStatement state = conexao.prepareStatement(sql);
			ResultSet results = state.executeQuery();
			while(results.next()) 
			{
				Funcionario func = new Funcionario();
				func.setId(results.getLong("id_func"));
				func.setCpf(results.getString("cpf"));
				func.setCartTrab(results.getString("cartTrab"));
				func.setNomeFunc(results.getString("nome_func"));
				func.setSalario(results.getDouble("salarioHora"));
				func.setTelefone(results.getString("telefone"));
				funcs.add(func);
			}
			results.close();
			state.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return funcs;
	}

	@Override
	public List<Funcionario> getHabilitados(Servico serv) throws DaoException 
	{
		List<Funcionario> funcs = new LinkedList<Funcionario>();
		try {
			String sql = "SELECT id_func, nome_func, cartTrab, salarioHora, cpf, telefone FROM Funcionario INNER JOIN habilidade ON Funcionario.id_func = habilidade.id_funcion WHERE habilidade.id_Serv = ?";
			PreparedStatement state = conexao.prepareStatement(sql);
			state.setLong(1, serv.getId());
			ResultSet results = state.executeQuery();
			while(results.next()) 
			{
				Funcionario func = new Funcionario();
				func.setId(results.getLong("id_func"));
				func.setCpf(results.getString("cpf"));
				func.setCartTrab(results.getString("cartTrab"));
				func.setNomeFunc(results.getString("nome_func"));
				func.setSalario(results.getDouble("salarioHora"));
				func.setTelefone(results.getString("telefone"));
				funcs.add(func);
			}
			results.close();
			state.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return funcs;
	}
	@Override
	public Funcionario pesqFuncionario(String nome) throws DaoException {
		Funcionario func = new Funcionario();
		try {
			String sql = "SELECT * FROM funcionario WHERE nome_funcionario = ?";
			PreparedStatement state = conexao.prepareStatement(sql);
			state.setString(1, nome);
			ResultSet result = state.executeQuery();
			if(result.next()) 
			{
				func.setNomeFunc(result.getString("nome_func"));
				func.setCpf(result.getString("cpf"));
				func.setId(result.getLong("id_func"));
				func.setSalario(result.getDouble("salarioHora"));
				func.setCartTrab(result.getString("cartTrab"));
				func.setTelefone(result.getString("telefone"));
			}
			result.close();
			state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return func;
	}
	@Override
	public void adicionarHabilidades(Funcionario func, Servico serv) throws DaoException 
	{
		try 
		{
			String sql = "INSERT INTO habilidade " + "(id_funcion, id_serv) " + "Values " + "(?,?)";
			PreparedStatement state = conexao.prepareStatement(sql);
			state.setLong(1, func.getId());
			state.setLong(2, serv.getId());
			state.execute();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	@Override
	public boolean existenciaFuncionario(Funcionario func) throws DaoException 
	{
		try {
			String sql = "SELECT nome_Funcionario FROM funcionario WHERE cpf = ? OR cartTrab = ?";
			PreparedStatement state = conexao.prepareStatement(sql);
			state.setString(1, func.getCpf());
			state.setString(2, func.getCartTrab());
			ResultSet result = state.executeQuery();
			while(result.next()) 
			{
				if((func.getCartTrab().equals(result.getString("cartTrab")) || (func.getCpf().equals(result.getString("cpf")))))
						{
							return true;
						}
			}
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
}
