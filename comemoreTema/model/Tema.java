package model;

public class Tema {

	private String nomeTema,descricaoTema,dataTema,imagenTema;
	private boolean generoTema,statusTema;
	private double precoTema;
	
	public Tema(String nomeTema, String descricaoTema, String dataTema, String imagenTema, boolean generoTema,
			boolean statusTema, double precoTema) {
		this.nomeTema = nomeTema;
		this.descricaoTema = descricaoTema;
		this.dataTema = dataTema;
		this.imagenTema = imagenTema;
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

	public String getDataTema() {
		return dataTema;
	}

	public void setDataTema(String dataTema) {
		this.dataTema = dataTema;
	}

	public String getImagenTema() {
		return imagenTema;
	}

	public void setImagenTema(String imagenTema) {
		this.imagenTema = imagenTema;
	}

	public boolean isGeneroTema() {
		return generoTema;
	}

	public void setGeneroTema(boolean generoTema) {
		this.generoTema = generoTema;
	}

	public boolean isStatusTema() {
		return statusTema;
	}

	public void setStatusTema(boolean statusTema) {
		this.statusTema = statusTema;
	}

	public double getPrecoTema() {
		return precoTema;
	}

	public void setPrecoTema(double precoTema) {
		this.precoTema = precoTema;
	}
	
	
	
	
	
	
	
	
}
