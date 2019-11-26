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
	public List<Cor> getCores() throws DaoException 
	{
		List<Cor> cores = new LinkedList<Cor>();
		try {
			String sql = "SELECT * FROM cor";
			PreparedStatement state = conexao.prepareStatement(sql);
			ResultSet corSet = state.executeQuery();
			while(corSet.next()) 
			{
				Cor color = new Cor();
				color.setId(corSet.getLong("id_Cor"));
				color.setCor(corSet.getString("nome_Cor"));
				cores.add(color);
			}
			corSet.close();
			state.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return cores;
	}
}
