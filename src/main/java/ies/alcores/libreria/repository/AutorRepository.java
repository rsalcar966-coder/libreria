package ies.alcores.libreria.repository;

import ies.alcores.libreria.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Integer> {
}