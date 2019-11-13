package entity;

public class Servico 
{
	private String nomeServ;
	private String descServ;
	private boolean servDisp;
	private Funcionario nomeF;
	
	public Servico() 
	{
		
	}

	public Servico(String nomeServ, String descServ, boolean servDisp) 
	{
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
	
	public Funcionario getNomeF() {
		return nomeF;
	}
	public void setNomeF(Funcionario nomeF) {
		this.nomeF = nomeF;
	}

}
