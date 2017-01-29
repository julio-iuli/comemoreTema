package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;


import control.Conexao;




public class TemaDAO {

	private Conexao conexao;
	private PreparedStatement prepararSQL;
	
	
	public TemaDAO()throws SQLException {
		this.conexao = new Conexao();
	}
	public void inserir(Tema tema)throws SQLException{
		String sql = "insert into tema (nome,status,descricao,genero,datacompra,preco,imgtema)VALUES(?,?,?,?,?,?,?)";
		prepararSQL = this.conexao.getConexao().prepareStatement(sql);
		
		prepararSQL.setString(1,tema.getNomeTema());
		prepararSQL.setString(2,tema.getStatusTema());
		prepararSQL.setString(3,tema.getDescricaoTema());
		prepararSQL.setString(4,tema.getGeneroTema());
		//prepararSQL.setDate(5,java.sql.Date.valueOf(tema.getDataTema()));
		prepararSQL.setDouble(6,tema.getPrecoTema());
		prepararSQL.setString(7,tema.getImagenTema());
		prepararSQL.execute();
		
		
	}

	


public void alterar(Tema tema) throws SQLException{
	String sql = "update tema set nome = ?,status = ?,genero = ?,datacompra = ?,preco = ?,imgtema = ? where id = ?";
	prepararSQL = this.conexao.getConexao().prepareStatement(sql);

	prepararSQL.setString(1,tema.getNomeTema());
	prepararSQL.setString(2,tema.getStatusTema());
	prepararSQL.setString(3,tema.getDescricaoTema());
	prepararSQL.setString(4,tema.getGeneroTema());
	//prepararSQL.setDate(5,java.sql.Date.valueOf(tema.getDataTema()));
	prepararSQL.setDouble(6,tema.getPrecoTema());
	prepararSQL.setString(7,tema.getImagenTema());
	prepararSQL.execute();
	
	
	}
}

