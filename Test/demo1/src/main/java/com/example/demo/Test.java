package com.example.demo;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
    @RequestMapping("/simpleParam")
    public String simpleParam(HttpServletRequest request) {
//获取请求参数
        String name = request.getParameter ("name" ) ;String ageStr = request.getParameter( "age");
        int age = Integer.parseInt(ageStr) ;
        System.out.println (name+ ":" + age ) ;
        return "OK" ;
    }

}
