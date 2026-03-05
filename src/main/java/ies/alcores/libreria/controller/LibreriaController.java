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
@RequestMapping("/api")
public class LibreriaController {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @GetMapping("/libros")
    public List<Libro> obtenerTodosLosLibros() {
        return libroRepository.buscarTodosLosLibros();
    }

    @GetMapping("/libros/{id}")
    public ResponseEntity<Libro> obtenerLibroPorId(@PathVariable Integer id) {
        Optional<Libro> libro = libroRepository.buscarLibroPorId(id);
        if (libro.isPresent()) {
            return ResponseEntity.ok(libro.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/autores")
    public List<Autor> obtenerTodosLosAutores() {
        return autorRepository.buscarTodosLosAutores();
    }

    @PostMapping("/libros")
    public Libro crearLibro(@RequestBody Libro libro) {
        return libroRepository.save(libro);
    }

    @DeleteMapping("/libros/{id}")
    public ResponseEntity<Void> borrarLibro(@PathVariable Integer id) {
        if (libroRepository.existsById(id)) {
            libroRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}