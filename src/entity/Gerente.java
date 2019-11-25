package entity;

public class Gerente 
{
	private long id;
	private String nome_Gerente;
	private String cartTrab;
	private double salario;
	public Gerente() 
	{
		
	}
	public Gerente(long id, String nome_Gerente, String cartTrab, double salario, String telefone) {
		super();
		this.id = id;
		this.nome_Gerente = nome_Gerente;
		this.cartTrab = cartTrab;
		this.salario = salario;
		this.telefone = telefone;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome_Gerente() {
		return nome_Gerente;
	}
	public void setNome_Gerente(String nome_Gerente) {
		this.nome_Gerente = nome_Gerente;
	}
	public String getCartTrab() {
		return cartTrab;
	}
	public void setCartTrab(String cartTrab) {
		this.cartTrab = cartTrab;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	private String telefone;
	
}
