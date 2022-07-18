package br.com.example.springbootdemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //to dizendo para o spring que minha classe é uma entidade;
@Table(name = "book")//aqui eu to indicando que minha tabela vai ser book caso não colocasse, o default seria o nome da minha classe
public class BookEntity {
    
    @Id//Estou dizendo que o meu Long id é meu id.
    @GeneratedValue(strategy = GenerationType.IDENTITY)//to falando que ele vai se auto incrementar
    private Long id;
    private String name;
    private String year;
    private double edition;
    private String author;

    public BookEntity(){
    }

    public BookEntity(Long id, String name, String year, double edition, String author) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.edition = edition;
        this.author = author;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public double getEdition() {
        return edition;
    }
    public void setEdition(double edition) {
        this.edition = edition;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    //vamos para repository para fazer a conexão com esse banco
}

