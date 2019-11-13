package entity;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Funcionario 
{
	private String nomeFunc;
	private String cartTrab;
	private String cpf;
	private String telefone;
	private boolean atividade;
	private double salario;
	private ObservableList<Servico> habilidades = FXCollections.observableArrayList();
	
	@Override
	public String toString() {
		return nomeFunc;
	}
	public Funcionario() 
	{
		
	}
	public Funcionario(String nomeFunc, String cartTrab, String cpf, String telefone, double salario, boolean Check) 
	{
		this.nomeFunc = nomeFunc;
		this.cartTrab = cartTrab;
		this.cpf = cpf;
		this.telefone = telefone;
		this.salario = salario;
		this.atividade = Check;
	}
	public ObservableList<Servico> getHabilidades() {
		return habilidades;
	}
	public void setHabilidades(ObservableList<Servico> habilidades) {
		this.habilidades = habilidades;
	}
	public String getNomeFunc() {
		return nomeFunc;
	}
	public void setNomeFunc(String nomeFunc) {
		this.nomeFunc = nomeFunc;
	}
	public String getCartTrab() {
		return cartTrab;
	}
	public void setCartTrab(String cartTrab) {
		this.cartTrab = cartTrab;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) 
	{
		if(cpf.length() == 11) 
		{
			this.cpf = cpf;
		}
	}
	public String getTelefone() 
	{
		return telefone;
	}
	public void setTelefone(String telefone) 
	{
		boolean valido = true;
		if(telefone.length() == 11 || telefone.length() == 8) 
		{
			char [] tel = telefone.toCharArray();
			for(int cta = 0; cta < telefone.length(); cta++) 
			{
				if(Character.isAlphabetic(tel[cta]))
				{
					valido = false;
					break;
				}
			}
			if(valido == true) 
			{
				this.telefone = telefone;
			}
		}
	}
	public boolean getAtividade() 
	{
		return atividade;
	}
	public void setAtividade(boolean atividade) {
		this.atividade = atividade;
	}
	public double getSalario() 
	{
		return salario;
	}
	public void setSalario(double salario) 
	{
		if(salario > 4.54) 
		{
			this.salario = salario;
		}
	}
	
}

