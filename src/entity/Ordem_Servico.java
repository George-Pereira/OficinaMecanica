package entity;

import java.util.Date;

public class Ordem_Servico 
{
	private Date dtEntrada;
	private Date dtSaida;
	private String nome;
	private int OS;
	private String nomeS;
	private String nomeV;
	
	public Ordem_Servico(String nomeVeiculo, Date dtEntrada) {
		this.nomeV = nomeVeiculo;
		this.dtEntrada = dtEntrada;
	}
	
	public Ordem_Servico(int OS, String nomeS, Date d1, String nomeFunc, Date dtEntrada, String nomeVeiculo) {
		this(nomeVeiculo, dtEntrada);
		this.OS = OS;
		this.nomeS = nomeS;
		this.dtSaida = d1;
		this.nome = nomeFunc;
	}
	
	public Ordem_Servico() {
		
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
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getOS() {
		return OS;
	}
	
	public void setOS(int oS) {
		OS = oS;
	}
	
	public String getNomeS() {
		return nomeS;
	}
	public void setNomeS(String nomeS) {
		this.nomeS = nomeS;
	}
	
	public String getNomeV() {
		return nomeV;
	}
	
	public void setNomeV(String nomeV) {
		this.nomeV = nomeV;
	}
	
	
}

