package entity;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Historico 
{
	private double gastos;
	private ObservableList<Servico> manutencao = FXCollections.observableArrayList();
	public ObservableList<Servico> getManutencao() 
	{
		return manutencao;
	}

	public void setManutencao(ObservableList<Servico> manutencao) 
	{
		this.manutencao = manutencao;
	}
}
