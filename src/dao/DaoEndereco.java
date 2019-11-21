package dao;

import java.util.List;

import entity.Cliente;
import entity.Endereco;

public interface DaoEndereco 
{
	void adicionarEndereco(Cliente cli, Endereco end) throws DaoException;
	List<Endereco> enderecosCliente(Cliente cli) throws DaoException;
	void removeEndereco(Cliente cli, Endereco end) throws DaoException;
}
