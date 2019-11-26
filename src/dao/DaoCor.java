package dao;

import java.util.List;

import entity.Cor;

public interface DaoCor 
{
	List<Cor> getCores() throws DaoException;
}
