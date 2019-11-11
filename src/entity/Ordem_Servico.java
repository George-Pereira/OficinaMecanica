package entity;

import java.util.Date;

import javafx.collections.ObservableList;

public class Ordem_Servico 
{
	private Date dtEntrada;
	private Date dtSaida;
	private ObservableList<Servico> list;
	
	public Ordem_Servico(ObservableList<Servico> Servicos, Date dateEntrada, Date dateSaida) {
		this.list = Servicos;
		this.dtSaida = dateEntrada;
		this.dtEntrada = dateSaida;
	}
	
	public Date getDtEntrada() {
		return dtEntrada;
	}
	
	public void setDtEntrada(Date dtEntrada) {
		this.dtEntrada = dtEntrada;
	}
	
	public Date getDtSaida() {
		return dtSaida;
	}
	
	public void setDtSaida(Date dtSaida) {
		this.dtSaida = dtSaida;
	}
	
	public ObservableList<Servico> getList() {
		return list;
	}
	
	public void setList(ObservableList<Servico> list) {
		this.list = list;
	}
	
	
}
