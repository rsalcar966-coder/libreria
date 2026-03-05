package ies.alcores.libreria.repository;

import ies.alcores.libreria.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libro, Integer> {

    @Query("SELECT l FROM Libro l")
    List<Libro> buscarTodosLosLibros();

    @Query("SELECT l FROM Libro l WHERE l.id = :id")
    Optional<Libro> buscarLibroPorId(@Param("id") Integer id);
}