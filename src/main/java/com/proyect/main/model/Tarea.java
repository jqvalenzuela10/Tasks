package com.proyect.main.model;

public class Tarea {

	private int id;
	private String descripcion;
	private boolean hecho,personal;
	
	private int id_usu;
	



	public int getId_usu() {
		return id_usu;
	}
	public void setId_usu(int id_usu) {
		this.id_usu = id_usu;
	}
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
	public boolean isPersonal() {
		return personal;
	}
	public void setPersonal(boolean personal) {
		this.personal = personal;
	}
	
	
	@Override
	public String toString() {
		return "Tarea [id=" + id + ", descripcion=" + descripcion + ", hecho=" + hecho + "]";
	}
	
}
