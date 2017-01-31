package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
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


import model.Tema;
import model.TemaDAO;


public class AppTema extends JFrame implements ActionListener{

	private JLabel lblnomeTema,lbldescricaoTema,lblgeneroTema,lblstatusTema,lbldataTema,lblpreco;
	private JTextField txtnomeTema,txtpreco;
	private JTextArea txtdescricaoTema;
	private JRadioButton rdbativo,rdbinativo,rdbmasculino,rdbfeminino,rdbindefinido;
	private JButton btnsalvar,btncancelar,btnlistar,btnimagen;
	private JDatePickerImpl dataTema;
	private ButtonGroup statusTema;
	private ButtonGroup generoTema;
	private JTextField textField;
	
	
	
	
	
	public AppTema(){
		//Frame
		super("Tema");
		setSize(600,280);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		ImageIcon icone = new ImageIcon("icon.png");
		setIconImage(icone.getImage());
		
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
		
		//group do radio button
		//status do tema
		
		lblstatusTema = new JLabel("Status");
		lblstatusTema.setBounds(40,120,40,20);
		rdbativo = new JRadioButton("Ativo");
		rdbativo.setBounds(1,140,60,20);
		rdbinativo = new JRadioButton("Inativo");
		rdbinativo.setBounds(57,140,70,20);
		statusTema = new ButtonGroup();
		statusTema.add(rdbativo);
		statusTema.add(rdbinativo);
		
		//genero
		
		lblgeneroTema = new JLabel("Gênero");
		lblgeneroTema.setBounds(230,120,50,20);
		rdbmasculino = new JRadioButton("Masculino");
		rdbmasculino.setBounds(130,140,90,20);
		rdbfeminino = new JRadioButton("Feminino");
		rdbfeminino.setBounds(220,140,85,20);
		rdbindefinido = new JRadioButton("Indefinido");
		rdbindefinido.setBounds(305,140,90,20);
		generoTema = new ButtonGroup();
		generoTema.add(rdbmasculino);
		generoTema.add(rdbfeminino);
		generoTema.add(rdbindefinido);
		
		//datapicker
		lbldataTema = new JLabel("Data da Compra");
		lbldataTema.setBounds(430,120,120,20);
		dataTema = JulioDatePicker.criar(1980,true);
		dataTema.setBounds(410,140,150,30);
		lblpreco = new JLabel("Preço do Tema");
		lblpreco.setBounds(440,175,120,20);
		txtpreco = new JTextField();
		txtpreco.setBounds(410,200,155,20);
				
		//botoes
		btnsalvar = new JButton("Salvar");
		btnsalvar.setBounds(1,200,80,40);
		btncancelar = new JButton("Cancelar");
		btncancelar.setBounds(90,200,90,40);
		btnimagen = new JButton("Imagem");
		btnimagen.setBounds(190,200,80,40);
		btnlistar = new JButton("Listar");
		btnlistar.setBounds(280,200,80,40);
		
		
		//incluindo na tela
		add(lblnomeTema);add(txtnomeTema);
		add(lbldescricaoTema);add(txtdescricaoTema);
		add(lblstatusTema);add(rdbativo);add(rdbinativo);
		add(lblgeneroTema);add(rdbmasculino);add(rdbfeminino);add(rdbindefinido);
		add(lbldataTema);add(dataTema);add(lblpreco);add(txtpreco);
		add(btnsalvar);add(btncancelar);add(btnimagen);add(btnlistar);
		
		
		
		
		
		
		setVisible(true);
	}


	
	//Radio
	
	public AppTema(JTextField textField){
        this.textField = textField;
    }
	

	
	public static void main(String[] args){
		AppTema objTema = new AppTema();
	}


	@Override
	public void actionPerformed(ActionEvent evento) {
		if(btnsalvar == evento.getSource()){
			Tema objTema = new Tema();
			objTema.setNomeTema(txtnomeTema.getText());
			
			JRadioButton rdbativo =(JRadioButton)evento.getSource();
			if(rdbativo.getText().equals("Ativo")){
				textField.setEditable(true);
			}else{
				textField.setEditable(false);
			}
			JRadioButton rdbinativo =(JRadioButton)evento.getSource();
			if(rdbinativo.getText().equals("Inativo")){
				textField.setEditable(true);
			}else{
				textField.setEditable(false);
			}
			JRadioButton rdbmasculino =(JRadioButton)evento.getSource();
			if(rdbmasculino.getText().equals("Masculino")){
				textField.setEditable(true);
			}else{
				textField.setEditable(false);
			}
			JRadioButton rdbfeminino =(JRadioButton)evento.getSource();
			if(rdbfeminino.getText().equals("Ativo")){
				textField.setEditable(true);
			}else{
				textField.setEditable(false);
			}
			objTema.setDescricaoTema(txtdescricaoTema.getText());
			objTema.setDataTema(dataTema.getJFormattedTextField());
			objTema.setPrecoTema(Double.parseDouble(txtpreco.getText()));
			
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
