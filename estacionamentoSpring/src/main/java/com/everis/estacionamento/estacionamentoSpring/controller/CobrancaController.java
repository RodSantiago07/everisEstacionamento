package com.everis.estacionamento.estacionamentoSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.estacionamento.estacionamentoSpring.repository.CobrancaRepository;
import com.everis.estacionamento.estacionamentoSpring.repository.VeiculoRepository;

@RestController
@RequestMapping("/clientes/cobranca")
@CrossOrigin(origins = "http://localhost:4200")
public class CobrancaController {
	
	@Autowired
	private VeiculoRepository veiculoCobrancaReposiroty;
	
	@Autowired
	private CobrancaRepository cobrancaReposiroty;
	
	

}
