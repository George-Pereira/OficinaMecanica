package controller;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import dao.DaoException;
import dao.DaoOrdemServico;
import dao.DaoOrdemServicoconc;
import entity.Funcionario;
import entity.Ordem_Servico;
import entity.Servico;
import entity.Veiculo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ControlManterOrdemServico 
{
	private ObservableList<Ordem_Servico> listaOS = FXCollections.observableArrayList();

	public ObservableList<Ordem_Servico> getServicos(Ordem_Servico os) 
	{
		try {
			List<Ordem_Servico> oss = new LinkedList<Ordem_Servico>();
			DaoOrdemServico dao = new DaoOrdemServicoconc();
			oss = dao.getServicos(os);
			for(Ordem_Servico serv : oss) 
			{
				listaOS.add(serv);
			}
		}
		catch (ClassNotFoundException | DaoException | SQLException e)
		{
			e.printStackTrace();
		}
		return listaOS;
	}
	public void adicionaOS(Ordem_Servico os, Veiculo v, Funcionario func) 
	{
		try {
			DaoOrdemServico dao = new DaoOrdemServicoconc();
			dao.novaOrdemServico(os, v, func);
		}
		catch (ClassNotFoundException | DaoException | SQLException e) 
		{
			e.printStackTrace();
		}
	}

}