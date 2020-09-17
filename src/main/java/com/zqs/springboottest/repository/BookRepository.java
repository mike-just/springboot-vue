package com.zqs.springboottest.repository;

import com.zqs.springboottest.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: springboottest
 * @description:
 * @author: Mr.Zhang
 * @create: 2020-09-15 10:30
 **/
public interface BookRepository  extends JpaRepository<Book,Integer> {

}
