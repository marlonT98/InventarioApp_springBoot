package com.sistema.inventario.usuario;

import java.util.HashSet;
import java.util.Set;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // para que el id se valla incrementando
	private Integer id;

	@Column(length = 45, nullable = false, unique = true)
	private String email;

	@Column(length = 45, nullable = false, unique = true)
	private String password;

	@ManyToMany//(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)//esto sirve cuando yo persisto un objeto tambien persita a sus objetos hijos
	@JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
	private Set<Rol> roles = new HashSet<Rol>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}

	public void añadirRol(Rol rol) {

		this.roles.add(rol);

	}

	
	public void eliminarRol(Rol rol) {

		this.roles.remove(rol);

	}

	public Usuario(Integer id, String email, String password, Set<Rol> roles) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	public Usuario(String email, String password, Set<Rol> roles) {
		super();
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	public Usuario() {
		super();
	}

	public Usuario(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public Usuario(Integer id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		return "Usuario [email=" + email + "]";
	}
	
	
	
	
	
	
	
	
	
	
	

}
