package controller;

import entity.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ControlCliente 
{
	private static ObservableList<Cliente> lista = FXCollections.observableArrayList();

	public boolean existenciaCliente(Cliente c) 
	{ 
		for(Cliente cli : lista) 
		{
			if((cli.getCNH().equals(c.getCNH())|| cli.getCPF().equals(c.getCPF()))) 
			{
				return true;
			}
		}
		return false;
	}

	public void adicionar(Cliente c) 
	{
		if(!existenciaCliente(c)) 
		{
			lista.add(c);
		}
	}
	public Cliente pesquisarPorCPF(String CPF) { 
		for (Cliente c : lista) { 
			if (c.getCPF().contains(CPF)) { 
				return c;
			}
		}
		return null;
	}
	
	public Cliente pesquisarPorNome(String Nome) { 
		for (Cliente c : lista) { 
			if (c.getNome().contains(Nome)) { 
				return c;
			}
		}
		return null;
	}
	
	public Cliente pesquisarPorCNH(String CNH) { 
		for (Cliente c : lista) { 
			if (c.getCPF().contains(CNH)) { 
				return c;
			}
		}
		return null;
	}

	public ObservableList<Cliente> getLista() {
		return lista;
	}

	public void setLista(ObservableList<Cliente> lista) {
		this.lista = lista;
	}
}

