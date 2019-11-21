package view;

import controller.ControlCliente;
import controller.ControlCor;
import controller.ControlMarca;
import controller.ControlModelo;
import controller.ControlVeiculo;
import dao.DaoException;
import entity.Cliente;
import entity.Cor;
import entity.Marca;
import entity.Modelo;
import entity.Veiculo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class Boundary_Veiculo implements EventHandler<ActionEvent>, Boundary_Constructor, telaLoader
{
	private TextField txtAno = new TextField();
	private TextField txtChassis = new TextField();
	private TextField txtPlaca = new TextField();
	private TextArea txtDesc = new TextArea();
	private ComboBox <Marca> comboMarca = new ComboBox<Marca>();
	private ComboBox <Modelo> comboModel = new ComboBox<Modelo>();
	private TextField txtMotor = new TextField();
	private ComboBox <Cor>comboCor = new ComboBox<Cor>();
	private Button btnNvModel = new Button("Novo");
	private Button btnAdd = new Button("Adicionar");
	private Button btnDesat = new Button("Desativar");
	private Button btnEdit = new Button("Editar");
	private Button btnPesq = new Button("Pesquisar");
	private Veiculo atual = new Veiculo();
	private TableView<Veiculo> table = new TableView<Veiculo>();
	private Cliente context = new Cliente();
	private ComboBox<Cliente> comboCliente = new ComboBox<Cliente>();
	private BorderPane lay = new BorderPane();
	private ControlVeiculo ctrVeic = new ControlVeiculo();
	private ControlCliente ctrCli = new ControlCliente();
	private ControlModelo ctrModel = new ControlModelo();
	private ControlMarca ctrMarca = new ControlMarca();
	private ControlCor ctrCor = new ControlCor();
	private gerenciadorTelas gerente;

	public Boundary_Veiculo(gerenciadorTelas gerente) 
	{
		this.gerente = gerente;
		comboMarca.getItems().addAll(ctrMarca.getMarcas());
		comboModel.setEditable(true);
		btnNvModel.addEventHandler(ActionEvent.ANY, this);
		comboCor.getItems().addAll(ctrCor.getCores());
		GridPane info = new GridPane();
		ColumnConstraints col0 = new ColumnConstraints();
		col0.setFillWidth(true);
		col0.setPercentWidth(10);
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setFillWidth(true);
		col1.setPercentWidth(15);
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setFillWidth(true);
		col2.setPercentWidth(10);
		ColumnConstraints col3 = new ColumnConstraints();
		col3.setFillWidth(true);
		col3.setPercentWidth(10);
		ColumnConstraints col4 = new ColumnConstraints();
		col4.setFillWidth(true);
		col4.setPercentWidth(10);
		ColumnConstraints col5 = new ColumnConstraints();
		col5.setFillWidth(true);
		col5.setPercentWidth(10);
		ColumnConstraints col6 = new ColumnConstraints();
		col6.setFillWidth(true);
		col6.setPercentWidth(15);
		info.getColumnConstraints().addAll(col0, col1, col2, col3, col4, col5, col6);
		lay.setStyle("-fx-padding: 10px");
		info.setHgap(10);
		info.setVgap(20);
		info.setStyle("-fx-padding: 10px");
		info.add(new Label("Marca"), 0 , 0);
		info.add(comboMarca, 1, 0);
		info.add(new Label("Ano"), 3, 0);
		info.add(txtAno, 4, 0);
		info.add(new Label("Placa"), 5, 0);
		info.add(txtPlaca, 6, 0);
		info.add(new Label("Modelo"), 0, 1);
		info.add(comboModel, 1, 1);
		info.add(btnNvModel, 2, 1);
		info.add(new Label("Chassis"), 3, 1);
		info.add(txtChassis, 4, 1);
		info.add(new Label("Cor"), 5, 1);
		info.add(comboCor, 6, 1);
		info.add(new Label("Motor"), 0, 2);
		info.add(txtMotor, 1, 2);
		lay.setTop(info);
		BorderPane central = new BorderPane();
		txtDesc.setMaxHeight(400);
		txtDesc.setMaxWidth(Double.MAX_VALUE);
		central.setTop(txtDesc);
		FlowPane flow = new FlowPane();
		central.setBottom(flow);
		flow.setHgap(10);
		flow.getChildren().addAll(new Label("Cliente"),comboCliente);
		comboCliente.setMinWidth(300);
		flow.setAlignment(Pos.CENTER);
		central.setCenter(table);
		lay.setCenter(central);
		FlowPane flw = new FlowPane();
		flw.setAlignment(Pos.CENTER);;
		flw.setHgap(100);
		flw.setVgap(10);
		flw.getChildren().addAll(btnAdd, btnPesq, btnEdit, btnDesat);
		constructTable();
		btnAdd.addEventHandler(ActionEvent.ANY, this);
		btnDesat.addEventHandler(ActionEvent.ANY, this);
		btnPesq.addEventHandler(ActionEvent.ANY, this);
		btnEdit.addEventHandler(ActionEvent.ANY, this);
		lay.setBottom(flw);
	}
	
	@Override
	public void handle(ActionEvent evento) 
	{
		if(evento.getTarget() == btnNvModel) 
		{
			try {
				ctrModel.adicionaModelo((comboModel.getValue().toString()), comboMarca.getValue());
			}
			catch (DaoException e) 
			{
				e.printStackTrace();
			}
		}
		if(evento.getTarget() == btnAdd) 
		{
			enviarDados();
			clearCampos();
		}
		else if(evento.getTarget() == btnDesat) 
		{
			if(txtPlaca.getText() != null) 
			{
				ctrVeic.desativarVeiculo(txtPlaca.getText(), context);
			}
		}
		else if(evento.getTarget() == btnPesq) 
		{
			Veiculo pesq = new Veiculo();
			try 
			{
				if(!(txtPlaca.getText().equals(""))) 
				{
					pesq = ctrVeic.pesquisaVeiculo(txtPlaca.getText());
				}
				else if(!(txtChassis.getText().equals("")))
				{
					pesq = ctrVeic.pesquisaVeiculoAlt(txtChassis.getText());
				}
				clearCampos();
			    carregarDados(pesq);
			    atual = pesq;
			} 
			catch (Exception e) 
			{
				System.out.println("Não há parametros para pesquisa");
			}
		}
		else if(evento.getTarget() == btnEdit) 
		{
			atual.setCor(comboCor.getValue());
			atual.setPlaca(txtPlaca.getText());
			atual.setChassis(txtChassis.getText());
			atual.setAnoFabrica(Integer.parseInt(txtAno.getText()));
			atual.setMotor(Double.parseDouble(txtMotor.getText()));
			atual.setDesc(txtDesc.getText());
			atual.setModel((comboModel.getValue()));
			atual.setMarca(comboMarca.getValue());
			clearCampos();
		}
	}
	public void enviarDados()
	{
		Veiculo novo = new Veiculo();
		novo.setCor(comboCor.getValue());
		novo.setPlaca(txtPlaca.getText());
		novo.setChassis(txtChassis.getText());
		novo.setAnoFabrica(Integer.parseInt(txtAno.getText()));
		novo.setMotor(Double.parseDouble(txtMotor.getText()));
		novo.setDesc(txtDesc.getText());
		novo.setModel(comboModel.getValue());
		novo.setMarca(comboMarca.getValue());
		ctrVeic.insereVeiculo(novo, comboCliente.getValue());
	}
	public void carregarDados(Veiculo v) 
	{
		comboCor.setValue(v.getCor());
		txtChassis.setText(v.getChassis());
		txtAno.setText(String.valueOf((v.getAnoFabrica())));
		txtPlaca.setText(v.getPlaca());
		comboMarca.getSelectionModel().select(v.getMarca());
		comboModel.getSelectionModel().select((v.getModel()));
		txtMotor.setText(String.valueOf(v.getMotor()));
		txtDesc.setText(v.getDesc());
	}
	public void clearCampos() 
	{
		txtPlaca.setText("");
		txtChassis.setText("");
		txtAno.setText("");
		comboMarca.getSelectionModel().selectFirst();
		comboModel.getSelectionModel().selectFirst();
		comboCor.getSelectionModel().selectFirst();
		txtDesc.setText("");
		txtMotor.setText("");
	}

	private void constructTable() 
	{
		TableColumn<Veiculo, String> columnPlaca = new TableColumn<Veiculo, String>("Placa");
		columnPlaca.setCellValueFactory(new PropertyValueFactory<Veiculo, String>("Placa"));
		TableColumn<Veiculo, Marca> columnMarca = new TableColumn<Veiculo, Marca>("Marca");
		columnMarca.setCellValueFactory(new PropertyValueFactory<Veiculo, Marca>("nome_Marca"));
		TableColumn<Veiculo, String> columnChassis = new TableColumn<Veiculo, String>("Chassis");
		columnChassis.setCellValueFactory(new PropertyValueFactory<Veiculo, String>("Chassis"));
		TableColumn<Veiculo, double[]> columnMotor = new TableColumn<Veiculo, double[]>("Motor");
		columnMotor.setCellValueFactory(new PropertyValueFactory<Veiculo, double[]>("Motor"));
		TableColumn<Veiculo, Cor> columnCor = new TableColumn<Veiculo, Cor>("Cor");
		columnCor.setCellValueFactory(new PropertyValueFactory<Veiculo, Cor>("nome_Cor"));
		TableColumn<Veiculo, int[]> columnAno = new TableColumn<Veiculo, int[]>("Ano");
		columnAno.setCellValueFactory(new PropertyValueFactory<Veiculo, int[]>("AnoFabrica"));
		TableColumn<Veiculo, Modelo> columnModel = new TableColumn<Veiculo, Modelo>("Modelo");
		columnModel.setCellValueFactory(new PropertyValueFactory<Veiculo, Modelo>("nome_Modelo"));
		table.getColumns().addAll(columnPlaca, columnMarca, columnModel, columnChassis, columnMotor, columnAno, columnCor);
		table.setItems(ctrVeic.getVeiculos(comboCliente.getValue()));
	}

	public Pane constructBoundary() 
	{
		comboCliente.getItems().clear();
		comboCliente.getItems().addAll(ctrCli.getClientes());
		comboModel.getItems().clear();
		comboModel.getItems().addAll(ctrModel.getModelos(comboMarca.getValue()));
		table.getItems().clear();
		return lay;
	}

	@Override
	public void setRequest(gerenciadorTelas g) 
	{
		this.gerente = g;
	}

	@Override
	public gerenciadorTelas getRequest() 
	{
		return this.gerente;
	}
}
