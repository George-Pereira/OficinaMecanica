package entity;

public class Endereco 
{
	private long id;
	private String Logradouro ;
	private int Numero;
	private String Bairro;
	
	public Endereco () 
	{
		
	}
	public Endereco(String logradouro, int numero, String bairro) 
	{
		this.Logradouro = logradouro;
		this.Numero = numero;
		this.Bairro = bairro;
	}
	public String getLogradouro() {
		return Logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.Logradouro = logradouro;
	}
	public String getBairro() {
		return Bairro;
	}
	public void setBairro(String bairro) {
		this.Bairro = bairro;
	}
	public int getNumero() {
		return Numero;
	}
	public void setNumero(int numero) {
		this.Numero = numero;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
