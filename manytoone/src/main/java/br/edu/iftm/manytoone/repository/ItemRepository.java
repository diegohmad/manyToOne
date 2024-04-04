package br.edu.iftm.manytoone.repository;

import org.springframework.data.repository.CrudRepository;
import br.edu.iftm.manytoone.domain.Item;

public interface ItemRepository extends CrudRepository<Item,Long> {
    
}