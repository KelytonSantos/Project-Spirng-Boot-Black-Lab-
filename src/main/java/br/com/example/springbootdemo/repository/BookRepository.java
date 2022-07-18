package br.com.example.springbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.example.springbootdemo.entity.BookEntity;

//extendendo minha interface para JpaRepository para ter os comandos de get da minha tabela
@Repository//aqui eu digo que é um repositorio
public interface BookRepository extends JpaRepository<BookEntity, Long>{ //entre as <> estou dizendo qual é a minha entidade(banco) e o tipo do meu id(Long)    

}