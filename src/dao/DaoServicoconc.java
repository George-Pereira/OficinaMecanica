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
		
	}

	@Override
	public void desativarServico(Servico serv) throws DaoException 
	{
		try {
			String sql = "UPDATE servico SET disponivel = 0 WHERE nome_Servico = ?";
			PreparedStatement state = conexao.prepareStatement(sql);
			state.setString(1, serv.getNomeServ());
			state.execute();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public Servico pesquisarServico(Servico serv) throws DaoException 
	{
		Servico ser = new Servico();
		try {
			String sql = "SELECT nome_Servico, id_Servico, descricao_Serv, custo, disponivel FROM servico WHERE nome_Servico = ?";
			PreparedStatement state = conexao.prepareStatement(sql);
			state.setString(1, serv.getNomeServ());
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
	public List<Servico> getServicos(Servico serv) throws DaoException 
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
}
