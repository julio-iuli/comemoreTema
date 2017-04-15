package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.TemaDAO;
import model.Tema;
import model.Conexao;

public class ListarTema extends JFrame implements ActionListener {

	private JTable tabela;
	private JButton btnExcluir,btnAtualizar;
	private JPanel contentPanel;
	
	public ListarTema() throws SQLException {
		super("Listar Tema");
		setSize(800,280);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		TemaDAO dao = new TemaDAO();
		tabela = new JTable(dao.listar());
		add(tabela,BorderLayout.NORTH);
		
		
		//*************************************//
				
		
		btnExcluir = new JButton("Atualizar");
		add(btnExcluir,BorderLayout.CENTER);
		btnExcluir.setBounds(10,20,50,60);
		btnExcluir.addActionListener(this);
		
		btnExcluir = new JButton("Excluir");
		add(btnExcluir,BorderLayout.SOUTH);
		btnExcluir.setBounds(10,20,50,60);
		btnExcluir.addActionListener(this);
		
	
		

		
		
		
		
		
		
		
		
		
		
		
		//Monstrando Tudo na Tela
		setVisible(true);			
	}
	
	

	public static void main(String[] args) throws SQLException{
		ListarTema objListarTema = new ListarTema();
		
	}



	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


















	

}//fim da classe
