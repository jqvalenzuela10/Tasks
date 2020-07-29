package com.proyect.main.model;

public class Category {

	private int idcategoria;
	private String descripcion;
	public int getIdcategoria() {
		return idcategoria;
	}
	public void setIdcategoria(int idcategoria) {
		this.idcategoria = idcategoria;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "Category [idcategoria=" + idcategoria + ", descripcion=" + descripcion + "]";
	}
}
