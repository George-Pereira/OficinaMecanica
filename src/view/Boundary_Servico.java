package view;

import controller.ControlServico;
import entity.Servico;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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

public class Boundary_Servico implements Boundary_Constructor, EventHandler<ActionEvent>
{
	private TextField txtNservico = new TextField();
	private TextArea txtDescricao = new TextArea();
	private Button btnSalvar = new Button("Salvar");
	private CheckBox chServativo = new CheckBox("Serviço Ativo");
	private Button btnEditar = new Button("Editar");
	private TableView<Servico> table = new TableView<Servico>();
	private BorderPane fundo = new BorderPane();
	private ControlServico ctrServ = new ControlServico();
	private Button btnPesquisa = new Button("Pesquisar");
	
	public Boundary_Servico() 
	{
		fundo.setStyle("-fx-padding: 10px");
		FlowPane flow = new FlowPane();
		flow.setAlignment(Pos.CENTER);
		flow.setHgap(20);
		flow.setVgap(10);
		flow.getChildren().addAll(new Label("Nome do Serviço"), txtNservico, btnPesquisa);
		fundo.setTop(flow);
		ColumnConstraints cons = new ColumnConstraints();
		cons.setFillWidth(true);
		cons.setPercentWidth(100);
		GridPane grd = new GridPane();
		grd.getColumnConstraints().add(cons);
		grd.add(txtDescricao, 0, 0);
		constructTable(grd);
		fundo.setCenter(grd);
		FlowPane botoes = new FlowPane();
		botoes.setStyle("-fx-padding: 10px");
		botoes.setAlignment(Pos.CENTER);
		botoes.getChildren().addAll(btnSalvar, chServativo, btnEditar);
		btnSalvar.addEventHandler(ActionEvent.ANY, this);
		btnEditar.addEventHandler(ActionEvent.ANY, this);
		btnPesquisa.addEventHandler(ActionEvent.ANY, this);
		botoes.setHgap(100);
		fundo.setBottom(botoes);
	}
	
	@Override
	public Pane constructBoundary() 
	{
		return fundo;
	}
	private void constructTable(GridPane painel) 
	{
		TableColumn<Servico, String> clnNomeServ = new TableColumn<Servico, String>("Nome");
		clnNomeServ.setCellValueFactory(new PropertyValueFactory<Servico, String>("nomeServ"));
		clnNomeServ.setMinWidth(266);
		TableColumn<Servico, String> clnDescServ = new TableColumn<Servico, String>("Descricao");
		clnDescServ.setCellValueFactory(new PropertyValueFactory<Servico, String>("descServ"));
		clnDescServ.setMinWidth(266);
		TableColumn<Servico, boolean[]> clnDispServ = new TableColumn<Servico, boolean[]>("Status");
		clnDispServ.setCellValueFactory(new PropertyValueFactory<Servico, boolean []>("servDisp"));
		clnDispServ.setMinWidth(266);
		table.getColumns().setAll(clnNomeServ, clnDescServ, clnDispServ);
		table.setItems(ctrServ.getListaServ());
		painel.add(table, 0, 1);
	}
	@Override
	public void handle(ActionEvent event) 
	{
		if(event.getTarget() == btnSalvar) 
		{	
			Servico novo = new Servico(txtNservico.getText(), txtDescricao.getText(), chServativo.isSelected());
			ctrServ.insertServico(novo);
		}
		else if(event.getTarget() == btnPesquisa) 
		{
			Servico atual = ctrServ.pesquisaServ(txtNservico.getText());
			if(atual != null) 
			{
				txtNservico.setText(atual.getNomeServ());
				txtDescricao.setText(atual.getDescServ());
				if(atual.isServDisp()) 
				{
					chServativo.arm();
				}
				else 
				{
					chServativo.disarm();
				}
			}
		}
		else if(event.getTarget() == btnEditar) 
		{
			Servico atual = ctrServ.pesquisaServ(txtNservico.getText());
			atual.setDescServ(txtDescricao.getText());
			atual.isServDisp(chServativo.isSelected());
		}
	}

}

