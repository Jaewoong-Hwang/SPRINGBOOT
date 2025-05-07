package com.example.demo.domain.repository;

import com.example.demo.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long>  {//<Entity,자료형>

    List<Book>  findByBookName(String bookName);
    List<Book>  findByPublisher(String publisher);
    List<Book>  findByIsbn(String isbn);
    Book findByBookNameAndIsbn(String bookName,String isbn);

    List<Book>  findByBookNameContains(String keyword);
}
