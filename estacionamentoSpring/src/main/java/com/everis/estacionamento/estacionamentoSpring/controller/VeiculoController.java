package com.everis.estacionamento.estacionamentoSpring.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.estacionamento.estacionamentoSpring.exception.ResourceNotFoundException;
import com.everis.estacionamento.estacionamentoSpring.model.Veiculo;
import com.everis.estacionamento.estacionamentoSpring.repository.VeiculoRepository;
import com.everis.estacionamento.estacionamentoSpring.service.RelatorioDTO;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "http://localhost:4200")
public class VeiculoController {
	

	@Autowired
	private VeiculoRepository clienteReposiroty;
	
	
	@Autowired
	private RelatorioDTO relatorioDto;
	
	//recuperar todos os clientes
	@GetMapping("/todosClientes")
	public List<Veiculo> recuperarTodosClientes() {
		return clienteReposiroty.findAll();
	}
	
	//criar cliente rest api
	@PostMapping("/todosClientes")
	public Veiculo criarCliente(@RequestBody Veiculo cliente) {
		return clienteReposiroty.save(cliente);
	}
	
	//recuperar o cliente pelo id - rest api
	@GetMapping("/todosClientes/{id}")
	public ResponseEntity<Veiculo> getClienteById(@PathVariable Long id) {
		
		Veiculo cliente = clienteReposiroty.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Nao Existe o cliente de ID: " + id));
		
		return ResponseEntity.ok(cliente);
		
	}
	
	//update cliente rest api
	@PutMapping("/todosClientes/{id}")
	public ResponseEntity<Veiculo> updateCliente(@PathVariable Long id, @RequestBody Veiculo clienteDetalhes) {
		
		Veiculo cliente = clienteReposiroty.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Nao Existe o cliente de ID: " + id));
		
		cliente.setMarcadocarro(clienteDetalhes.getMarcadocarro());
		cliente.setModelodocarro(clienteDetalhes.getModelodocarro());
		cliente.setPlacadocarro(clienteDetalhes.getPlacadocarro());
		cliente.setDataDeEntrada(clienteDetalhes.getDataDeEntrada());
		
		Veiculo updateCliente = clienteReposiroty.save(cliente);
		return ResponseEntity.ok(updateCliente);
	}
	
	//deletar cliente rest api
	@DeleteMapping("/todosClientes/{id}")
	public ResponseEntity<Map<String, Boolean>> deletarCliente(@PathVariable Long id){
		Veiculo cliente = clienteReposiroty.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Nao Existe o cliente de ID: " + id));
		
		clienteReposiroty.delete(cliente);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deletado", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}
	
	
	//registrar as saidas
	@PatchMapping("/todosClientes/{id}")
	public ResponseEntity<Veiculo> registrarSaida(@PathVariable Long id, @RequestBody Veiculo clienteDetalhes) {
		Veiculo cliente = clienteReposiroty.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Nao Existe o cliente de ID: " + id));
		
		
		cliente.setDataDeSaida(LocalDateTime.now());
		//cliente.setValorTotal(clienteDetalhes.getValorTotal());
		cliente.setValorTotal(clienteDetalhes.calcularValor());
		
		Veiculo updateCliente = clienteReposiroty.save(cliente);
		return ResponseEntity.ok(updateCliente);
	}
	
	
		//Recuperar saidas
		@GetMapping("/todosClientes/saidas")
		public List<Veiculo> recuperarSaidaClientes() {
			List<Veiculo> relatorio = relatorioDto.gerarRelatorio();
			return relatorio;
		}
	
}
