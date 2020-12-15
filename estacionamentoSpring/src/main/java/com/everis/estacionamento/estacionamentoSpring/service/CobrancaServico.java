package com.everis.estacionamento.estacionamentoSpring.service;

import java.util.ArrayList;
import java.util.List;

import com.everis.estacionamento.estacionamentoSpring.model.Veiculo;
import com.everis.estacionamento.estacionamentoSpring.model.Cobranca;

public class CobrancaServico {
	

	private List<Veiculo> saldo = new ArrayList<>();
	

	public List<Veiculo> getSaldo() {
		for (Veiculo veiculo : saldo) {
			veiculo.getValorTotal();
		}
		return saldo;
	}

	public void setSaldo(List<Veiculo> saldo) {
		this.saldo = saldo;
	}
	
	public double somarValores(double soma) {
		
		return soma;
	}
	
	
	

}
