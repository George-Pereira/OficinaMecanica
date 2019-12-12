package dao;
import java.util.List;

import entity.Marca;
import entity.Modelo;
public interface DaoModelo 
{
	boolean consultaExistencia(String modelo) throws DaoException;
	List<Modelo> getModelos(long marca) throws DaoException;
	void adicionaModelo(Modelo model, long marca) throws DaoException;
	Modelo pesqModelo(String model) throws DaoException;
}
