package com.sistema.inventario;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.sistema.inventario.categoria.Categoria;
import com.sistema.inventario.categoria.CategoriaRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)//esta anotacion me sirve para interactuar con la base de datos real
@Rollback(false)
public class CategoriaRepositorioTest {

	
	@Autowired
	private CategoriaRepository repositorio;
	
	@Test
	public void testCrearCategoria( ) {
		
		Categoria categoriaGuardada = repositorio.save(new Categoria("Electronicos"));
		assertThat(categoriaGuardada.getId()).isGreaterThan(0);
	}
}











