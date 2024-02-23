package com.sistema.inventario;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.sistema.inventario.usuario.Rol;
import com.sistema.inventario.usuario.Usuario;
import com.sistema.inventario.usuario.UsuarioRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE) // esta anotacion me sirve para interactuar con la base de datos real
@Rollback(false)
public class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private TestEntityManager entetyManager;

	@Test
	public void testCrearRoles() {

		Rol rolAdmin = new Rol("Administrador");
		Rol rolEditor = new Rol("Editor");
		Rol rolVisitante = new Rol("Visitante");

		entetyManager.persist(rolAdmin);
		entetyManager.persist(rolEditor);
		entetyManager.persist(rolVisitante);

	}

	@Test
	public void crearNuevoUsuarioConUnRol() {
		Rol rolAdmin = entetyManager.find(Rol.class, 1);
		Usuario usuario1 = new Usuario("marlon90@gmail.com", "1234");

		usuario1.añadirRol(rolAdmin);
		usuarioRepository.save(usuario1);

	}

	@Test
	public void crearNuevoUsuarioConDosRoles() {

		Rol rolEditor = entetyManager.find(Rol.class, 2);
		Rol rolVisitante = entetyManager.find(Rol.class, 3);

		Usuario usuario1 = new Usuario("marlonTarrillo@gmail.com", "123");

		usuario1.añadirRol(rolEditor);
		usuario1.añadirRol(rolVisitante);

		usuarioRepository.save(usuario1);

	}

	@Test
	public void testAsignarRolUsuaurioExistente() {

		Usuario usuario1 = usuarioRepository.findById(1).get();// obtenemos el usuario
		Rol rolEditor = entetyManager.find(Rol.class, 2);// obtenemos el rol de editor

		usuario1.añadirRol(rolEditor);// añadimos al usuario 1 el rol del editor
		usuarioRepository.save(usuario1);

	}

	@Test
	public void testEliminarRolDeUsuarioExistente() {
		Usuario usuario1 = usuarioRepository.findById(1).get();// obtenmos el usurio 1
		Rol rol = new Rol(2);// pasando el id del rol a eliminar(el rol 2 es el editar)

		usuario1.eliminarRol(rol);// pasamos el rol editar para que el usuario lo elimine de sus roles

	}

	@Test
	public void crearNuevoUsuarioConNuevoRol() {
		Rol rolVendedor = new Rol("Vendedor");// creando un nuevo rol
		Usuario usuario1 = new Usuario("gabrielRan@gmail.com", "111");// creamos un nuevo usuario

		usuario1.añadirRol(rolVendedor);
		usuarioRepository.save(usuario1);

	}

	@Test
	public void testObtenerUsuario() {

		Usuario usuario1 = usuarioRepository.findById(1).get();// obtenmos el usurio 1
		entetyManager.detach(usuario1);

		System.out.println(usuario1.getEmail());
		System.out.println(usuario1.getRoles());

	}
	
	
	
	@Test
	public void testEliminarUsuario( ) {
		
		usuarioRepository.deleteById(2);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
