package br.edu.iftm.manytoone.repository;

import org.springframework.data.repository.CrudRepository;
import br.edu.iftm.manytoone.domain.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria,Long> {
    
}