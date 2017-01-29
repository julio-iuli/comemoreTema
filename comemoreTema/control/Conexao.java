package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private Connection conexao;
	
	public Conexao() throws SQLException{
		this.conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/comemore","","root"); //Parêmetros da conexão - servidor(nomedobanco),senha,usuário(observer localhost:3306 veja que essa é a gestão de outra porta
		
	}

	public Connection getConexao() {
		return conexao;
	}

	public void setConexao(Connection conexao) {
		this.conexao = conexao;
	}
	
	
}
