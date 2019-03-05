package com.fer.modelo;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class Libro implements Serializable{
	private String titulo;
	private ArrayList<String> libro;
	private int numPaginas;
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public ArrayList<String> getLibro() {
		return libro;
	}
	public void setLibro(ArrayList<String> libro) {
		this.libro = libro;
	}
	public int getNumPaginas() {
		return numPaginas;
	}
	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}
}
