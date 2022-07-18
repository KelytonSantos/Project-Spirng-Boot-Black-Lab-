package br.com.example.springbootdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.example.springbootdemo.entity.BookEntity;
import br.com.example.springbootdemo.entity.dto.BookDTO;
import br.com.example.springbootdemo.service.BookService;

@RestController //Aqui eu to dizendo que minha classe é um controle
@RequestMapping("/api/books") // e aqui eu configuro minha url
public class BookController {
    
    @Autowired //O Autowired instância/inicia um serviço(like this @repository or @Service) É o famoso levantar o repository(começar)
    private BookService bookService;

    @GetMapping //No momento em que alguem pesquisar minha url a coisa na qual eu vou fazer e pegar(método getMapping) toda minha lista
    public List<BookEntity> findAll(){
        return bookService.findAll();
    }

    @GetMapping ("/{id}")
    public BookEntity findById(@PathVariable Long id){
        return bookService.findById(id);
    }
    
    @PostMapping //Aqui eu to falando que é do tipo post
    @ResponseStatus(HttpStatus.CREATED)
    public BookEntity save(@RequestBody BookDTO dto){ //Com o @RequestBody eu pego os dados que coloquei no corpo da minha requisição e mando para a minha função save (lembrando que o que eu anotei no meu corpo é do tipo book dto)
        return bookService.save(dto);
    }

    @PutMapping("{id}") //é o método update, ou seja eu vou atualizar o meuo objeto
    public BookEntity updateBook(@RequestBody BookDTO dto, @PathVariable Long id){ //recebendo o dto e long id
        BookEntity bookEntity = bookService.findById(id); //aqui eu uso o id que eu recebi pra carregar a entidade e encontrar meu id
        return bookService.update(bookEntity, dto); // aqui eu mando o update atualizar o bookEntity com os dados que eu recebi no dto
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        bookService.delete(id);
    }
}