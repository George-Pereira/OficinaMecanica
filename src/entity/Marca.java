package entity;

public class Marca 
{
	private long id;
	private String nome_Marca;
	
	@Override
	public String toString() 
	{
		return this.nome_Marca;
	}
	
	public Marca(int id, String nome_marca) 
	{
		this.id = id;
		this.nome_Marca = nome_marca;
	}
	public Marca() {
	}
	public String getNome_Marca() 
	{
		return nome_Marca;
	}
	public void setNome_Marca(String nome_Marca) {
		this.nome_Marca = nome_Marca;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
