package entity;

public class Modelo 
{
	private long id;
	private String nome_Modelo;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome_Modelo() {
		return nome_Modelo;
	}
	public void setNome_Modelo(String nome_Modelo) {
		this.nome_Modelo = nome_Modelo;
	}
	public Modelo(long id, String nome_Modelo) {
		super();
		this.id = id;
		this.nome_Modelo = nome_Modelo;
	}
	public Modelo() 
	{
		
	}
}
