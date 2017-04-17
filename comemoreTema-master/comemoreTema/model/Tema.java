package model;

import java.time.LocalDate;

public class Tema{
    
    private int id;
    private String nome,descricao, status,genero,imgTema;
	LocalDate dataCompra;
    private double preco;
    
    //Associacao
    protected Item item;
    protected Categoria categoria;
    
    public Tema(){
    }    
    public Tema (	int id, 
    				String nome, 
    				String descricao, 
    				String status, 
    				LocalDate dataCompra, 
    				String imgTema,
    				String genero,
    				double preco){
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.status = status;
        this.dataCompra = dataCompra;
        this.imgTema = imgTema;
        this.genero = genero;
        this.preco = preco;
    }
    
    //gets e sets
    
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return this.status;
    }
    public void setdataCompra(LocalDate dataCompra){
        this.dataCompra = dataCompra;
    }
    public LocalDate getdataCompra(){
        return dataCompra;
    }
    public void setGenero(String genero){
        this.genero = genero;
    }
    public String getGenero(){
        return genero;
    }
    public void setPreco(double preco){
        this.preco = preco;
    }
    public double getPreco(){
        return preco;
    }
    public void setImgTema(String imgTema){
        this.imgTema = imgTema;
    }
    public String getImgTema(){
        return this.imgTema;
    }
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
    
    
    
}