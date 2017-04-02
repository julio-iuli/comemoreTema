package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;





public class TemaDAO {

	private Conexao conexao;
	private PreparedStatement prepararSQL;
	private ResultSet resultado;
	
	
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
		prepararSQL.close();
			
	}

	//Listando
	
	/*public void listar(Tema tema)throws SQLException{
		String sql = "SELECT `id`, `nome`, `status`, `descricao`, `genero`, `datacompra`, `preco`, `imgtema`, `idcategoria` FROM `tema` values (?,?,?,?,?,?)";
		DefaultTableModel tabela = new DefaultTableModel();
		tabela.addColumn("Nome");
		tabela.addColumn("Status");
		tabela.addColumn("Descrição");
		tabela.addColumn("Gênero");
		tabela.addColumn("Preço");
		tabela.addColumn("Data de Compra");
		
		prepararSQL = this.conexao.getConexao().prepareStatement(sql);
		
		resultado = prepararSQL.executeQuery();
		
		while(resultado.next()){
		String[] linha = {
		resultado.getString("nome")
		};
		
		tabela.addRow(linha);
						
		}
		
		prepararSQL.close();
				
		return tabela;
	}
		*/
	


	
//fim da classe
}

