package entity;

import java.util.Date;

public class Servico 
{
	private String nomeServ;
	private String descServ;
	private boolean servDisp;
	private Date DtSaida;
	
	public Servico() 
	{
		
	}
	public Servico(Date d1) {
		this.DtSaida = d1;
	}

	public Servico(String nomeServ, String descServ, boolean servDisp, Date D1) 
	{
		this(D1);
		this.nomeServ = nomeServ;
		this.descServ = descServ;
		this.servDisp = servDisp;
	}

	public String getNomeServ() 
	{
		return nomeServ;
	}
	public void setNomeServ(String nomeServ) 
	{
		this.nomeServ = nomeServ;
	}
	public String getDescServ() {
		return descServ;
	}
	public void setDescServ(String descServ) 
	{
		this.descServ = descServ;
	}
	public boolean isServDisp() 
	{
		return servDisp;
	}
	public void isServDisp(boolean servDisp) 
	{
		this.servDisp = servDisp;
	}
	
	public void setDtSaida(Date dtSaida) {
		this.DtSaida = dtSaida;
	}
	
	public Date getDtSaida() {
		return DtSaida;
	}
}
