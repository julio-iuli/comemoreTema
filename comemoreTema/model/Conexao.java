package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Conexao {
	private Connection conexao;

	public Connection getConexao() {
		try {
			return conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/comemore","root","");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}