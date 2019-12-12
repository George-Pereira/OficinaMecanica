package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import entity.Funcionario;
import entity.Ordem_Servico;
import entity.Servico;
import entity.Veiculo;

public class DaoOrdemServicoconc implements DaoOrdemServico
{
private Connection conexao;
	
	public DaoOrdemServicoconc() throws DaoException, ClassNotFoundException, SQLException
	{
		DaoGenerica i = new DaoGenericoconc();
		conexao = i.getConnection();
	}
	@Override
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
				os2.setNomeV(v.getId());
				
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
	
	public void novaOrdemServico(Ordem_Servico os, Veiculo v, Funcionario func) 
	{
		try {
			String commando = "SELECT id_os FROM OrdemServico";
			PreparedStatement statement = conexao.prepareStatement(commando);
			ResultSet set = statement.executeQuery();
			set.last();
			Long ordem = (set.getLong("id_os")+1);
			set.close();
			for(Servico service : os.getServs()) 
			{
				String sql = "INSERT INTO ordemServico " + "(id_os, id_servico, id_veiculo, id_funcionario, dt_entrada, dt_saida) " + "VALUES " + "(?,?,?,?,?,?)";
				PreparedStatement state = conexao.prepareStatement(sql);
				state.setLong(1, ordem);
				state.setLong(2, service.getId());
				state.setLong(3, v.getId());
				state.setLong(4, func.getId());
				java.sql.Date dent = new java.sql.Date(os.getDtEntrada().getTime());
				state.setDate(5, dent);
				java.sql.Date dsai = new java.sql.Date(os.getDtSaida().getTime());
				state.setDate(6, dsai);
				state.execute();
				state.close();
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	@Override
	public List<Servico> getServicosOS(Ordem_Servico os) throws DaoException 
	{
		List<Servico> services = new LinkedList<Servico>();
		try {
			for(Servico serv : os.getServs()) 
			{
				String sql = "SELECT id_servico, nome_Servico, custo FROM Servico serv INNER JOIN OrdemServico os ON os.id_Servico = serv.id_Servico WHERE id_os = ?";
				PreparedStatement state = conexao.prepareStatement(sql);
				state.setLong(1, serv.getId());
				ResultSet results = state.executeQuery();
				while(results.next())
				{
					Servico service = new Servico();
					service.setId(results.getLong("id_Servico"));
					service.setNomeServ(results.getString("nome_Servico"));
					service.setValueServ(results.getDouble("custo"));
					services.add(service);
				}
				results.close();
				state.close();
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return services;
	}
}
