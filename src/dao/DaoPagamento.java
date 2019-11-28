package dao;

import java.util.List;

import entity.Cliente;
import entity.Ordem_Servico;
import entity.Pagamento;
import entity.Veiculo;

public interface DaoPagamento 
{
	List<Pagamento> getPagamento(Cliente cli);
	void novoPagto(Veiculo vei, Ordem_Servico os);
	double getValores();
}
