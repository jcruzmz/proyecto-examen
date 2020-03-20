package com.thincode.ejercicio.clases;

public class Persona {
	public Persona() {
		
	}
	public Persona(int id, String nombre, int edad, String fechaNacimiento, String correo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.fechaNacimiento = fechaNacimiento;
		this.correo = correo;
	}
	private int id;
	private String nombre;
	private int edad;
	private String fechaNacimiento;
	private String correo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	@Override
	public String toString() {
		return "Persona [Id: "+this.id+" ,Nombre: "+this.nombre+" ,Edad: "+this.edad+",Fecha de Nacimiento:"+this.fechaNacimiento+" ,Correo: "+this.correo+"]";
	}
}
