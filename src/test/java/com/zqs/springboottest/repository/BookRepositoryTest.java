package com.zqs.springboottest.repository;

import com.zqs.springboottest.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @Test
    void findAll(){
        System.out.println(bookRepository.findAll());

    }

    @Test
    void findById(){
        System.out.println(bookRepository.findById(1));
//        System.out.println(book);
    }


    /*
    * JPA中的save方法的逻辑是只这样的：
    * 先判断你保存的数据在数据库是否有(是根据主键id来判断的)，如果有则更新
    * 如果没有(主键id没有)，你的主键假如你自增的，那么将根据自增来重新添加一个新的id，别的属性不变
    *
    * */
    @Test
    void  update(){
        Book book=new Book();
        book.setId(999);
        book.setName("顾沉舟2号");
        System.out.println(bookRepository.save(book));

    }

    @Test
    void  delete(){
        bookRepository.deleteById(123);
    }

}