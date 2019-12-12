package controller;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import dao.DaoException;
import dao.DaoServico;
import dao.DaoServicoconc;
import entity.Servico;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ControlServico 
{
	private ObservableList<Servico> listaServ = FXCollections.observableArrayList();
	
	public boolean existenciaServico(Servico servico) 
	{
		DaoServico serv;
		try {
			serv = new DaoServicoconc();
			return serv.consultaExistencia(servico);
		} catch (DaoException | SQLException e) 
		{
			e.printStackTrace();
		}
		return true;
	}
	public void insertServico(Servico serv) 
	{
		try {
			DaoServico servico = new DaoServicoconc();
			if(!servico.consultaExistencia(serv)) 
			{
				servico.adicionarServico(serv);
			}
			listaServ.add(serv);
		}
		catch (DaoException | SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void desatServ(Servico serv) 
	{
		try {
			DaoServico servico = new DaoServicoconc();
			servico.desativarServico(serv);
		} catch (DaoException | SQLException e) 
		{
			e.printStackTrace();
		}
	}

	public Servico pesquisaServ(String nome) 
	{
		Servico serv = new Servico();
		try {
			DaoServico servicos= new DaoServicoconc();
			serv = servicos.pesquisarServico(nome);
		} catch (DaoException | SQLException e) 
		{
			e.printStackTrace();
		}
		return serv;
	}
	public ObservableList<Servico> getServicos()
	{
		List<Servico> servicos = new LinkedList<Servico>();
		try {
			DaoServico servs= new DaoServicoconc();
			servicos = servs.getServicos();
			for(Servico ser : servicos) 
			{
				listaServ.add(ser);
			}
		}
		catch (SQLException |DaoException e) 
		{
			e.printStackTrace();
		}
		return listaServ;
	}
}