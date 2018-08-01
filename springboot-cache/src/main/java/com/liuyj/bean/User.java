package com.liuyj.bean;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author liuyuanju1
 * @date 2018/8/1
 * @description:
 */
@Data
@ToString
@Accessors(chain = true)
public class User implements Serializable{
    private String id;
    private String name;
    private String sex;
    private int age;
}
