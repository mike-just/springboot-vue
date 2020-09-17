package com.zqs.springboottest.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @program: springboottest
 * @description: 图书类
 * @author: Mr.Zhang
 * @create: 2020-09-15 10:28
 **/
@Entity
@Data
@ApiModel("图书实体类")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增
    @ApiModelProperty("编号")
    private Integer id;
    @ApiModelProperty("书名")
    private String name;
    @ApiModelProperty("作者")
    private String author;

}
