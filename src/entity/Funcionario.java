package entity;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Funcionario 
{
	private String nomeFunc;
	private String cartTrab;
	private String cpf;
	private String telefone;
	private ObservableList<Servico> habilidades = FXCollections.observableArrayList();
	
	public Funcionario() 
	{
		
	}
	public Funcionario(String nomeFunc, String cartTrab, String cpf, String telefone) 
	{
		this.nomeFunc = nomeFunc;
		this.cartTrab = cartTrab;
		this.cpf = cpf;
		this.telefone = telefone;
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
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		telefone = telefone;
	}
	
}
