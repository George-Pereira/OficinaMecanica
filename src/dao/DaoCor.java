package dao;

import java.util.List;

import entity.Cor;

public interface DaoCor 
{
	void adicionaCor(String nomeCor) throws DaoException;
	List<Cor> getCores() throws DaoException;
	boolean confereCor(String nomeCor) throws DaoException;
}
