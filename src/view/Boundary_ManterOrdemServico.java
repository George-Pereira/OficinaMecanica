package view;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import controller.ControlCliente;
import controller.ControlFuncionario;
import controller.ControlManterOrdemServico;
import controller.ControlServico;
import controller.ControlVeiculo;
import entity.Cliente;
import entity.Funcionario;
import entity.Ordem_Servico;
import entity.Servico;
import entity.Veiculo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
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

public class Boundary_ManterOrdemServico implements EventHandler<ActionEvent>, Boundary_Constructor, telaLoader
{
	private DatePicker txtDtEntrada = new DatePicker();
	private DatePicker txtDtSaida = new DatePicker();
	private TextField txtProcurar = new TextField();
	private Button btnConfirmar = new Button("Confirmar Ordem de Serviço");
	private Button btnProcurar = new Button("Buscar");
	private Button btnCli = new Button("Novo Cliente");
	private Button btnVeic = new Button("Novo Veículo");
	private Button btnServ = new Button("Novo Serviço");
	private Button btnAddS = new Button("Adicionar Saída");
	private TableView<Ordem_Servico> table = new TableView<Ordem_Servico>();
	private TableView<Servico> table1 = new TableView<Servico>();
	private ComboBox<Veiculo> combo = new ComboBox<Veiculo>();
	private BorderPane painelPrincipal = new BorderPane();
	private gerenciadorTelas gerente;
	private ControlServico sev = new ControlServico();
	private ComboBox<Funcionario> comboF = new ComboBox<Funcionario>();
	private ControlManterOrdemServico mos = new ControlManterOrdemServico();
	private ControlCliente ctrCli = new ControlCliente();
	private ControlFuncionario ctrFunc = new ControlFuncionario();
	private ControlVeiculo ctrVeic = new ControlVeiculo();
	private int i = 1;
	
	public Boundary_ManterOrdemServico(gerenciadorTelas gerente) 
	{
		this.gerente = gerente;
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
		txt.add(new Label("Data de Entrada"), 4, 0);
		txt.add(txtDtEntrada, 5, 0, 2, 1);
		txt.add(new Label("Funcionario"), 6, 0);
		txt.add(comboF, 7, 0, 3, 1);
		txt.add(new Label("Data de Saída"), 4, 1);
		txt.add(txtDtSaida, 5, 1);
		txt.add(btnAddS, 6, 1);
		painelCampos.add(new Label("   "), 0, 0, 1, 2);
		painelCampos.add(new Label("   "), 0, 8);
		painelCampos.add(tab, 1, 10, 3, 1);
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
		btnAddS.addEventHandler(ActionEvent.ANY, this);
		painelBotoes.setVgap(10);
		painelBotoes.setHgap(200);
		painelBotoes.setAlignment(Pos.CENTER);
		
	}
	
	public void adicionarTableColumns() {
	    TableColumn<Servico, String> serv = new TableColumn<Servico, String>("Serviços");
	    serv.setCellValueFactory(new PropertyValueFactory<Servico, String>("nomeServ"));
	    serv.setMinWidth(250);
	    
		TableColumn<Ordem_Servico, Date> dataCol = new TableColumn<Ordem_Servico, Date>("Fim Previsto");
		dataCol.setCellValueFactory(new PropertyValueFactory<Ordem_Servico, Date>("DtSaida"));
		dataCol.setMinWidth(90);
		
		TableColumn<Ordem_Servico, String> serviceCol = new TableColumn<Ordem_Servico, String>("Serviços Contratados");
	    serviceCol.setCellValueFactory(new PropertyValueFactory<Ordem_Servico, String>("nomeS"));
	    serviceCol.setMinWidth(130);
	    
		table.getColumns().add(serviceCol);
		table.getColumns().add(dataCol);
		table1.getColumns().add(serv);
		table1.setItems(sev.getListaServ());
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
					c = ctrCli.pesquisarPorNome(txtProcurar.getText());
				combo.getItems().addAll(ctrVeic.getVeiculos(c));
				entidadeParaBoundary(c);
			}catch(Exception e) 
			{
				System.out.println("Não há parametros para pesquisa");
			}

		}
		else if(event.getTarget() == btnCli) 
		{
			gerente.request("Clientes");
		}
		else if(event.getTarget() == btnVeic) 
		{
			gerente.request("Veiculos");
		}
		else if(event.getTarget() == btnServ) 
		{
			gerente.request("Servicos");
		}
		else if(event.getTarget() == btnConfirmar) 
		{
			LocalDate dt = txtDtEntrada.getValue();
			Date d = Date.from(dt.atStartOfDay(ZoneId.systemDefault()).toInstant());
			mos.ReSalvar(combo.getValue(), d);
			table.getItems().clear();
			txtProcurar.clear();
			combo.getItems().removeAll();
			combo.getItems().clear();
			
		}
		else if(event.getTarget() == btnAddS) {
			LocalDate dt1 = txtDtSaida.getValue();
			Date d1 = Date.from(dt1.atStartOfDay(ZoneId.systemDefault()).toInstant());
			
			String s = table1.getSelectionModel().getSelectedItem().getNomeServ();
			mos.SalvarInformacoes(i, s, d1, comboF.getValue().getNomeFunc());
			table.setItems(mos.getListaOS());
		}
	}

	@Override
	public Pane constructBoundary() 
	{
		combo.getItems().clear();
		comboF.getItems().clear();
		comboF.getItems().addAll(ctrFunc.getListaFunc());
		return painelPrincipal;
	}

	@Override
	public void setRequest(gerenciadorTelas g) {
		this.gerente = g;
	}

	@Override
	public gerenciadorTelas getRequest() 
	{
		return this.gerente;
	}
}
