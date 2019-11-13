package entity;

import java.util.Date;

import javafx.collections.ObservableList;

public class Ordem_Servico 
{
	private Date dtEntrada;
	private Date dtSaida;
	private Funcionario nome;
	private int OS;
	private String nomeS;
	private Veiculo nomeV;
	
	public Ordem_Servico(Veiculo nomeV, Date dtEntrada) {
		this.nomeV = nomeV;
		this.dtEntrada = dtEntrada;
	}
	
	public Ordem_Servico(int OS, String nomeS, Date dtSaida, Funcionario nome, Date dtEntrada, Veiculo nomeV) {
		this(nomeV, dtEntrada);
		this.OS = OS;
		this.nomeS = nomeS;
		this.dtSaida = dtSaida;
		this.nome = nome;
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
	
	public Funcionario getNome() {
		return nome;
	}
	
	public void setNome(Funcionario nome) {
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
	
	public Veiculo getNomeV() {
		return nomeV;
	}
	
	public void setNomeV(Veiculo nomeV) {
		this.nomeV = nomeV;
	}
	
	
}
