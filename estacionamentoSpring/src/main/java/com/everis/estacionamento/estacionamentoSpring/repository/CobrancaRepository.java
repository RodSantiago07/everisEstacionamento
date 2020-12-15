package com.everis.estacionamento.estacionamentoSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.estacionamento.estacionamentoSpring.model.Cobranca;

@Repository
public interface CobrancaRepository extends  JpaRepository<Cobranca, Long> {
	
}
