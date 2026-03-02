package ies.alcores.libreria.controller;

import ies.alcores.libreria.model.Autor;
import ies.alcores.libreria.model.Libro;
import ies.alcores.libreria.repository.AutorRepository;
import ies.alcores.libreria.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api") // Todas las URLs de esta clase empezarán por /api
public class LibreriaController {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;

    // 1. Consulta 1: Obtener todos los libros
    @GetMapping("/libros")
    public List<Libro> obtenerTodosLosLibros() {
        return libroRepository.findAll();
    }

    // 2. Consulta 2: Obtener un libro por su ID
    @GetMapping("/libros/{id}")
    public ResponseEntity<Libro> obtenerLibroPorId(@PathVariable Integer id) {
        Optional<Libro> libro = libroRepository.findById(id);
        if (libro.isPresent()) {
            return ResponseEntity.ok(libro.get()); // Devuelve 200 OK con el libro
        } else {
            return ResponseEntity.notFound().build(); // Devuelve 404 si no existe
        }
    }

    // 3. Consulta 3: Obtener todos los autores
    @GetMapping("/autores")
    public List<Autor> obtenerTodosLosAutores() {
        return autorRepository.findAll();
    }

    // 4. Insert: Crear un nuevo libro
    @PostMapping("/libros")
    public Libro crearLibro(@RequestBody Libro libro) {
        // Al guardar, Hibernate ya sabe asociar el libro con el autor si le pasamos el id del autor
        return libroRepository.save(libro);
    }

    // 5. Delete: Eliminar un libro por su ID
    @DeleteMapping("/libros/{id}")
    public ResponseEntity<Void> borrarLibro(@PathVariable Integer id) {
        if (libroRepository.existsById(id)) {
            libroRepository.deleteById(id);
            return ResponseEntity.noContent().build(); // Devuelve 204 (Borrado con éxito)
        } else {
            return ResponseEntity.notFound().build(); // Devuelve 404 si no existe
        }
    }
}