package entity;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cliente {
	private String Nome;
	private String CNH;
	private String Telefone ;
	private String CPF ;
	private ObservableList<Endereco> enderecos = FXCollections.observableArrayList();
	private ObservableList<Veiculo> posses = FXCollections.observableArrayList();

	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		this.Nome = nome;
	}
	public String getCNH() {
		return CNH;
	}
	public void setCNH(String CNH) {
		this.CNH = CNH;
	}
	public String getTelefone() {
		return Telefone;
	}
	public void setTelefone(String telefone) {
		this.Telefone = telefone;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		this.CPF = cPF;
	}
	public ObservableList<Veiculo> getPosses() {
		return posses;
	}
	public void setPosses(ObservableList<Veiculo> posses) {
		this.posses = posses;
	}
	@Override
	public String toString() 
	{
		return this.Nome;
	}
	public ObservableList<Endereco> getEnderecos() 
	{
		return enderecos;
	}
	public void setEnderecos(ObservableList<Endereco> enderecos) 
	{
		this.enderecos = enderecos;
	}
}