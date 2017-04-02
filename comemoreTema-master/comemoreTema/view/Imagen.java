package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Imagen extends JFrame {
	
	
	  private  JButton button ;
	  private  JButton button2;
	  private  JLabel label;
	  private  JTextField textID;
	  private  JTextField textNAME;
	  private  JTextArea area;
	  private  String s;
	  
	  public Imagen(){
		  super("Inserir Imagem do Tema");
		  
		  button = new JButton("Salvar");
		  button.setBounds(200,300,100,40);
		  
		  button2 = new JButton("Procurar");
		  button2.setBounds(80, 300, 100, 40);
		  
		  textID = new JTextField("ID");
		  textID.setBounds(320,290,100,20);

		  textNAME = new JTextField("Name");
		  textNAME.setBounds(320,330,100,20);

		  area = new JTextArea("DESCRIPTION",100, 100);
		  
		  JScrollPane pane = new JScrollPane(area);
		  pane.setBounds(450, 270, 200, 100);
		  
		  label = new JLabel();
		  label.setBounds(10,10,670,250);   
		  
		  
		//button to browse the image into jlabel
		  button2.addActionListener(new ActionListener(){
		  @Override
		  public void actionPerformed(ActionEvent e){
		         JFileChooser fileChooser = new JFileChooser();
		         fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		         FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","gif","png");
		         fileChooser.addChoosableFileFilter(filter);
		         int result = fileChooser.showSaveDialog(null);
		         if(result == JFileChooser.APPROVE_OPTION){
		             File selectedFile = fileChooser.getSelectedFile();
		             String path = selectedFile.getAbsolutePath();
		             label.setIcon(ResizeImage(path));
		             s = path;
		              }
		         else if(result == JFileChooser.CANCEL_OPTION){
		             System.out.println("No Data");
		         }
		     }
		    });
		  
		  //button to insert image and some data into mysql database
		    button.addActionListener(new ActionListener(){
		    	
		        public void actionPerformed(ActionEvent e){
		        try{
		        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/db_images","root","root");
		        PreparedStatement ps = con.prepareStatement("insert into myimages(ID,Name,Description,Image) values(?,?,?,?)");
		        InputStream is = new FileInputStream(new File(s));
		                ps.setString(1, textID.getText());
		                ps.setString(2, textNAME.getText());
		                ps.setString(3, area.getText());
		                ps.setBlob(4,is);
		                ps.executeUpdate();
		                JOptionPane.showMessageDialog(null, "Data Inserted");
		            }catch(Exception ex){
		                ex.printStackTrace();
		            }
		        }
		     });

		     add(label);
		     add(textID);
		     add(textNAME);
		     add(pane);
		     add(button);
		     add(button2);
		     setLayout(null);
		     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		     setSize(700,420);
		     setVisible(true);
		     }
		     
		     //Methode To Resize The ImageIcon
		     public ImageIcon ResizeImage(String imgPath){
		         ImageIcon MyImage = new ImageIcon(imgPath);
		         Image img = MyImage.getImage();
		         Image newImage = img.getScaledInstance(label.getWidth(), label.getHeight(),Image.SCALE_SMOOTH);
		         ImageIcon image = new ImageIcon(newImage);
		         return image;
		     }
		  
		     public static void main(String[] args){
		         new Imagen();
		     }
		    
		    	
		    	
		    
		    	
		    
		  
		  
		  
		  
		  
		  
		  
		 
		  
		  
	
	
	
	




}//fim da classe