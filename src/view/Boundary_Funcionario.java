package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class Boundary_Funcionario implements Boundary_Constructor, EventHandler<ActionEvent>
{
	private TextField txtNome = new TextField();
	private TextField txtCartrab = new TextField();
	private TextField txtCpf = new TextField();
	private TextField txtTel = new TextField();
	private TextField txtSalario = new TextField();
	private Button btnPesqfunc = new Button("Pesquisa");
	private BorderPane brdp = new BorderPane();
	@Override
	public Pane constructBoundary() 
	{
		GridPane grd = new GridPane();
		grd.setHgap(10);
		grd.setVgap(10);
		ColumnConstraints col = new ColumnConstraints();
		col.setFillWidth(true);
		col.setPercentWidth(15);
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setFillWidth(true);
		col1.setPercentWidth(25);
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setFillWidth(true);
		col2.setPercentWidth(10);
		ColumnConstraints col3 = new ColumnConstraints();
		col3.setFillWidth(true);
		col3.setPercentWidth(25);
		grd.getColumnConstraints().addAll(col, col1, col2, col3);
		brdp.setTop(grd);
		grd.add(new Label("Nome do Funcionario"), 0, 0);
		grd.add(txtNome, 1, 0);
		txtNome.setMaxWidth(Double.MAX_VALUE);
		grd.add(new Label("Nº Carteira Trabalho"), 0, 1);
		grd.add(btnPesqfunc, 2, 0);
		grd.add(txtCartrab, 1, 1);
		grd.add(new Label("CPF"), 2, 1);
		grd.add(txtCpf, 3, 1);
		grd.add(new Label("Telefone"), 0, 2);
		grd.add(txtTel, 1, 2);
		grd.add(new Label("Salário"), 2, 2);
		grd.add(txtSalario, 3, 2);
		return brdp;
	}
	public void constructTables() 
	{
		
	}
	@Override
	public void handle(ActionEvent arg0) 
	{
		
	}

}
