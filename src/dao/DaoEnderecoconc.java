package dao;

import java.util.List;

import entity.Cliente;
import entity.Endereco;

public class DaoEnderecoconc implements DaoEndereco
{

	@Override
	public void adicionarEndereco(Cliente cli, Endereco end) throws DaoException 
	{
		
	}
	@Override
	public List<Endereco> enderecosCliente(Cliente cli) throws DaoException 
	{
		return null;
	}

	@Override
	public void removeEndereco(Cliente cli, Endereco end) throws DaoException 
	{
		
	}

}
