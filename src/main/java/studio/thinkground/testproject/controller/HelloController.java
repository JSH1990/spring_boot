package studio.thinkground.testproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello") //별도의 파라미터 없이 GET API를 호출하는 경우.
    public String hello(){
        return "Hello World";
    }
}
