package dao;

import java.util.List;

import entity.Gerente;

public interface DaoGerente 
{
	void adicionarGerente(Gerente ger) throws DaoException;
	void editarGerente(Gerente ger) throws DaoException;
	void desativaGerente(Gerente ger) throws DaoException;
	List<Gerente> getGerente() throws DaoException;
	Gerente pesquisaGerente(String varpesq) throws DaoException;
}
