package com.sistema.inventario;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.sistema.inventario.carrito.compras.ArticuloCarrito;
import com.sistema.inventario.carrito.compras.ArticuloCarritoRepository;
import com.sistema.inventario.producto.Producto;
import com.sistema.inventario.usuario.Usuario;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)//esta anotacion me sirve para interactuar con la base de datos real
@Rollback(false)
public class ArticuloCarritoTest {

	@Autowired
	private ArticuloCarritoRepository repositorio;
	
	
	@Autowired
	private TestEntityManager entetyManager;
	
	
	@Test
	public void testAñadirArticulo( ) {
		
		Producto producto =  entetyManager.find(Producto.class, 2);
		Usuario usuario = entetyManager.find(Usuario.class, 1);
		
		ArticuloCarrito articulo = new ArticuloCarrito(7,producto,usuario);
		repositorio.save(articulo);
	
	}
	
	
	
	
	
	@Test
	public void testAñadirMultiplesArticulos( ) {
		
		Usuario usuario =  new Usuario(1);
		
		Producto producto1 = new Producto(1);
		Producto producto2 = new Producto(2);


		
		ArticuloCarrito articulo1 = new ArticuloCarrito(3,producto1,usuario);
		ArticuloCarrito articulo2 = new ArticuloCarrito(5,producto2,usuario);
		
		
		repositorio.saveAll(List.of(articulo1,articulo2));
	
	}
	
	@Test
	public void testListarArticulos( ) {
		
		List<ArticuloCarrito> articulos = repositorio.findAll();
		articulos.forEach(System.out::println);
		
		
		
	}
	
	
	
	
	
	@Test
	public void testActualizarCarrito( ) {
		
		ArticuloCarrito articulo = repositorio.findById(1).get();
		articulo.setCantidad(10);
		
		articulo.setProducto(new Producto(2));
		
		
		
		
	}
	
	@Test
	public void eliminarArticulo( ) {
		
		repositorio.deleteById(1);

		
		
		
	}
	
	

	
	
	
	
	
	
	
	
	
}
