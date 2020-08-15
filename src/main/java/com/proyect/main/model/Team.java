package com.proyect.main.model;

public class Team {

	private int id_team,id_usu;
	public int getId_usu() {
		return id_usu;
	}
	public void setId_usu(int id_usu) {
		this.id_usu = id_usu;
	}
	private String nombre_team;

	
	
	public int getId_team() {
		return id_team;
	}
	public void setId_team(int id_team) {
		this.id_team = id_team;
	}
	
	public String getNombre_team() {
		return nombre_team;
	}
	public void setNombre_team(String nombre_team) {
		this.nombre_team = nombre_team;
	}
	
	
}
