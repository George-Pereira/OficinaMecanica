package controller;

import entity.Historico;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ControlHistorico 
{
	private static ObservableList<Historico> historicos = FXCollections.observableArrayList();
	
	public static ObservableList<Historico> getHistoricos() {
		return historicos;
	}
	
	public static void setHistoricos(ObservableList<Historico> historicos) {
		ControlHistorico.historicos = historicos;
	}
}
