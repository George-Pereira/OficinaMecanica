package controller;

import java.util.Date;

import entity.Servico;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ControlServico 
{
	private static ObservableList<Servico> listaServ = FXCollections.observableArrayList();
	private static ObservableList<Servico> listaS = FXCollections.observableArrayList();
	
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
	
	public void inseredt(String nome, Date d) {
		for(Servico serv: listaServ) {
			if(serv.getNomeServ().equals(nome) && serv.getDtSaida() == null) {
				Servico se = new Servico(serv.getNomeServ(), serv.getDescServ(), serv.isServDisp(), d);
				listaS.add(se);
			}
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
		ControlServico.listaServ = listaServ;
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
	
	public ObservableList<Servico> getListaS() {
		return listaS;
	}
	
	public static void setListaS(ObservableList<Servico> listaS) {
		ControlServico.listaS = listaS;
	}
	
	public void LimpaLista() {
		listaS.clear();
	}
}
