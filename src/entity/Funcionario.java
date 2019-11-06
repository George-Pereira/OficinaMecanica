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
	
	public Funcionario() 
	{
		
	}
	public Funcionario(String nomeFunc, String cartTrab, String cpf, String telefone, double salario) 
	{
		this.nomeFunc = nomeFunc;
		this.cartTrab = cartTrab;
		this.cpf = cpf;
		this.telefone = telefone;
		this.salario = salario;
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
		this.telefone = telefone;
	}
	public boolean getAtividade() {
		return atividade;
	}
	public void setAtividade(boolean atividade) {
		this.atividade = atividade;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
}
