
package com.everis.estacionamento.estacionamentoSpring.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.estacionamento.estacionamentoSpring.model.Veiculo;
import com.everis.estacionamento.estacionamentoSpring.repository.VeiculoRepository;

@Service
public class RelatorioDTO {
	
	@Autowired
	VeiculoRepository veiculoRepository;
	
	
	private Long id;
	private String marca;
	private String modelo;
	private String placa;
	private double valor;
	private LocalDateTime entrada;
	private LocalDateTime saida;
	

	/*
	public RelatorioDTO(Veiculo veiculo) {
		this.id = veiculo.getId();
		this.marca = veiculo.getMarcadocarro();
		this.modelo = veiculo.getModelodocarro();
		this.placa = veiculo.getPlacadocarro();
		this.valor = veiculo.getValorTotal();
		this.entrada =veiculo.getDataDeEntrada();
		this.saida = veiculo.getDataDeSaida();
		
	}*/

	public Long getId() {
		return id;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public double getValor() {
		return valor;
	}

	public LocalDateTime getEntrada() {
		return entrada;
	}

	public LocalDateTime getSaida() {
		return saida;
	}
	

	public List<Veiculo> gerarRelatorio() {
		List<Veiculo> relatorio = new ArrayList<>();
		List<Veiculo> lista = veiculoRepository.findAll();
		for (Veiculo veiculo : lista) {
			if (veiculo.getValorTotal() > 0) {
				Veiculo save = veiculoRepository.save(veiculo);
				relatorio.add(save);
			}
		} return relatorio;

	}
	

}

