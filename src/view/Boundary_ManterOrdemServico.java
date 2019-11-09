package view;

import controller.ControlCliente;
import controller.ControlServico;
import entity.Cliente;
import entity.Ordem_Servico;
import entity.Servico;
import entity.Veiculo;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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

public class Boundary_ManterOrdemServico implements EventHandler<ActionEvent>, Boundary_Constructor
{
	
	private TextField txtProcurar = new TextField();
	private Button btnConfirmar = new Button("Confirmar Ordem de Servi�o");
	private Button btnProcurar = new Button("Buscar");
	private Button btnCli = new Button("Novo Cliente");
	private Button btnVeic = new Button("Novo Ve�culo");
	private Button btnServ = new Button("Novo Servi�o");
	private TableView<Servico> table = new TableView<Servico>();
	private TableView<Servico> table1 = new TableView<Servico>();
	private ComboBox<Veiculo> combo = new ComboBox<Veiculo>();
	private BorderPane painelPrincipal = new BorderPane();

	public Boundary_ManterOrdemServico() 
	{
		painelPrincipal.setStyle("-fx-padding: 10px");
		FlowPane painelBotoes = new FlowPane();
		GridPane painelCampos = new GridPane();
		GridPane buttom = new GridPane();
		GridPane tab = new GridPane();
		GridPane txt = new GridPane();
		table1.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Servico>() {

			@Override
			public void changed(ObservableValue<? extends Servico> lista, Servico antigo, Servico novo) 
			{
				table.getItems().add(novo);
			}}
		);
		ColumnConstraints col0 = new ColumnConstraints();
		col0.setPercentWidth(20);
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(20);
		painelCampos.getColumnConstraints().addAll(col0, col1);
		table.setEditable(true);
		table1.setEditable(true);
		painelPrincipal.setTop(buttom);
		painelPrincipal.setCenter(painelCampos);
		painelPrincipal.setBottom(painelBotoes);
		buttom.add(btnCli, 0, 1);
		buttom.add(btnVeic, 1, 1);
		buttom.add(btnServ, 2, 1);
		tab.add(table, 0, 0);
		tab.add(table1, 2, 0);
		txt.add(new Label("Cliente"), 0, 0);
		txt.add(txtProcurar, 1, 0, 2, 1);
		txt.add(btnProcurar, 3, 0);
		txt.add(new Label("Ve�culo"), 0, 1);
		txt.add(combo, 1, 1, 3, 1);
		painelCampos.add(new Label("   "), 0, 0, 1, 2);
		painelCampos.add(new Label("   "), 0, 8);
		painelCampos.add(tab, 1, 9, 2, 1);
		painelCampos.add(txt, 0, 4, 5, 3);
		painelBotoes.getChildren().addAll(btnConfirmar);
		adicionarTableColumns();
		buttom.setHgap(10);
		txt.setVgap(10);
		txt.setHgap(10);
		btnProcurar.addEventHandler(ActionEvent.ANY, this);
		btnConfirmar.addEventHandler(ActionEvent.ANY, this);
		btnServ.addEventHandler(ActionEvent.ANY, this);
		btnVeic.addEventHandler(ActionEvent.ANY, this);
		btnCli.addEventHandler(ActionEvent.ANY, this);
		painelBotoes.setVgap(10);
		painelBotoes.setHgap(200);
		painelBotoes.setAlignment(Pos.CENTER);
	}
	
	public void adicionarTableColumns() {
	    TableColumn<Servico, String> serv = new TableColumn<Servico, String>("Servi�os");
	    serv.setCellValueFactory(new PropertyValueFactory<Servico, String>("nomeServ"));
	    serv.setMinWidth(250);
	    
		TableColumn<Servico, String> dataCol = new TableColumn<Servico, String>("Fim Previsto");
		/*dataCol.setCellValueFactory(new PropertyValueFactory<Servico, String>("dataServ"));*/
		dataCol.setMinWidth(100);
		
		TableColumn<Servico, String> serviceCol = new TableColumn<Servico, String>("Servi�os Contratados");
	    serviceCol.setCellValueFactory(new PropertyValueFactory<Servico, String>("nomeServ"));
	    serviceCol.setMinWidth(150);
	    
		table.getColumns().add(serviceCol);
		table.getColumns().add(dataCol);
		table1.getColumns().add(serv);
		table1.setItems(ControlServico.getListaServ());
	}
	
	public void entidadeParaBoundary(Cliente c) { 
		if (c != null) {
			txtProcurar.setText(c.getNome());
		}
	}

	@Override
	public void handle(ActionEvent event) {
		if (event.getTarget() == btnProcurar) 
		{
			try {
				combo.getItems().clear();
				Cliente c = new Cliente();
					c = ControlCliente.pesquisarPorNome(txtProcurar.getText());
				combo.getItems().addAll(c.getPosses());
				entidadeParaBoundary(c);
			}catch(Exception e) 
			{
				System.out.println("N�o h� parametros para pesquisa");
			}

		}
		else if(event.getTarget() == btnCli) 
		{

		}
		else if(event.getTarget() == btnVeic) 
		{
			
		}
		else if(event.getTarget() == btnServ) 
		{
			
		}
		else if(event.getTarget() == btnConfirmar) 
		{
			
		}
	}

	@Override
	public Pane constructBoundary() 
	{
		combo.getItems().clear();
		return painelPrincipal;
	}
}
