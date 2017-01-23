package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private Connection conexao; 

	public Connection getConexao() {
		return conexao;
	}

	public void setConexao(Connection conexao) {
		this.conexao = conexao;
	}

	public Conexao() throws SQLException {

		this.conexao = DriverManager.getConnection("jdbc:mysql://localhost:127.0.0.1:3306/comemore", "root", "root");																										
	}

}