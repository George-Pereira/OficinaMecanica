package controller;


import entity.Funcionario;
import entity.Servico;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ControlFuncionario 
{
	private static ObservableList<Funcionario> listaFunc = FXCollections.observableArrayList();
	public void insertFuncionario(Funcionario func) 
	{
		if(!existenciaFunc(func)) 
		{
			listaFunc.add(func);
		}
	}
	public Funcionario pesqFuncionario(String nome) 
	{
		for(Funcionario func : listaFunc) 
		{
			if(func.getNomeFunc().equals(nome)) 
			{
				return func;
			}
		}
		return null;
	}
	public boolean existenciaFunc(Funcionario func) 
	{
		for(Funcionario fun : listaFunc) 
		{
			if(fun.getCartTrab().equals(func.getCartTrab())) 
			{
				return true;
			}
		}
		return false;
	}
	public void removeFunc(Funcionario func) 
	{
		for(Funcionario fun : listaFunc) 
		{
			if(fun.getCartTrab().equals(func.getCartTrab())) 
			{
				listaFunc.remove(fun);
			}
		}
	}
	public boolean existenciaHabilidade(Funcionario func, Servico serv) 
	{
		for(Servico ser : func.getHabilidades()) 
		{
			if(ser.getNomeServ().equals(serv.getNomeServ())) 
			{
				return true;
			}
		}
		return false;
	}
	public void insereHabilidade(Funcionario func, Servico serv) 
	{
		if(!(existenciaHabilidade(func, serv))) 
		{
			func.getHabilidades().add(serv);
		}
	}
	public ObservableList<Funcionario> getListaFunc() {
		return listaFunc;
	}

	public void setListaFunc(ObservableList<Funcionario> listaFunc) {
		ControlFuncionario.listaFunc = listaFunc;
	}
}
