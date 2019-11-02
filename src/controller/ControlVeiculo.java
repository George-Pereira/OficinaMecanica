package controller;
import entity.Veiculo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ControlVeiculo 
{
	private ObservableList<String> modelos = FXCollections.observableArrayList();
	private ObservableList<Veiculo> listaVeiculo = FXCollections.observableArrayList();
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
		if(consultaExistencia(model) == false)
		{
			modelos.add(model);
		}
	}
	public ObservableList<String> getModelos()
	{
		return this.modelos;
	}
	public void setModelos(ObservableList<String> modelos)
	{
		this.modelos = modelos;
	}
	public void insereVeiculo(Veiculo v) 
	{
		Veiculo pesq = pesquisaVeiculo(v.getPlaca());
		if(pesq == null) 
		{
			pesq = pesquisaVeiculoAlt(v.getChassis());
		}
		if(pesq == null) 
		{
			listaVeiculo.add(v);
		}
	}
	public void desativarVeiculo(String v) 
	{
		for(Veiculo vei: listaVeiculo) 
		{
			if(vei.getPlaca().contains(v)) 
			{
				listaVeiculo.remove(vei);
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
	public ObservableList<Veiculo> getListaVeiculo() 
	{
		return listaVeiculo;
	}
	public void setListaVeiculo(ObservableList<Veiculo> listaVeiculo) 
	{
		this.listaVeiculo = listaVeiculo;
	}
	public void editarVeiculo(Veiculo v) 
	{
		try 
		{
			Veiculo edit = pesquisaVeiculo(v.getPlaca());
			if(edit.getPlaca().equals(null)) 
			{
				edit = pesquisaVeiculoAlt(v.getChassis());
			}
			
		}
		catch(Exception e) 
		{
			System.out.println("Veiculo não existente");
		}
	}
}
