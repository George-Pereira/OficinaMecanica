package controller;

import entity.Funcionario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ControlFuncionario 
{
	private ObservableList<Funcionario> listaFunc = FXCollections.observableArrayList();
	public void insertFuncionario(Funcionario func) 
	{
		
	}
	public boolean existenciaFunc(Funcionario func) 
	{
		return false;
	}
	public void removeFunc() 
	{
		
	}
	public ObservableList<Funcionario> getListaFunc() {
		return listaFunc;
	}

	public void setListaFunc(ObservableList<Funcionario> listaFunc) {
		this.listaFunc = listaFunc;
	}
}
