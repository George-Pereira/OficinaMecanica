package dao;

import java.util.List;

import entity.Marca;

public interface DaoMarca 
{
	void adicionarMarca(String marca) throws DaoException;
	List<Marca> getMarca() throws DaoException;
}
