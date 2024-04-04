package br.edu.iftm.manytoone.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iftm.manytoone.domain.Biblioteca;
import br.edu.iftm.manytoone.repository.BibliotecaRepository;

// A anotação @Service é usada para indicar que uma classe é um "Service" (ou "Service Layer").
// A anotação @Service é um especialização da anotação @Component e é usada para anotar classes de serviço.
// A anotação @Component é uma superclasse para outras anotações de componentes, como @Repository, @Service e @Controller.
// Uma classe anotada com @Service é tipicamente uma classe que fornece serviços de negócios, como lógica de negócios e regras de negócios.
@Service
public class BibliotecaService {

        // A anotação @Autowired é usada para injetar dependências automaticamente.
        // A anotação @Autowired pode ser usada para injetar beans em propriedades, métodos e construtores.
        @Autowired
        BibliotecaRepository repository;

        public List<Biblioteca> getAll() {
                try {
                        List<Biblioteca> livros = new ArrayList<Biblioteca>();

                        // O método findAll() retorna um Iterable que é percorrido com o método
                        // forEach() que adiciona cada item à lista items.
                        // O operador :: é usado para criar expressões lambda mais claras e concisas.
                        // A expressão lambda items::add é usada para adicionar cada item retornado pelo
                        // método findAll() à lista items.
                        // A expressão lambda items::add é equivalente a: (item) -> items.add(item)
                        repository.findAll().forEach(livros::add);
                        return livros;
                } catch (Exception e) {
                        return null;
                }
        }

        public Biblioteca getById(Long id) {
                Optional<Biblioteca> biblioteca = repository.findById(id);
                if (biblioteca.isPresent()) {
                        return biblioteca.get();
                }
                return null;
        }

        public Biblioteca create(Biblioteca biblioteca) {
                return repository.save(biblioteca);
        }

        public Biblioteca update(Long id, Biblioteca livro) {
                Optional<Biblioteca> existingLivroOptional = repository.findById(id);

                if (existingLivroOptional.isPresent()) {
                        Biblioteca existingLivro = existingLivroOptional.get();
                        existingLivro.setNome(livro.getNome());
                        return repository.save(existingLivro);
                } else {
                        return null;
                }
        }

        public boolean delete(Long id) {
                try {
                        repository.deleteById(id);
                        return true;
                } catch (Exception e) {
                        return false;
                }
        }
}