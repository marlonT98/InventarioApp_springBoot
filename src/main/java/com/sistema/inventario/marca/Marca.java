package com.sistema.inventario.marca;

import java.util.ArrayList;
import java.util.List;

import com.sistema.inventario.categoria.Categoria;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Marca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // para que el id se valla incrementando
	private Integer id;

	@Column(length = 45, nullable = false, unique = true)
	private String nombre;

	@OneToMany
	@JoinColumn(name = "marca_id")
	private List<Categoria> categorias = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Marca(Integer id, String nombre, List<Categoria> categorias) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.categorias = categorias;
	}

	public Marca(Integer id) {
		super();
		this.id = id;
	}

	public Marca(String nombre, List<Categoria> categorias) {
		super();
		this.nombre = nombre;
		this.categorias = categorias;
	}

	public Marca() {
		super();
	}


	

}
