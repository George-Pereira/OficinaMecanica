package controller;

import entity.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ControlCliente {
	private static ObservableList<Cliente> lista = FXCollections.observableArrayList();

	public static boolean existenciaCliente(Cliente c) 
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

	public static void adicionar(Cliente c) 
	{
		if(!existenciaCliente(c)) 
		{
			lista.add(c);
		}
	}
	public static Cliente pesquisarPorCPF(String CPF) { 
		for (Cliente c : lista) { 
			if (c.getCPF().contains(CPF)) { 
				return c;
			}
		}
		return null;
	}
	
	public static Cliente pesquisarPorNome(String Nome) { 
		for (Cliente c : lista) { 
			if (c.getNome().contains(Nome)) { 
				return c;
			}
		}
		return null;
	}
	
	public static Cliente pesquisarPorCNH(String CNH) { 
		for (Cliente c : lista) { 
			if (c.getCPF().contains(CNH)) { 
				return c;
			}
		}
		return null;
	}

	public static ObservableList<Cliente> getLista() {
		return lista;
	}

	public static void setLista(ObservableList<Cliente> lista) {
		ControlCliente.lista = lista;
	}
}

