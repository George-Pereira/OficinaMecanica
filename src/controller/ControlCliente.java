package controller;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import dao.DaoClienteconc;
import dao.DaoException;
import dao.DaoCliente;
import entity.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ControlCliente
{
	
	private ObservableList<Cliente> lista = FXCollections.observableArrayList();

	public void adicionar(Cliente c) 
	{
		try 
		{
			DaoCliente iCliente = new DaoClienteconc();
			iCliente.adicionarCliente(c);
			lista.add(c);
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
	public Cliente pesquisarPorNome(String nome) 
	{ 
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
		List<Cliente> clientes = new LinkedList<Cliente>();
		try {
			DaoCliente iCliente = new DaoClienteconc();
			clientes = iCliente.getClientes();
			for(Cliente cli : clientes) 
			{
				lista.add(cli);
			}
		} 
		catch (ClassNotFoundException | DaoException | SQLException e) 
		{
			e.printStackTrace();
		}
		return lista;
	}
}

