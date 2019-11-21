package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import entity.Cor;

public class DaoCorconc implements DaoCor
{
	private Connection conexao;
	public DaoCorconc() throws DaoException, SQLException 
	{
		DaoGenerica dao = new DaoGenericoconc();
		conexao = dao.getConnection();
	}
	@Override
	public void adicionaCor(String nomeCor) throws DaoException 
	{
		if(!confereCor(nomeCor)) 
		{
			try {
				String command = "INSERT INTO cor " + "(nome_Cor) " + "VALUES " + "(?)";
				PreparedStatement state = conexao.prepareStatement(command);
				state.setString(1, nomeCor);
				state.execute();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Cor> getCores() throws DaoException 
	{
		List<Cor> cores = new LinkedList<Cor>();
		String sql = "SELECT * FROM cor";
		
		return null;
	}
	@Override
	public boolean confereCor(String nomeCor) throws DaoException 
	{
		try 
		{
			String sql = "SELECT nome_Cor FROM cor WHERE nome_cor = ?";
			PreparedStatement state = conexao.prepareStatement(sql);
			state.setString(1, nomeCor);
			ResultSet resul = state.executeQuery();
			if(!resul.first()) 
			{
				return false;
			}
			else 
			{
				return true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return true;
	}
}
