package br.com.example.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

import br.com.example.springbootdemo.entity.BookEntity;
import br.com.example.springbootdemo.entity.dto.BookDTO;
import br.com.example.springbootdemo.repository.BookRepository;


@Service //aqui eu to falando que minha classe é um serviço
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<BookEntity> findAll() {
        return bookRepository.findAll();
    }

    public BookEntity findById(Long id) {
        Optional <BookEntity> entity = bookRepository.findById(id);  /*Aqui eu crio um encontrar por id, porém meu id pode achar e pode não achar por isso eu coloco o optional*/ 
        if(entity.isPresent()){ //aqui eu vejo se minha entity está presente, caso esteja eu retorno um .get();
            return entity.get();
        }
        
        throw new RuntimeException(); //aqui caso o if não ache nada eu lanço uma exceção
        
    }

    public BookEntity save(BookDTO dto) {

        BookEntity entity = new BookEntity();

        entity.setName(dto.getName());
        entity.setYear(dto.getYear());
        entity.setEdition(dto.getEdition());
        entity.setAuthor(dto.getAuthor()); /*associação do que chegar no dto(o que veio no json, por isso o get) com o setAuthor na minha entidade
        ou seja inserindo dados no meu banco*/

        return bookRepository.save(entity);
    }

    public BookEntity update(BookEntity entity, BookDTO dto) {
        entity.setName(dto.getName());
        entity.setYear(dto.getYear());
        entity.setEdition(dto.getEdition());
        entity.setAuthor(dto.getAuthor());

        return bookRepository.save(entity); //nesse update eu estou fazendo quase a mesma coisa que no save porém aqui eu estou atualizando de acordo como montei no BookController
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}