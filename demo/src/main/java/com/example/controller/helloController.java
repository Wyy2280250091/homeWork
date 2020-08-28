package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/*@ResponseBody
@Controller*/
@RestController
public class helloController {

    @RequestMapping("/hello")
    public String hello(){
        //创建并赋值
        Map<Integer,String> map = new HashMap<>();

        map.put(1,"java");
        map.put(2,"JDK");
        map.put(3, "Spring Framework");
        map.put(4, "MyBatis framework");
        map.put(5, "Java中文社群");

        //遍历
//        map.forEach(key,value) ->{
//            System.out.println(key);
//            System.out.println(value);
//        }

        return "hello 小渣渣";
    }


}
