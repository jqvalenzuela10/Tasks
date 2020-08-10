package com.proyect.main.model;

public class Tarea {

	private int id;
	private String descripcion;
	private boolean hecho;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isHecho() {
		return hecho;
	}
	public void setHecho(boolean hecho) {
		this.hecho = hecho;
	}
	@Override
	public String toString() {
		return "Tarea [id=" + id + ", descripcion=" + descripcion + ", hecho=" + hecho + "]";
	}
	
}
