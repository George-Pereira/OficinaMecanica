package view;

import controller.ControlMarca;
import controller.ControlModelo;
import dao.DaoException;
import entity.Marca;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class Boundary_Modelo implements telaLoader, Boundary_Constructor, EventHandler<ActionEvent>
{
	private Button btnRetorno = new Button("Retornar aos Veiculos");
	private Button btnAdicionar = new Button("Adicionar");
	private ComboBox<Marca> comboMarca = new ComboBox<Marca>();
	private TextField txtModelo = new TextField();
	private BorderPane layout = new BorderPane(); 
	private ControlModelo ctrMod = new ControlModelo();
	private ControlMarca ctrMarc = new ControlMarca();
	private gerenciadorTelas gerente;
	public Boundary_Modelo(gerenciadorTelas gerente) 
	{
		this.gerente = gerente;
		comboMarca.setItems(ctrMarc.getMarcas());
		ColumnConstraints col = new ColumnConstraints();
		col.setFillWidth(true);
		col.setPercentWidth(15);
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setFillWidth(true);
		col1.setPercentWidth(30);
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setFillWidth(true);
		col2.setPercentWidth(15);
		ColumnConstraints col3 = new ColumnConstraints();
		col3.setFillWidth(true);
		col3.setPercentWidth(30);
		GridPane grid = new GridPane();
		layout.setCenter(grid);
		grid.getColumnConstraints().addAll(col, col1, col2, col3);
		grid.setAlignment(Pos.CENTER);
		grid.add(new Label("Marca:"), 0, 0);
		grid.add(comboMarca, 1, 0);
		grid.add(new Label("Nome do Modelo: "), 2, 0);
		grid.add(txtModelo, 3, 0);
		FlowPane flow = new FlowPane();
		flow.getChildren().addAll(btnAdicionar, btnRetorno);
		flow.setAlignment(Pos.CENTER);
		flow.setHgap(100);
		layout.setBottom(flow);
		btnRetorno.addEventHandler(ActionEvent.ANY, this);
		btnAdicionar.addEventHandler(ActionEvent.ANY, this);
	}
	
	@Override
	public Pane constructBoundary() 
	{
		comboMarca.getItems().clear();
		comboMarca.setItems(ctrMarc.getMarcas());
		txtModelo.setText("");
		return layout;
	}

	@Override
	public void setRequest(gerenciadorTelas gerente) 
	{
		this.gerente = gerente;
	}

	@Override
	public gerenciadorTelas getRequest() 
	{
		return this.gerente;
	}

	@Override
	public void handle(ActionEvent evento) 
	{
		if(evento.getTarget() == btnAdicionar) 
		{
			try 
			{
				ctrMod.adicionaModelo(txtModelo.getText(), comboMarca.getValue().getId());
			}
			catch (DaoException e) 
			{
				e.printStackTrace();
			}
		}
		if(evento.getTarget() == btnRetorno) 
		{
			gerente.request("Veiculos");
		}
	}
}
