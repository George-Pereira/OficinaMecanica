package controller;

import java.sql.SQLException;

import dao.DaoCliente;
import dao.DaoException;
import dao.InterfaceCliente;
import entity.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ControlCliente 
{
	private ObservableList<Cliente> lista = FXCollections.observableArrayList();

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
			InterfaceCliente iCliente = new DaoCliente();
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
			InterfaceCliente iCliente = new DaoCliente();
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
			InterfaceCliente iCliente = new DaoCliente();
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
			InterfaceCliente iCliente = new DaoCliente();
			cli = iCliente.pesquisarCliente(cnh);
		} 
		catch (ClassNotFoundException | DaoException | SQLException e) 
		{	
			e.printStackTrace();
		}
		return cli;
	}
	public ObservableList<Cliente> getLista() {
		return lista;
	}

	public void setLista(ObservableList<Cliente> lista) {
		this.lista = lista;
	}
}

