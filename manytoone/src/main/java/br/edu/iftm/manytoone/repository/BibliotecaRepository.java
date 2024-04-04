package br.edu.iftm.manytoone.repository;

import org.springframework.data.repository.CrudRepository;
import br.edu.iftm.manytoone.domain.Biblioteca;

public interface BibliotecaRepository extends CrudRepository<Biblioteca,Long> {
    
}