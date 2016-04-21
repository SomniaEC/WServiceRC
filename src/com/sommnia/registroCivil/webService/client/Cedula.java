package com.sommnia.registroCivil.webService.client;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author mtrujillo
 *
 */
@XmlRootElement(name = "return")
public class Cedula {
	
	private String cedula;
	
	private String codigoError;
	
	private String condicionCedulado;
	
	private String conyuge;
	
	private String error;
	
	private String estadoCivil;
	
	private String fechaNacimiento;
	
	private String genero;
	
	private String instruccion;
	
	private String lugarNacimiento;
	
	private String nacionalidad;
	
	private String nombre;
	
	private String nombreMadre;
	
	private String nombrePadre;
	
	private String profesion;
	
	private String fotografia;
	
	private String firma;
	
	public String getCedula() {
		return this.cedula;
	}
	
	@XmlElement(name = "Cedula")
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	public String getCodigoError() {
		return this.codigoError;
	}
	
	@XmlElement(name = "CodigoError")
	public void setCodigoError(String codigoError) {
		this.codigoError = codigoError;
	}
	
	public String getCondicionCedulado() {
		return this.condicionCedulado;
	}
	
	@XmlElement(name = "CondicionCedulado")
	public void setCondicionCedulado(String condicionCedulado) {
		this.condicionCedulado = condicionCedulado;
	}
	
	public String getConyuge() {
		return this.conyuge;
	}
	
	@XmlElement(name = "Conyuge")
	public void setConyuge(String conyuge) {
		this.conyuge = conyuge;
	}
	
	public String getError() {
		return this.error;
	}
	
	@XmlElement(name = "Error")
	public void setError(String error) {
		this.error = error;
	}
	
	public String getEstadoCivil() {
		return this.estadoCivil;
	}
	
	@XmlElement(name = "EstadoCivil")
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	public String getFechaNacimiento() {
		return this.fechaNacimiento;
	}
	
	@XmlElement(name = "FechaNacimiento")
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public String getGenero() {
		return this.genero;
	}
	
	@XmlElement(name = "Genero")
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public String getInstruccion() {
		return this.instruccion;
	}
	
	@XmlElement(name = "Instruccion")
	public void setInstruccion(String instruccion) {
		this.instruccion = instruccion;
	}
	
	public String getLugarNacimiento() {
		return this.lugarNacimiento;
	}
	
	@XmlElement(name = "LugarNacimiento")
	public void setLugarNacimiento(String lugarNacimiento) {
		this.lugarNacimiento = lugarNacimiento;
	}
	
	public String getNacionalidad() {
		return this.nacionalidad;
	}
	
	@XmlElement(name = "Nacionalidad")
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	@XmlElement(name = "Nombre")
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombreMadre() {
		return this.nombreMadre;
	}
	
	@XmlElement(name = "NombreMadre")
	public void setNombreMadre(String nombreMadre) {
		this.nombreMadre = nombreMadre;
	}
	
	public String getNombrePadre() {
		return this.nombrePadre;
	}
	
	@XmlElement(name = "NombrePadre")
	public void setNombrePadre(String nombrePadre) {
		this.nombrePadre = nombrePadre;
	}
	
	public String getProfesion() {
		return this.profesion;
	}
	
	@XmlElement(name = "Profesion")
	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}
	
	public String getFotografia() {
		return this.fotografia;
	}
	
	@XmlElement(name = "Fotografia")
	public void setFotografia(String fotografia) {
		this.fotografia = fotografia;
	}
	
	public String getFirma() {
		return this.firma;
	}
	
	@XmlElement(name = "Firma")
	public void setFirma(String firma) {
		this.firma = firma;
	}
}
