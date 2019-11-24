package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
		
	}

	@Override
	public Servico pesquisarServico(Servico serv) throws DaoException 
	{
		return null;
	}

	@Override
	public List<Servico> getServicos(Servico serv) throws DaoException 
	{
		return null;
	}
}
