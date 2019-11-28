package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import entity.Servico;

public class DaoServicoconc implements DaoServico
{
	private Connection conexao;
	public DaoServicoconc() throws DaoException, SQLException 
	{
		DaoGenerica Dao = new DaoGenericoconc();
		conexao = Dao.getConnection();
	}
	@Override
	public void adicionarServico(Servico serv) throws DaoException 
	{
		try 
		{
			String command = "INSERT INTO servico " + "(nome_Serv, descricao_Serv, disponivel, custo) " + "VALUES " + "(?, ?. ?, ?)";
			PreparedStatement state = conexao.prepareStatement(command);
			state.setString(1, serv.getNomeServ());
			state.setString(2, serv.getDescServ());
			state.setBoolean(3, serv.isServDisp());
			state.setDouble(4, serv.getValueServ());
			state.execute();
			state.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public void editarServico(Servico serv) throws DaoException 
	{
		try {
			String sql = "UPDATE servico SET descricao_Serv = ?, custo = ?, disponivel = ? WHERE nome_Servico = ?";
			PreparedStatement state = conexao.prepareStatement(sql);
			state.setString(1, serv.getDescServ());
			state.setDouble(2, serv.getValueServ());
			state.setBoolean(3, serv.isServDisp());
			state.execute();
			state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void desativarServico(Servico serv) throws DaoException 
	{
		try {
			String sql = "UPDATE servico SET disponivel = 0 WHERE nome_Servico = ?";
			PreparedStatement state = conexao.prepareStatement(sql);
			state.setString(1, serv.getNomeServ());
			state.execute();
			state.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public Servico pesquisarServico(String serv) throws DaoException 
	{
		Servico ser = new Servico();
		try {
			String sql = "SELECT nome_Servico, id_Servico, descricao_Serv, custo, disponivel FROM servico WHERE nome_Servico = ?";
			PreparedStatement state = conexao.prepareStatement(sql);
			state.setString(1, serv);
			ResultSet result = state.executeQuery();
			if(result.next()) 
			{
				ser.setId(result.getLong("id_Servico"));
				ser.setNomeServ(result.getString("nome_Servico"));
				ser.setValueServ(result.getDouble("custo"));
				ser.isServDisp(result.getBoolean("disponivel"));
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return ser;
	}

	@Override
	public List<Servico> getServicos() throws DaoException 
	{
		List<Servico> servicos = new LinkedList<Servico>();;
		try {
			String sql = "SELECT nome_Servico, id_Servico, descricao_Serv, custo, disponivel FROM servico WHERE disponivel = 1";
			PreparedStatement state = conexao.prepareStatement(sql);
			ResultSet result = state.executeQuery();
			while(result.next()) 
			{
				Servico services = new Servico();
				services.setId(result.getLong("id_Servico"));
				services.setNomeServ(result.getString("nome_Servico"));
				services.setValueServ(result.getDouble("custo"));
				services.isServDisp(result.getBoolean("disponivel"));
				servicos.add(services);
			}
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return servicos;
	}
	@Override
	public boolean consultaExistencia(Servico serv) {
		try 
		{
			String sql = "SELECT nome_Servico FROM servico WHERE nome_Servico = ?";
			PreparedStatement state = conexao.prepareStatement(sql);
			state.setString(1, serv.getNomeServ());
			ResultSet results = state.executeQuery();
			if(results.next()) 
			{
				if(results.getString("nome_Servico").equals(serv.getNomeServ())) 
				{
					return true;
				}
			}
			return false;
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return true;
	}
}
