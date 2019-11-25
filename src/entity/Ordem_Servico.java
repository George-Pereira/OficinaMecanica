package entity;

import java.util.Date;

public class Ordem_Servico 
{
	private Date dtEntrada;
	private Date dtSaida;
	private String nome;
	private long OS;
	private Servico nomeS;
	private Veiculo veic;
	public Ordem_Servico(Veiculo veic, Date dtEntrada) 
	{
		this.veic = veic;
		this.dtEntrada = dtEntrada;
	}
	
	public Ordem_Servico(long OS, Servico nomeS, Date dtSaida, String nomeFunc, Date dtEntrada, Veiculo veic) {
		this(veic, dtEntrada);
		this.OS = OS;
		this.nomeS = nomeS;
		this.dtSaida = dtSaida;
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
	
	public long getOS() {
		return OS;
	}
	
	public void setOS(long oS) {
		OS = oS;
	}
	
	public Servico getNomeS() {
		return nomeS;
	}
	public void setNomeS(Servico serv) {
		this.nomeS = serv;
	}
	
	public Veiculo getNomeV() 
	{
		return veic;
	}
	
	public void setNomeV(Veiculo veic) 
	{
		this.veic = veic;
	}
	
	
}

