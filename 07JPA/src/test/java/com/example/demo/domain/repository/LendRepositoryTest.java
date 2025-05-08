package com.example.demo.domain.repository;

import com.example.demo.domain.entity.Book;
import com.example.demo.domain.entity.Lend;
import com.example.demo.domain.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LendRepositoryTest {

    @Autowired
    private LendRepository lendRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;


    @Test
    public void t1() throws Exception{

        //저장되어있는 도서코드를 가지는 Book
        Book book = bookRepository.findById(3333L).get();
        //저장되어있는 유저정보를 가지는 User
        User user = userRepository.findById("user2").get();

        Lend lend = new Lend();
        lend.setBook(book);
        lend.setUser(user);
        lendRepository.save(lend);
    }

    @Test
    public void t2() throws Exception{
        Lend lend = lendRepository.findById(1L).get();
        Book book = bookRepository.findById(4444L).get();
        lend.setBook(book);
        //Update
        lendRepository.save(lend);
    }

    @Test
    public void t3() throws Exception{
        lendRepository.deleteById(1L);
    }
}