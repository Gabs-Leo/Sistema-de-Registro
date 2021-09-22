package com.gabs.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {
	
	public void connect() {
		try {
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/objects", "root", "");
			Statement sql = cn.createStatement();
			ResultSet rs = sql.executeQuery("select * from weapons");
			System.out.println("Conectado!");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
