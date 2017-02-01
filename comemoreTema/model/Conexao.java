package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Conexao {
	public Connection getConexao() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/comemore","root","root");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}