package entity;

public class Cor 
{
	private long id;
	private String nome_Cor;
	public long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCor() {
		return nome_Cor;
	}
	public void setCor(String nome_Cor) {
		this.nome_Cor = nome_Cor;
	}
	public Cor(long id, String nome_Cor) 
	{
		this.id = id;
		this.nome_Cor = nome_Cor;
	}
	public Cor() {
		// TODO Auto-generated constructor stub
	}
	
}
