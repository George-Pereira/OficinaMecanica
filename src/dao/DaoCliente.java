package dao;

import java.util.List;

import entity.Cliente;

public interface DaoCliente 
{
	void adicionarCliente(Cliente cli) throws DaoException;
	void editarCliente(Cliente cli) throws DaoException;
	Cliente pesquisarCliente(String nome) throws DaoException;
	List<Cliente> getClientes() throws DaoException;
}
