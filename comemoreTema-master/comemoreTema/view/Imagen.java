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
		
	  private  JButton salvarimg ;
	  private  JButton procurar;
	  private  JLabel label;
	  private  String s;
	  
	  public Imagen(){
		  super("Inserir Imagem do Tema");
		  
		  
		  salvarimg = new JButton("Salvar");
		  salvarimg.setBounds(300,200,100,40);
		  
		  procurar = new JButton("Procurar");
		  procurar.setBounds(190, 200, 100, 40);
		  		  
		  label = new JLabel();
		  label.setBounds(10,10,670,250);   
		  
		  
		//button to browse the image into Jlabel
		  procurar.addActionListener(new ActionListener(){
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
		    salvarimg.addActionListener(new ActionListener(){
		    	
		        public void actionPerformed(ActionEvent e){
		        try{
		        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/db_images","root","root");
		        PreparedStatement ps = con.prepareStatement("insert into myimages(Image) values(?)");
		        InputStream is = new FileInputStream(new File(s));
		                ps.setBlob(1,is);
		                ps.executeUpdate();
		                JOptionPane.showMessageDialog(null, "Gravada Com Sucesso");
		            }catch(Exception ex){
		                ex.printStackTrace();
		            }
		        }
		     });
		    
		    //Adcionando elementos na tela
		     add(label);
		     add(salvarimg);
		     add(procurar);
		     setLayout(null);
		     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		     setSize(600,280);
		     setLocationRelativeTo(null);
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



