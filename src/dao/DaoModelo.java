package dao;
import java.util.List;

import entity.Marca;
import entity.Modelo;
public interface DaoModelo 
{
	boolean consultaExistencia(String modelo) throws DaoException;
	List<Modelo> getModelos(Marca marca) throws DaoException;
	void adicionaModelo(Modelo model, Marca marca) throws DaoException;
}
