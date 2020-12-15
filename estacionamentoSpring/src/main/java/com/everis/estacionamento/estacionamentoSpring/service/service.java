package com.everis.estacionamento.estacionamentoSpring.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.everis.estacionamento.estacionamentoSpring.model.Veiculo;

public class service {

public static Connection getConnection() throws SQLException {
	
	try {
		Class.forName("org.h2.Driver");
		
		return DriverManager.getConnection("jdbc:h2://localhost:8080/clientes/todosClientes", "root", "root");
		
	} catch (ClassNotFoundException e) {
		throw new SQLException(e.getException());
	}
	
}

}