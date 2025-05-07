package com.example.demo.domain.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void t2() {
        //INSERT
//        User user =
//                User.builder()
//                        .username("홍길동")
//                        .password("1234")
//                        .role("admin")
//                        .build();
////        userRepository.save(user);
//
//        //UPDATE
//        user.setUsername("홍길동");
//        user.setPassword("4321");
//        user.setRole("manager");
//
//        userRepository.save(user);
        
        //DELETE
        userRepository.deleteById("홍길동");

    }
}