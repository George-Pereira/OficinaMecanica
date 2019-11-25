package controller;


import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import dao.DaoException;
import dao.DaoFuncionario;
import dao.DaoFuncionarioconc;
import entity.Funcionario;
import entity.Gerente;
import entity.Servico;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ControlFuncionario 
{
	private ObservableList<Funcionario> listaFunc = FXCollections.observableArrayList();
	public void insertFuncionario(Funcionario func, Gerente ger) 
	{
		try {
			DaoFuncionario dao= new DaoFuncionarioconc();
			listaFunc.add(func);
			dao.adicionarFuncionario(func, ger);
		} catch (DaoException | SQLException e) 
		{
			e.printStackTrace();
		}
	}
	public Funcionario pesqFuncionario(String nome) 
	{
		Funcionario func = new Funcionario();
		try {
			DaoFuncionario dao = new DaoFuncionarioconc();
			func = dao.pesqFuncionario(nome);
		} 
		catch (DaoException | SQLException e) 
		{
			e.printStackTrace();
		}
		return func;
	}
	public void removeFunc(Funcionario func) 
	{

	}
	public void insereHabilidade(Funcionario func, Servico serv) 
	{
		try {
			DaoFuncionario dao = new DaoFuncionarioconc();
			dao.adicionarHabilidades(func, serv);
		} catch (DaoException | SQLException e) 
		{
			e.printStackTrace();
		}
	}
	public ObservableList<Funcionario> getFuncionarios()
	{
		List<Funcionario> funcions = new LinkedList<Funcionario>();
		try 
		{
			DaoFuncionario dao = new DaoFuncionarioconc();
			funcions = dao.getFuncionarios();
			for(Funcionario func : funcions) 
			{
				listaFunc.add(func);
			}
		}
		catch (DaoException | SQLException e) 
		{
			e.printStackTrace();
		}
		return listaFunc;
	}
}

