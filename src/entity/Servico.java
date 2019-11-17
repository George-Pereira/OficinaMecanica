package entity;

public class Servico 
{
	private long id;
	private String nomeServ;
	private String descServ;
	private double valueServ;
	private boolean servDisp;
	private Funcionario nomeF;
	
	public Servico() 
	{
		
	}

	public Servico(String nomeServ, String descServ, boolean servDisp, double valueServ) 
	{
		this.nomeServ = nomeServ;
		this.descServ = descServ;
		this.servDisp = servDisp;
		this.valueServ = valueServ;
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
	
	public Funcionario getNomeF() {
		return nomeF;
	}
	public void setNomeF(Funcionario nomeF) {
		this.nomeF = nomeF;
	}

	public double getValueServ() {
		return valueServ;
	}

	public void setValueServ(double valueServ) {
		this.valueServ = valueServ;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
