package view;
//Esse daqui
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePickerImpl;

import com.mysql.fabric.xmlrpc.base.Array;
import com.sun.glass.events.KeyEvent;

import model.Tema;
import model.TemaDAO;


public class AppTema extends JFrame implements ActionListener{

	private JLabel lblnomeTema,lbldescricaoTema,lblgeneroTema,lblstatusTema,lbldataCompra,lblpreco;
	private JTextField txtnomeTema,txtpreco;
	private JTextArea txtdescricaoTema;
	private JComboBox status,genero;
	private JButton btnsalvar,btncancelar,btnlistar,btnimagen;
	private JDatePickerImpl dataCompra;
	
	
	public AppTema(){
		//Frame
		super("Tema");
		setSize(600,280);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
				
		//Elementos da Tela
		
		//Nome do Tema
		lblnomeTema = new JLabel("Nome do Tema");
		lblnomeTema.setBounds(1,1,105,20);
		txtnomeTema = new JTextField(100);
		txtnomeTema.setBounds(88,1,490,20);
		
		//descricao do tema
		lbldescricaoTema = new JLabel("Descrição do Tema");
		lbldescricaoTema.setBounds(1,60,110,20);
		txtdescricaoTema = new JTextArea(50,50);
		txtdescricaoTema.setBounds(115,35,460,80);
				
		//status do tema
		lblstatusTema = new JLabel("Status");
		lblstatusTema.setBounds(40,120,40,20);
		
		//Combo box status
		String[] array_status = {"","Ativo","Inativo"};
		status = new JComboBox(array_status);
		status.setSelectedIndex(0);
		status.setBounds(40,140,65,20);
				
		//genero
		lblgeneroTema = new JLabel("Gênero");
		lblgeneroTema.setBounds(230,120,50,20);
		
		//Combo box genero
		String[] array_genero = {"","Masculino","Feminino","Indefinido"};
		genero = new JComboBox(array_genero);
		genero.setSelectedIndex(0);
		genero.setBounds(230,140,100,20);
		
		
		//datapicker do julix
		lbldataCompra = new JLabel("Data da Compra");
		lbldataCompra.setBounds(430,120,120,20);
		dataCompra = JulioDatePicker.criar(1980,true);
		dataCompra.setBounds(410,140,150,30);
		lblpreco = new JLabel("Preço do Tema");
		lblpreco.setBounds(440,175,120,20);
		txtpreco = new JTextField();
		txtpreco.setBounds(410,200,155,20);
				
		//botoes
		btnsalvar = new JButton("Salvar");
		btnsalvar.setBounds(1,200,80,40);
		btnsalvar.addActionListener(this);
		btncancelar = new JButton("Cancelar");
		btncancelar.setBounds(90,200,90,40);
		btncancelar.addActionListener(this);
		btnimagen = new JButton("Imagem");
		btnimagen.setBounds(190,200,80,40);
		btnlistar = new JButton("Listar");
		btnlistar.setBounds(280,200,80,40);
		btnlistar.addActionListener(this);
				
		//incluindo na tela
		add(lblnomeTema);add(txtnomeTema);
		add(lbldescricaoTema);add(txtdescricaoTema);
		add(lblstatusTema);
		add(lblgeneroTema);
		add(lbldataCompra);add(dataCompra);add(lblpreco);add(txtpreco);
		add(btnsalvar);add(btncancelar);add(btnimagen);add(btnlistar);
		add(status);add(genero);
		
			
		
		setVisible(true);
	}

	
	//************* OUTROS MÉTODOS AQUI  **************//
	
	
	
	
	
	//************************************************//
	
	//Instanciando a classe principal
	
	public static void main(String[] args){
		AppTema objTema = new AppTema();
		
	}
	
	// Pegando os dados 
	@Override
	public void actionPerformed(ActionEvent evento) {
		if(btnsalvar == evento.getSource()){
			Tema objTema = new Tema();
			objTema.setNome(txtnomeTema.getText());
			objTema.setStatus(status.getSelectedItem().toString());
	       	objTema.setDescricao(txtdescricaoTema.getText());	
			objTema.setGenero(genero.getSelectedItem().toString());
			objTema.setPreco(Double.parseDouble(txtpreco.getText()));
			objTema.setdataCompra(LocalDate.parse(dataCompra.getJFormattedTextField().getText()));
			try{
			TemaDAO dao = new TemaDAO();
			dao.inserir(objTema);
			JOptionPane.showConfirmDialog(null,"Gravado com Sucesso");
			}catch (SQLException e){
				JOptionPane.showMessageDialog(null,"ERRO");
				e.printStackTrace();
				
			}
		}
	}
}
