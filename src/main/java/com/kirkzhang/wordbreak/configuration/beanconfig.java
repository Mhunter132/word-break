package com.kirkzhang.wordbreak.configuration;/*
 * @ClassName beanconfig
 * @Desciption TODO
 * @Author 2020/4/3 14:48
 * @Version 1.0
 * */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class beanconfig {


    @Bean(name = "defaultDict")
    public List<String> getDefaultDict(){
        return Arrays.asList("i", "like", "sam", "sung", "samsung", "mobile", "ice", "cream", "and", "man", "go");

    }
    @Bean(name = "userDict")
    public List<String> userDictionaryList() {
        return Arrays.asList("i", "like", "sam", "sung", "samsung", "mobile", "icecream", "and", "man", "go");

    }

}
