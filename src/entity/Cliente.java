package entity;


public class Cliente 
{
	private long id;
	private String Nome;
	private String CNH;
	private String Telefone ;
	private String CPF ;
	public String getNome() 
	{
		return Nome;
	}
	public void setNome(String nome) 
	{
		this.Nome = nome;
	}
	public String getCNH() 
	{
		return CNH;
	}
	public void setCNH(String CNH) 
	{
		if(CNH.length() == 11) 
		{
			this.CNH = CNH;
		}
	}
	public String getTelefone() 
	{
		return Telefone;
	}
	public void setTelefone(String telefone) 
	{
		if(telefone.length() == 11 || telefone.length() == 10) 
		{
			this.Telefone = telefone;
		}
	}
	public String getCPF() 
	{
		return CPF;
	}
	public void setCPF(String CPF) 
	{
		if(CPF.length() ==11) 
		{
			this.CPF = CPF;
		}
	}
	@Override
	public String toString() 
	{
		return this.Nome;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) 
	{
		this.id = id;
	}
}