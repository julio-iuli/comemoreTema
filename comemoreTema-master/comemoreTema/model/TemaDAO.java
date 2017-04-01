package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;





public class TemaDAO {

	private Conexao conexao;
	private PreparedStatement prepararSQL;
	
	
	public TemaDAO()throws SQLException {
		this.conexao = new Conexao();
	}
	public void inserir(Tema tema)throws SQLException{
		String sql = "insert into tema(nome,status,descricao,genero,preco,dataCompra)values(?,?,?,?,?,?)";
		prepararSQL = this.conexao.getConexao().prepareStatement(sql);
		
		prepararSQL.setString(1,tema.getNome());
		prepararSQL.setString(2,tema.getStatus());
		prepararSQL.setString(3,tema.getDescricao());
		prepararSQL.setString(4,tema.getGenero());
		prepararSQL.setDouble(5,tema.getPreco());
		prepararSQL.setDate(6,java.sql.Date.valueOf(tema.getdataCompra()));
		prepararSQL.execute();
		
		
		
	}



}

