package controller;

import entity.Servico;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ControlServico 
{
	private static ObservableList<Servico> listaServ = FXCollections.observableArrayList();

	public static boolean existenciaServico(Servico servico) 
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
	public static void insertServico(Servico serv) 
	{
		if(!existenciaServico(serv)) 
		{
			listaServ.add(serv);
		}
	}
	public static void desatServ(Servico serv) 
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
	public static ObservableList<Servico> getListaServ() 
	{
		return listaServ;
	}

	public static void setListaServ(ObservableList<Servico> listaServ) 
	{
		ControlServico.listaServ = listaServ;
	}
	public static Servico pesquisaServ(String nome) 
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
