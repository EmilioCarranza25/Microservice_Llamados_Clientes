package com.bezkoder.spring.datajpa.model;

import javax.persistence.*;

@Entity
@Table(name = "register")
public class Register {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "plataformName")
	private String platformName;

	@Column(name = "nameCountryOperation")
	private String nameCountryOperation;
	
	@Column(name = "enfoque")
	private String enfoque;
	
	@Column(name = "categoria")
	private String categoria;
	
	@Column(name = "subCategoria")
	private String subCategoria;
	
	@Column(name = "estado")
	private Boolean estado;
	
	@Column(name = "planCliente")
	private String planCliente;
	

	public Register() {
		
	}


	public Register(String firstName, String lastName, String platformName, String nameCountryOperation, String enfoque,
			String categoria, String subCategoria, Boolean estado, String planCliente) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.platformName = platformName;
		this.nameCountryOperation = nameCountryOperation;
		this.enfoque = enfoque;
		this.categoria = categoria;
		this.subCategoria = subCategoria;
		this.estado = estado;
		this.planCliente = planCliente;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPlatformName() {
		return platformName;
	}


	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}


	public String getNameCountryOperation() {
		return nameCountryOperation;
	}


	public void setNameCountryOperation(String nameCountryOperation) {
		this.nameCountryOperation = nameCountryOperation;
	}


	public String getEnfoque() {
		return enfoque;
	}


	public void setEnfoque(String enfoque) {
		this.enfoque = enfoque;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public String getSubCategoria() {
		return subCategoria;
	}


	public void setSubCategoria(String subCategoria) {
		this.subCategoria = subCategoria;
	}


	public Boolean getEstado() {
		return estado;
	}


	public void setEstado(Boolean estado) {
		this.estado = estado;
	}


	public String getPlanCliente() {
		return planCliente;
	}


	public void setPlanCliente(String planCliente) {
		this.planCliente = planCliente;
	}


	@Override
	public String toString() {
		return "Register [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", platformName="
				+ platformName + ", nameCountryOperation=" + nameCountryOperation + ", enfoque=" + enfoque
				+ ", categoria=" + categoria + ", subCategoria=" + subCategoria + ", estado=" + estado
				+ ", planCliente=" + planCliente + "]";
	}



	
	
	
	
}
	

	
