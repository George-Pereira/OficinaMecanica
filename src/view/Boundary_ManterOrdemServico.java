package view;

import controller.ControlCliente;
import controller.ControlServico;
import entity.Cliente;
import entity.Ordem_Servico;
import entity.Servico;
import entity.Veiculo;
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
	private Button btnAdicionar = new Button("Adicionar");
	private Button btnConfirmar = new Button("Confirmar Ordem de Serviço");
	private Button btnProcurar = new Button("Buscar");
	private Button btnCli = new Button("Novo Cliente");
	private Button btnVeic = new Button("Novo Veículo");
	private Button btnServ = new Button("Novo Serviço");
	private TableView<Servico> table = new TableView<Servico>();
	private TableView<Servico> table1 = new TableView<Servico>();
	private ComboBox<Veiculo> combo = new ComboBox<Veiculo>();

	public void adicionarTableColumns() {
	    TableColumn<Servico, String> serv = new TableColumn<Servico, String>("Serviços");
	    serv.setCellValueFactory(new PropertyValueFactory<Servico, String>("Sericos"));
	    serv.setMinWidth(250);
	    
		TableColumn<Servico, String> dataCol = new TableColumn<Servico, String>("Fim Previsto");
		dataCol.setCellValueFactory(new PropertyValueFactory<Servico, String>("Serviços Contratados"));
		dataCol.setMinWidth(100);
		
		TableColumn<Servico, String> serviceCol = new TableColumn<Servico, String>("Serviços Contratados");
	    serviceCol.setCellValueFactory(new PropertyValueFactory<Servico, String>("Fim Previsto"));
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
				Cliente c = new Cliente();
					c = ControlCliente.pesquisarPorNome(txtProcurar.getText());
				combo.getItems().addAll(c.getPosses());
				entidadeParaBoundary(c);
				
			}catch(Exception e) 
			{
				System.out.println("Não há parametros para pesquisa");
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
		else if(event.getTarget() == btnAdicionar) {
			
		}
	}

	@Override
	public Pane constructBoundary() 
	{
		BorderPane painelPrincipal = new BorderPane();
		painelPrincipal.setStyle("-fx-padding: 10px");
		FlowPane painelBotoes = new FlowPane();
		GridPane painelCampos = new GridPane();
		GridPane buttom = new GridPane();
		GridPane tab = new GridPane();
		GridPane txt = new GridPane();
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
		txt.add(new Label("Veículo"), 0, 1);
		txt.add(combo, 1, 1, 3, 1);
		painelCampos.add(new Label("   "), 0, 0, 1, 2);
		painelCampos.add(new Label("   "), 0, 8);
		painelCampos.add(tab, 1, 9, 2, 1);
		painelCampos.add(txt, 0, 4, 5, 3);
		painelCampos.add(btnAdicionar, 0, 9);
		painelBotoes.getChildren().addAll(btnConfirmar);
		adicionarTableColumns();
		buttom.setHgap(10);
		txt.setVgap(10);
		txt.setHgap(10);
		btnProcurar.addEventHandler(ActionEvent.ANY, this);
		btnAdicionar.addEventHandler(ActionEvent.ANY, this);
		btnConfirmar.addEventHandler(ActionEvent.ANY, this);
		btnServ.addEventHandler(ActionEvent.ANY, this);
		btnVeic.addEventHandler(ActionEvent.ANY, this);
		btnCli.addEventHandler(ActionEvent.ANY, this);
		painelBotoes.setVgap(10);
		painelBotoes.setHgap(200);
		painelBotoes.setAlignment(Pos.CENTER);
		return painelPrincipal;
	}
}
