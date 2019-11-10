package entity;

import java.util.Date;

public class Servico 
{
	private static String nomeServ;
	private String descServ;
	private boolean servDisp;
	private static Date DtSaida;
	
	public Servico(String nomeServ, String descServ, boolean servDisp) 
	{
		this.nomeServ = nomeServ;
		this.descServ = descServ;
		this.servDisp = servDisp;
	}
	
	public static String getNomeServ() 
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
	public Servico() 
	{
		
	}
	public boolean getServDisp() 
	{
		return servDisp;
	}
	public void setServDisp(boolean servDisp) 
	{
		this.servDisp = servDisp;
	}
	
	public static void setDtSaida(Date dtSaida) {
		DtSaida = dtSaida;
	}
	
	public Date getDtSaida() {
		return DtSaida;
	}
}
