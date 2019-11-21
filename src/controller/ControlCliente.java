package controller;

import java.sql.SQLException;

import dao.DaoClienteconc;
import dao.DaoException;
import dao.DaoCliente;
import entity.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ControlCliente 
{
	//private ObservableList<Cliente> lista = FXCollections.observableArrayList();

	/*public boolean existenciaCliente(Cliente c) 
	{ 
		for(Cliente cli : lista) 
		{
			if((cli.getCNH().equals(c.getCNH())|| cli.getCPF().equals(c.getCPF()))) 
			{
				return true;
			}
		}
		return false;
	}*/

	public void adicionar(Cliente c) 
	{
		try 
		{
			DaoCliente iCliente = new DaoClienteconc();
			iCliente.adicionarCliente(c);
		} 
		catch (ClassNotFoundException | DaoException | SQLException e) 
		{	
			e.printStackTrace();
		}
	}
	public Cliente pesquisarPorCPF(String CPF) { 
		Cliente cli = new Cliente();
		try 
		{
			DaoCliente iCliente = new DaoClienteconc();
			cli = iCliente.pesquisarCliente(CPF);
		} 
		catch (ClassNotFoundException | DaoException | SQLException e) 
		{	
			e.printStackTrace();
		}
		return cli;
	}
	public Cliente pesquisarPorNome(String nome) { 
		Cliente cli = new Cliente();
		try 
		{
			DaoCliente iCliente = new DaoClienteconc();
			cli = iCliente.pesquisarCliente(nome);
		} 
		catch (ClassNotFoundException | DaoException | SQLException e) 
		{	
			e.printStackTrace();
		}
		return cli;
	}
	
	public Cliente pesquisarPorCNH(String cnh) 
	{ 
		Cliente cli  = new Cliente();
		try 
		{
			DaoCliente iCliente = new DaoClienteconc();
			cli = iCliente.pesquisarCliente(cnh);
		} 
		catch (ClassNotFoundException | DaoException | SQLException e) 
		{	
			e.printStackTrace();
		}
		return cli;
	}
	public ObservableList<Cliente> getClientes()
	{
		ObservableList<Cliente> clientes = FXCollections.observableArrayList();
		try {
			DaoCliente iCliente = new DaoClienteconc();
			clientes = (ObservableList<Cliente>) iCliente.getClientes();
		} 
		catch (ClassNotFoundException | DaoException | SQLException e) 
		{
			e.printStackTrace();
		}
		return clientes;
	}
}

