package entity;

import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Ordem_Servico 
{
	private Date dtEntrada;
	private Date dtSaida;
	private ObservableList<Servico> os = FXCollections.observableArrayList();
	public ObservableList<Servico> getOs() {
		return os;
	}
	public void setOs(ObservableList<Servico> os) {
		this.os = os;
	}
}
