package controller;
import entity.Cliente;
import entity.Veiculo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ControlVeiculo 
{
	private static ObservableList<String> modelos = FXCollections.observableArrayList();
	private static ObservableList<Veiculo> listaVeiculo = FXCollections.observableArrayList();
	public boolean consultaExistencia(String m) 
	{
		for(String md : modelos)
		{
			if(md.contains(m)) 
			{
				return true;
			}
		}
		return false;
	}
	public void insereModelo(String model) 
	{
		if(!consultaExistencia(model))
		{
			modelos.add(model);
		}
	}
	public static ObservableList<String> getModelos()
	{
		return modelos;
	}
	public void setModelos(ObservableList<String> modelos)
	{
		this.modelos = modelos;
	}
	public void insereVeiculo(Veiculo v, Cliente cli) 
	{
		Veiculo pesq = pesquisaVeiculo(v.getPlaca());
		if(pesq == null) 
		{
			pesq = pesquisaVeiculoAlt(v.getChassis());
		}
		if(pesq == null) 
		{
			listaVeiculo.add(v);
			cli.getPosses().add(v);
		}
	}
	public void desativarVeiculo(String v, Cliente cli) 
	{
		for(Veiculo vei: listaVeiculo) 
		{
			if(vei.getPlaca().contains(v)) 
			{
				cli.getPosses().remove(vei);
				break;
			}
		}
	}
	public Veiculo pesquisaVeiculo(String placa) 
	{
		for(Veiculo vei : listaVeiculo) 
		{
			if(vei.getPlaca().equals(placa)) 
			{
				return vei;
			}
		}
		return null;
	}
	public Veiculo pesquisaVeiculoAlt(String chassis) 
	{
		for(Veiculo vei : listaVeiculo) 
		{
			if(vei.getChassis().equals(chassis)) 
			{
				return vei;
			}
		}
		return null;
	}
	public static ObservableList<Veiculo> getListaVeiculo() 
	{
		return listaVeiculo;
	}
	public static void setListaVeiculo(ObservableList<Veiculo> listaVeiculo) 
	{
		ControlVeiculo.listaVeiculo = listaVeiculo;
	}
}
