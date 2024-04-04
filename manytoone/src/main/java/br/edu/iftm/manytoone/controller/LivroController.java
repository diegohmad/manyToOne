package br.edu.iftm.manytoone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.manytoone.domain.Livro;
import br.edu.iftm.manytoone.service.LivroService;

@RestController
@RequestMapping("/item")
class LivroController {

        @Autowired
        LivroService service;

        @GetMapping
        public List<Livro> getAll() {
                return service.getAll();
        }

        @GetMapping("{id}")
        public Livro getById(@PathVariable("id") Long id) {
                return service.getById(id);
        }

        @PostMapping
        public Livro create(@RequestBody Livro item) {
                return service.create(item);
        }

        @PutMapping("{id}")
        public Livro update(@PathVariable("id") Long id, @RequestBody Livro item) {
                return service.update(id, item);
        }

        @DeleteMapping("{id}")
        public boolean delete(@PathVariable("id") Long id) {
                return service.delete(id);
        }
}