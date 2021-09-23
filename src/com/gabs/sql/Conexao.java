package com.gabs.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;

public class Conexao {
	
	public Connection getConnection() {
		try {
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/objects", "root", "");
			System.out.println("Conectado!");
			return cn;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public PreparedStatement insertObject() {
		try {
		PreparedStatement ps = this.getConnection().prepareStatement("INSERT INTO weapons(name, price,wall_penetration, balas_por_paint, balas_reserva, head, body, leg, image)" + "values(?,?,?,?,?,?,?,?,?)");
		return ps;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
