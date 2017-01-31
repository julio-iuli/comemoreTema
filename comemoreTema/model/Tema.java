package model;

import javax.swing.JFormattedTextField;

public class Tema {

	private String nomeTema,descricaoTema,imagenTema;
	private JFormattedTextField dataTema;
	private char generoTema,statusTema;
	private double precoTema;
	
	public Tema(){
		
	}

	public Tema(String nomeTema, String descricaoTema, String imagenTema, JFormattedTextField dataTema, char generoTema,
			char statusTema, double precoTema) {
		super();
		this.nomeTema = nomeTema;
		this.descricaoTema = descricaoTema;
		this.imagenTema = imagenTema;
		this.dataTema = dataTema;
		this.generoTema = generoTema;
		this.statusTema = statusTema;
		this.precoTema = precoTema;
	}

	public String getNomeTema() {
		return nomeTema;
	}

	public void setNomeTema(String nomeTema) {
		this.nomeTema = nomeTema;
	}

	public String getDescricaoTema() {
		return descricaoTema;
	}

	public void setDescricaoTema(String descricaoTema) {
		this.descricaoTema = descricaoTema;
	}

	public String getImagenTema() {
		return imagenTema;
	}

	public void setImagenTema(String imagenTema) {
		this.imagenTema = imagenTema;
	}

	public JFormattedTextField getDataTema() {
		return dataTema;
	}

	public void setDataTema(JFormattedTextField dataTema) {
		this.dataTema = dataTema;
	}

	public char getGeneroTema() {
		return generoTema;
	}

	public void setGeneroTema(char generoTema) {
		this.generoTema = generoTema;
	}

	public char getStatusTema() {
		return statusTema;
	}

	public void setStatusTema(char statusTema) {
		this.statusTema = statusTema;
	}

	public double getPrecoTema() {
		return precoTema;
	}

	public void setPrecoTema(double precoTema) {
		this.precoTema = precoTema;
	}

}	