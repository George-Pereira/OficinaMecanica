package dao;

import entity.Cliente;

public interface InterfaceCliente 
{
	void adicionarCliente(Cliente cli) throws DaoException;
	void editarCliente(Cliente cli) throws DaoException;
	Cliente pesquisarCliente(String nome) throws DaoException;
}
