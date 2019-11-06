package view;


import java.io.IOException;

import controller.ControlCliente;
import entity.Cliente;
import entity.EnumCor;
import entity.EnumMarca;
import entity.Veiculo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;


public class Boundary_Cliente implements EventHandler<ActionEvent>, Boundary_Constructor
{
	private TextField txtNome = new TextField();
	private TextField txtCNH = new TextField();
	private TextField txtTelefone = new TextField();
	private TextField txtCPF = new TextField();
	private TextField txtLogradouro = new TextField();
	private TextField txtNumero = new TextField();
	private TextField txtBairro = new TextField();
	private Button btnAdicionar = new Button("Adicionar Cliente");
	private Button btnPesq = new Button("Pesquisar");
	private TableView<Veiculo> table = new TableView<Veiculo>();
	
	private void addTableColumns() {
		TableColumn<Veiculo, String> columnPlaca = new TableColumn<Veiculo, String>("Placa");
		columnPlaca.setCellValueFactory(new PropertyValueFactory<Veiculo, String>("Placa"));
		TableColumn<Veiculo, EnumMarca> columnMarca = new TableColumn<Veiculo, EnumMarca>("Marca");
		columnMarca.setCellValueFactory(new PropertyValueFactory<Veiculo, EnumMarca>("Marca"));
		TableColumn<Veiculo, String> columnChassis = new TableColumn<Veiculo, String>("Chassis");
		columnChassis.setCellValueFactory(new PropertyValueFactory<Veiculo, String>("Chassis"));
		TableColumn<Veiculo, double[]> columnMotor = new TableColumn<Veiculo, double[]>("Motor");
		columnMotor.setCellValueFactory(new PropertyValueFactory<Veiculo, double[]>("Motor"));
		TableColumn<Veiculo, EnumCor> columnCor = new TableColumn<Veiculo, EnumCor>("Cor");
		columnCor.setCellValueFactory(new PropertyValueFactory<Veiculo, EnumCor>("Cor"));
		TableColumn<Veiculo, int[]> columnAno = new TableColumn<Veiculo, int[]>("Ano Fabrica");
		columnAno.setCellValueFactory(new PropertyValueFactory<Veiculo, int[]>("AnoFabrica"));
		TableColumn<Veiculo, String> columnModel = new TableColumn<Veiculo, String>("Modelo");
		columnModel.setCellValueFactory(new PropertyValueFactory<Veiculo, String>("Model"));
		table.getColumns().addAll(columnPlaca, columnMarca, columnModel, columnChassis, columnMotor, columnAno, columnCor);
	}

	public Cliente enviarDados() 
	{ 
		Cliente cli = new Cliente();
			cli.setNome(txtNome.getText());
			cli.setCNH(txtCNH.getText());
			cli.setTelefone(txtTelefone.getText());
			cli.setLogradouro(txtLogradouro.getText());
			cli.setBairro(txtBairro.getText());
		return cli;
	}
	
	public void carregarDados(Cliente cli) 
	{
		if (cli != null)
		{ 
			txtNome.setText(cli.getNome());
			txtCNH.setText(cli.getCNH());
			txtCPF.setText(cli.getCPF());
			txtTelefone.setText(cli.getTelefone());
			txtLogradouro.setText(cli.getLogradouro());
			txtNumero.setText(String.valueOf(cli.getNumero()));
			txtBairro.setText(cli .getBairro());
			table.setItems(cli.getPosses());
		}
	}
	
	@Override
	public void handle(ActionEvent event) 
	{
		if (event.getTarget() == btnAdicionar) 
		{ 
			ControlCliente.adicionar(enviarDados());
		}
		if(event.getTarget() == btnPesq) 
		{
			if(!(txtNome.getText().equals(""))) 
			{
				Cliente pesquisado = ControlCliente.pesquisarPorNome(txtNome.getText());
				carregarDados(pesquisado);
			}
			else if(!(txtCNH.getText().equals(""))) 
			{
				Cliente pesquisado = ControlCliente.pesquisarPorCNH(txtCNH.getText());
				carregarDados(pesquisado);
			}
			else if(!(txtCPF.getText().equals(""))) 
			{
				Cliente pesquisado = ControlCliente.pesquisarPorCPF(txtCPF.getText());
				carregarDados(pesquisado);
			}
		}
	}

	@Override
	public Pane constructBoundary() 
	{
		ColumnConstraints col0 = new ColumnConstraints();
		col0.setFillWidth(true);
		col0.setPercentWidth(10);
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setFillWidth(true);
		col1.setPercentWidth(15);
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setFillWidth(true);
		col2.setPercentWidth(10);
		BorderPane painelPrincipal = new BorderPane();
		painelPrincipal.setStyle("-fx-padding: 10px");
		FlowPane painelBotoes = new FlowPane();
		GridPane painelCampos = new GridPane();
		painelCampos.setHgap(10);
		painelCampos.setVgap(10);
		painelCampos.getColumnConstraints().addAll(col0, col1, col2);
		painelPrincipal.setTop(painelCampos);
		painelPrincipal.setCenter(table);
		painelPrincipal.setBottom(painelBotoes);
		painelCampos.add(new Label("Nome"), 0, 0);
		painelCampos.add(txtNome, 1, 0);
		painelCampos.add(new Label("CNH"), 2, 0);
		painelCampos.add(txtCNH, 3, 0);
		painelCampos.add(new Label("CPF"), 0, 1);
		painelCampos.add(txtCPF, 1, 1);
		painelCampos.add(new Label("Telefone"), 2, 1);
		painelCampos.add(txtTelefone, 3, 1);
		painelCampos.add(new Label("Logradouro"), 0, 2);
		painelCampos.add(txtLogradouro, 1, 2);
		painelCampos.add(new Label("Bairro"), 2, 2);
		painelCampos.add(txtBairro, 3, 2);
		painelBotoes.getChildren().addAll(btnAdicionar, btnPesq);
		addTableColumns();
		btnAdicionar.addEventHandler(ActionEvent.ANY, this);
		painelBotoes.setAlignment(Pos.CENTER);
		btnPesq.addEventHandler(ActionEvent.ANY, this);
		painelBotoes.setHgap(100);
		return painelPrincipal;
	}
}