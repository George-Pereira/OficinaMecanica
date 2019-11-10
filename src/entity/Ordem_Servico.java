package entity;

import java.util.Date;

public class Ordem_Servico 
{
	private Date dtEntrada;
	private Date dtSaida;
	private String nomeS;
	
	public Ordem_Servico(String nomeS, Date dateEntrada, Date dateSaida) {
		this.nomeS = nomeS;
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
	
}
