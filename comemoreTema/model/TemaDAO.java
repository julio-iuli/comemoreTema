package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import control.Conexao;




public class TemaDAO {

	private Conexao conexao;
	private PreparedStatement prepararSQL;
	private ResultSet resultado;
	
	public TemaDAO()throws SQLException {
		this.conexao = new Conexao();
	}
	public void inserir(Tema tema)throws SQLException{
		String sql = "INSERT INTO comemore(nome,status,descricao,genero,datacompra,preco,imgtema)VALUES(?,?,?,?,?,?,?)";
		prepararSQL = this.conexao.getConexao().prepareStatement(sql);
		
		prepararSQL.setString(1,tema.getNomeTema());
		prepararSQL.setString(2,tema.getDescricaoTema());
		//falta o resto
		prepararSQL.execute();
		prepararSQL.close();
		
	}
	
	
}
