package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.sql.SQLException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.TemaDAO;
import model.Tema;
import model.Conexao;

public class ListarTema extends JFrame implements ActionListener{

	private JTable tabela;
	private JButton btnExcluir,btnAtualizar;
	private int id;
	private String nome;
	private JScrollPane scrollTabela;
	private JLabel procurar;
	private JTextField campoprocurar;
	
	public ListarTema() throws SQLException {
		super("Listar Tema");
		setSize(800,400);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout(1,40,40));
		setResizable(false);
		
				
		//Aqui estou instanciando o result da dao nessa janela
		
		TemaDAO dao = new TemaDAO();
		tabela = new JTable(dao.listar());
		tabela.setBounds(0,0,800,600);
		add(tabela);

		
		
		//*************************************//
			
		
		btnExcluir = new JButton("Atualizar");
		add(btnExcluir);
		btnExcluir.addActionListener(this);
		
		btnExcluir = new JButton("Excluir");
		add(btnExcluir);
		btnExcluir.addActionListener(this);
		
		
		
		//Monstrando Tudo na Tela
		setVisible(true);			
	}
	
	
	//Instanciando a classe (só assim ela aparece!!!)
	public static void main(String[] args) throws SQLException{
		ListarTema objListarTema = new ListarTema();
		
	}

//************************************************************************//
	
	
	@Override
	public void actionPerformed(ActionEvent evento) {
		if(evento.getSource() == btnExcluir){
			try{
				Tema tema = new Tema();
				tema.setId(id);
				String mensagemTema = "Deseja excluir o Tema ";
				
				int selectedOption = JOptionPane.showConfirmDialog(null,mensagemTema,"Confirma",JOptionPane.YES_NO_OPTION);
								
				if (selectedOption == JOptionPane.YES_OPTION) {
					Tema objtema = new Tema();
					DefaultTableModel listar = new DefaultTableModel();
					int linha = tabela.getSelectedRow();
					int listarLinha = tabela.convertColumnIndexToModel(linha);
					try {
						TemaDAO dao = new TemaDAO();
						dao.excluir(objtema);
						JOptionPane.showMessageDialog(null,"Deletado com Sucesso");
					}catch (SQLException e){
						JOptionPane.showMessageDialog(null,"ERRO");
						e.printStackTrace();
					}					
				setVisible(false); //Some com a tabela
				dispose(); //Destroi a tabela
				
				//Abre uma nova tabela atualizada
				ListarTema atualizada = new ListarTema();
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	

	

	

}//fim da classe
