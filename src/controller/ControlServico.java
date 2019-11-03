package controller;

import entity.Servico;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ControlServico 
{
	private ObservableList<Servico> listaServ = FXCollections.observableArrayList();

	public boolean existenciaServico(Servico servico) 
	{
		for(Servico serv: listaServ) 
		{
			if(serv.getNomeServ().equals(servico.getNomeServ()))
			{
				return true;
			}
		}
		return false;
	}
	public void insertServico(Servico serv) 
	{
		if(!existenciaServico(serv)) 
		{
			listaServ.add(serv);
		}
	}
	public void desatServ(Servico serv) 
	{
		for(Servico ser : listaServ) 
		{
			if(serv.getNomeServ().equals(ser.getNomeServ())) 
			{
				listaServ.remove(ser);
				break;
			}
		}
	}
	public ObservableList<Servico> getListaServ() 
	{
		return listaServ;
	}

	public void setListaServ(ObservableList<Servico> listaServ) 
	{
		this.listaServ = listaServ;
	}
	public Servico pesquisaServ(String nome) 
	{
		for(Servico serv: listaServ) 
		{
			if(serv.getNomeServ().contentEquals(nome)) 
			{
				return serv;
			}
		}
		return null;
	}
	
}