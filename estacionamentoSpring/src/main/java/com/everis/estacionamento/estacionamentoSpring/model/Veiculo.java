package com.everis.estacionamento.estacionamentoSpring.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonFormat;

@Table(name = "cliente")
@Entity
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "marcadocarro")
	private String marcadocarro;
	@Column(name = "modelodocarro")
	private String modelodocarro;
	@Column(name = "placadocarro")
	private String placadocarro;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
	private LocalDateTime dataDeEntrada = LocalDateTime.now();
	@Column(name = "valorTotal")
	private double valorTotal;
	@Column(name = "dataDeSaida")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
	private LocalDateTime dataDeSaida;
	
	public Veiculo() {

	}

	public Veiculo(String marcadocarro, String modelodocarro, String placadocarro) {
		super();
		this.marcadocarro = marcadocarro;
		this.modelodocarro = modelodocarro;
		this.placadocarro = placadocarro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarcadocarro() {
		return marcadocarro;
	}

	public void setMarcadocarro(String marcadocarro) {
		this.marcadocarro = marcadocarro;
	}

	public String getModelodocarro() {
		return modelodocarro;
	}

	public void setModelodocarro(String modelodocarro) {
		this.modelodocarro = modelodocarro;
	}

	public String getPlacadocarro() {
		return placadocarro;
	}

	public void setPlacadocarro(String placadocarro) {
		this.placadocarro = placadocarro;
	}

	public void setDataDeEntrada(LocalDateTime dataDeEntrada) {
		this.dataDeEntrada = dataDeEntrada;
	}

	public LocalDateTime getDataDeEntrada() {
		return dataDeEntrada;
	}

	
	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public LocalDateTime getDataDeSaida() {
		return dataDeSaida;
	}

	public void setDataDeSaida(LocalDateTime dataDeSaida) {
		this.dataDeSaida = dataDeSaida;
		dataDeSaida = LocalDateTime.now();
	}
	
	public double calcularValor() {
		float duracao;
		this.dataDeSaida = LocalDateTime.now();
		duracao = ChronoUnit.HOURS.between(this.dataDeEntrada, this.dataDeSaida);
		
		if (duracao <= 1) {
			valorTotal = 5.0;
			
		} else {
			float horas = duracao - 1;
			valorTotal = (horas * 2) + 5.0;
		}
		
		//return valorTotal;
		return getValorTotal();
		
	}
	
	
	
}
