package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import entity.Ordem_Servico;
import entity.Servico;
import entity.Veiculo;

public class DaoOrdemServicoconc 
{
private Connection conexao;
	
	public DaoOrdemServicoconc() throws DaoException, ClassNotFoundException, SQLException
	{
		DaoGenerica i = new DaoGenericoconc();
		conexao = i.getConnection();
	}
	
	public List<Ordem_Servico> getServicos(Ordem_Servico os) throws DaoException {
		List<Ordem_Servico> os1 = new LinkedList<Ordem_Servico>();
		
		try {
			String sql = "SELECT * FROM OrdemServico os"
					+"LEFT OUTER JOIN Servico s ON s.id_Servico = os.id_servico"
					+"LEFT OUTER JOIN Veiculo v ON v.id_Veiculo = os.id_Veiculo"
					+"WHERE id_OS = ?";
			PreparedStatement state = conexao.prepareStatement(sql);
			state.setLong(1, os.getOS());
			ResultSet resultOS = state.executeQuery();
			while(resultOS.next()) 
			{
				Ordem_Servico os2 = new Ordem_Servico();
				os2.setOS(resultOS.getLong("id_OS"));
				String Servico = "SELECT nome_Servico, s.id_Servico FROM OrdemServico os"
						+ "LEFT OUTER JOIN Servico s ON s.id_Servico = os.id_servico WHERE id_OS = ?";
				PreparedStatement stateServ = conexao.prepareStatement(Servico);
				stateServ.setLong(1, resultOS.getLong("id_Servico"));
				ResultSet ServicoSet = stateServ.executeQuery();
				Servico serv = new Servico();
				if(ServicoSet.next()) 
				{
					serv.setNomeServ(ServicoSet.getString("nome_Marca"));
				}
				os2.setNomeS(serv);
				String Veiculo = "SELECT v.id_Veiculo, m.nome_Modelo FROM OrdemServico os"
						+"LEFT OUTER JOIN Veiculo v ON v.id_Veiculo = os.id_Veiculo"
						+"INNER JOIN Modelo m ON m.id_Modelo = v.id_Modelo"
						+"WHERE id_OS = ?";
				PreparedStatement stateVeic = conexao.prepareStatement(Veiculo);
				stateVeic.setLong(1, resultOS.getLong("id_Servico"));
				ResultSet VeiculoSet = stateVeic.executeQuery();
				Veiculo v = new Veiculo();
				if(VeiculoSet.next()) {
					v.setId(VeiculoSet.getLong("id_Veiculo"));
				}
				os2.setNomeV(v);
				
				os1.add(os2);
			}
			state.close();
			resultOS.close();
		}catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return os1;
	}
	
	public void novaOrdemServico() {
		
	}
}
