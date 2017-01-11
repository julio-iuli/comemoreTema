package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jdatepicker.JDatePicker;

import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

public class AppTema extends JFrame{

	private JLabel lblnomeTema,lbldescricaoTema,lblgeneroTema,lblstatusTema,lbldataTema,lblpreco;
	private JTextField txtnomeTema,txtpreco;
	private JTextArea txtdescricaoTema;
	private JRadioButton rdbativo,rdbinativo,rdbmasculino,rdbfeminino;
	private JButton btnsalvar,btncancelar,btnlistar,btnimagen;
	private JDatePicker dataTema;
	
	
	public AppTema(){
		//Frame
		super("Tema");
		setSize(600,350);
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
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//incluindo na tela
		add(lblnomeTema);add(txtnomeTema);
		add(lbldescricaoTema);add(txtdescricaoTema);
		
		
		
		
		
		
		setVisible(true);
	}


	public static void main(String[] args){
		AppTema objTema = new AppTema();
	}
	

}
