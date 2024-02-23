package com.sistema.inventario.producto;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sistema.inventario.categoria.Categoria;
import com.sistema.inventario.categoria.CategoriaRepository;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ProductoController {

	@Autowired
	private ProductoRepositorio productoRepository;
	
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	
	
	@GetMapping("productos/nuevo")
	public String mostrarFormularioDeNuevoProducto(  Model modelo) {
		
		List<Categoria> listaCategorias = categoriaRepository.findAll();
		
		modelo.addAttribute("producto", new Producto());
		modelo.addAttribute("listaCategorias",listaCategorias);
		return "producto_formulario";
		
	}
	
	
	@PostMapping("/productos/guardar")
	public String guardarProducto( Producto producto, HttpServletRequest request) {
		
		
		String[] detallesIds= request.getParameterValues("detalleID");
		String[] detallesNombres= request.getParameterValues("detallesNombre");
		String[] detallesValores= request.getParameterValues("detallesValor");
		
		for(int i =0; i<detallesNombres.length;i++) {
		
			if(detallesIds != null && detallesIds.length>0) {
				
				producto.setDetalle(Integer.valueOf(detallesIds[i]), detallesNombres[i],detallesValores[i]);
				
			}else {
				
				
				
				producto.añadirDetalles(detallesNombres[i],detallesValores[i]);
			}
			
				
			
			
			
			
		}
		
		
		productoRepository.save(producto);
		return "redirect:/";//a la pagina de inicio
		
		
		
		
	}
	
	@GetMapping("/productos")
	public String listarProductos( Model modelo ) {
		
		
		List<Producto> listaProductos = productoRepository.findAll();
		modelo.addAttribute("listaProductos",listaProductos);
		return "productos";
		
		
		
	}
	
	
      @GetMapping("productos/editar/{id}")
      public String mostrarFormularioDeModificarProducto( @PathVariable("id")Integer id , Model modelo ) {
    	  
    	  Producto producto = productoRepository.findById(id).get();
    	  modelo.addAttribute("producto",producto);
    	  
    		List<Categoria> listaCategoria= categoriaRepository.findAll();
    		modelo.addAttribute("listaCategorias",listaCategoria);
    	  
    	  return "producto_formulario";
    	  
    	  
    	  
      }
      
      
      @GetMapping("/productos/eliminar/{id}")
      public String eliminarProducto(@PathVariable("id") Integer id , Model model ) {
    	  
    	  productoRepository.deleteById(id);
    	  return "redirect:/productos";
    	  
    	  
      }
	
	
	
	
	
	
	
}
