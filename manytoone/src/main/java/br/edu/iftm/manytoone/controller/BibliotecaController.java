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

import br.edu.iftm.manytoone.domain.Biblioteca;
import br.edu.iftm.manytoone.service.BibliotecaService;

@RestController
@RequestMapping("/biblioteca")
class BibliotecaController {

        @Autowired
        BibliotecaService service;

        @GetMapping
        public List<Biblioteca> getAll() {
                // Vemos aqui uma chamada à camada de serviço para buscar as categorias.
                // A camada de serviço não conhece o HTTP.
                // A camada de serviço lida com questões de negócio, o que inclui acesso aos dados da aplicação
                // A camada de controle lida com questões de HTTP
                List<Biblioteca> livros = service.getAll();
                return livros;
        }

        @GetMapping("{id}")
        public Biblioteca getById(@PathVariable("id") Long id) {
                return service.getById(id);
        }

        @PostMapping
        public Biblioteca create(@RequestBody Biblioteca item) {
                Biblioteca categoria = service.create(item);
                return categoria;
        }

        @PutMapping("{id}")
        public Biblioteca update(@PathVariable("id") Long id, @RequestBody Biblioteca item) {
                return service.update(id, item);
        }

        @DeleteMapping("{id}")
        public boolean delete(@PathVariable("id") Long id) {
                return service.delete(id);
        }
}