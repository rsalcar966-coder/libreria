package ies.alcores.libreria.repository;

import ies.alcores.libreria.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Integer> {

    @Query("SELECT a FROM Autor a")
    List<Autor> buscarTodosLosAutores();
}