package com.zqs.springboottest.controller;

import com.zqs.springboottest.entity.Book;
import com.zqs.springboottest.repository.BookRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 * @program: springboottest
 * @description:
 * @author: Mr.Zhang
 * @create: 2020-09-15 10:39
 **/
@Api(tags = "图书控制类")
@RestController
@RequestMapping("/book")
public class BookHandler {
    @Autowired
    private BookRepository bookRepository;

    @ApiOperation("分页")
    @GetMapping("/findAll/{page}/{size}")
    public Page<Book> findAll(@PathVariable ("page") Integer page, @PathVariable ("size") Integer size){
        Pageable pageable= PageRequest.of(page-1,size);
        return bookRepository.findAll(pageable);
    }

    @ApiOperation("保存")
    @PostMapping("/save")
    public String save(@RequestBody Book book){  //从前端接收参数，加@RequestBody可以返回json格式
        Book save = bookRepository.save(book);
        if(save!=null)
        {
            return "success";
        }
        else {
            return "error";
        }


    }
    @ApiOperation("根据id查询")
    @GetMapping("/findById/{id}")
    public Book findById(@PathVariable("id") Integer id){
        return bookRepository.findById(id).get();
    }

    @ApiOperation("修改")
    @PostMapping("/update")
    public String update(@RequestBody Book book){
        Book update = bookRepository.save(book);
        if(update!=null)
        {
            return "success";
        }
        else {
            return "error";
        }
    }

    @ApiOperation("根据id删除")
    @DeleteMapping("deleteById/{id}")
    public void delete(@PathVariable("id") Integer id){
        bookRepository.deleteById(id);
    }

}
