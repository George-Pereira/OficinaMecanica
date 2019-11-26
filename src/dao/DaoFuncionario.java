package dao;

import java.util.List;

import entity.Funcionario;
import entity.Gerente;
import entity.Servico;

public interface DaoFuncionario 
{
	void adicionarFuncionario(Funcionario func, Gerente ger) throws DaoException;
	void editarFuncionario(Funcionario func) throws DaoException;
	void removerFuncionario(Funcionario func) throws DaoException;
	void adicionarHabilidades(Funcionario func, Servico serv) throws DaoException;
	List<Funcionario> getFuncionarios() throws DaoException;
	List<Funcionario> getHabilitados(Servico serv) throws DaoException;
	Funcionario pesqFuncionario(String nome) throws DaoException;
	boolean existenciaFuncionario(Funcionario func) throws DaoException;
	List<Servico> getHabilidades(Funcionario func) throws DaoException;
}
