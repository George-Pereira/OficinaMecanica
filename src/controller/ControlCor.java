package controller;

import entity.Cor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ControlCor 
{
	private ObservableList<Cor> cores = FXCollections.observableArrayList();
	public ObservableList<Cor> getCores() 
	{
		
		return cores;
	}

}
