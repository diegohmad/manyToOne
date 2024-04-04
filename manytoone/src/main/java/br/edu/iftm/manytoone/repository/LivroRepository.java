package br.edu.iftm.manytoone.repository;

import org.springframework.data.repository.CrudRepository;
import br.edu.iftm.manytoone.domain.Livro;

public interface LivroRepository extends CrudRepository<Livro,Long> {
    
}