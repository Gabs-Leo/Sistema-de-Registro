package com.gabs.sql;

public class Conexao {
	
	public String insertObject() {
		return "INSERT INTO weapons(name, price,wall_penetration, balas_por_paint, balas_reserva, head, body, leg, image)" + "values(?,?,?,?,?,?,?,?,?)";
	}
	public String loadObjects() {
		return "SELECT * FROM weapons";
	}
	
	public String updateQuery() {
		return "UPDATE weapons SET name = ?, price = ?, wall_penetration = ?, balas_por_paint = ?, balas_reserva = ?, head = ?, body = ?, leg = ? WHERE id = ?";
	}
	public String updateQueryImage() {
		return "UPDATE weapons SET name = ?, price = ?, wall_penetration = ?, balas_por_paint = ?, balas_reserva = ?, head = ?, body = ?, leg = ?, image = ? WHERE id = ?";
	}
	public String deleteObject() {
		return "DELETE FROM weapons WHERE id = ?";
	}
}
