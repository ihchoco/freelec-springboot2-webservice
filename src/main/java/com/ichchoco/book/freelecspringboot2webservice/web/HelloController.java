package com.ichchoco.book.freelecspringboot2webservice.web;

import com.ichchoco.book.freelecspringboot2webservice.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //컨트롤러를 JSON을 반환하는 컨트롤러로 만들어 준다.(모든 메소드에 기본적으로 @ResponseBody를 추가해준것과 같다.)
public class HelloController {

    @GetMapping("/hello") //HTTP Method인 GET의 요청을 받을 수 있는 API를 만들어준다.
    //예전에는 @RequestMapping(method = RequestMethod.GET)으로 사용되었지만 지금은 이렇게 간단하게 사용 가능
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount);
    }
}
