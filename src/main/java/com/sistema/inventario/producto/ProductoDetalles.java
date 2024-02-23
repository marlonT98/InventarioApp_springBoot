package com.sistema.inventario.producto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto_detalles")
public class ProductoDetalles {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // para que el id se valla incrementando
	private Integer id;

	@Column(length = 45, nullable = false)
	private String nombre;
	

	@Column(length = 45, nullable = false)
	private String valor;
	
	@ManyToOne //muchos detalles le petenecen a este producto
	@JoinColumn(name = "producto_id")
	private Producto producto;

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

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public ProductoDetalles(Integer id, String nombre, String valor, Producto producto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.valor = valor;
		this.producto = producto;
	}

	public ProductoDetalles(String nombre, String valor, Producto producto) {
		super();
		this.nombre = nombre;
		this.valor = valor;
		this.producto = producto;
	}

	public ProductoDetalles() {
		super();
	}

	@Override
	public String toString() {
		return nombre +" - " +valor;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
