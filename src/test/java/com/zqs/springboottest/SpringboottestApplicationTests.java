package com.zqs.springboottest;

import com.zqs.springboottest.entity.Book;
import com.zqs.springboottest.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringboottestApplicationTests {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void contextLoads() {
        Book book=new Book();
        book.setName("张三");
        book.setAuthor("故称之");
        bookRepository.save(book);
    }

}
