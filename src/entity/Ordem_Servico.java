package entity;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Ordem_Servico 
{
	private Date dtEntrada;
	private Date dtSaida;
	private String nome;
	private long OS;
	private List<Servico> servs = new LinkedList<Servico>();
	private long veic;
	public Ordem_Servico(long veic, Date dtEntrada) 
	{
		this.veic = veic;
		this.dtEntrada = dtEntrada;
	}
	
	public Ordem_Servico(long OS, List<Servico> servs, Date dtSaida, String nomeFunc, Date dtEntrada, long veic) {
		this(veic, dtEntrada);
		this.OS = OS;
		this.servs = servs;
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
	
	
	public List<Servico> getServs() {
		return servs;
	}

	public void setServs(List<Servico> servs) {
		this.servs = servs;
	}

	public long getVeic() {
		return veic;
	}

	public void setVeic(long veic) {
		this.veic = veic;
	}

	public long getNomeV() 
	{
		return veic;
	}
	
	public void setNomeV(long veic) 
	{
		this.veic = veic;
	}
	
	
}

