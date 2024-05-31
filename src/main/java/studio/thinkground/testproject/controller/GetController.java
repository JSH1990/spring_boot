package studio.thinkground.testproject.controller;

import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import studio.thinkground.testproject.dto.MemberDTO;

/*
Get API방식.
@RequestMapping(value = "/hello", method = RequestMethod.GET) //예전의 API호출 방법
@GetMapping - 별도의 파라미터 없이 GET API를 호출하는 경우 사용되는 방법
@PathVariable - GET 형식의 요청에서 파라미터를 전달하기위해 url에 값을 담아 요청하는 방법
@RequestParam - GET 형식의 요청에서 쿼리 문자열을 전달하기 위해 사용되는 방법 , '?'를 기준으로 우측에 {키}={값}의 형태로 전달되며, 복수 형태로 전달할 경우 &를 사용함.
DTO사용 - GET 형식의 요청에서 쿼리문자열을 전달하기 위해 사용되는 방법, KEY와 VALUE가 정해져있지만, 받아야할 파라미터가 많을경우 DTO 객체를 사용한 방식.
*/

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    // http://localhost:8080/api/v1/get-api/hello
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello() {
        return "Hello World";
    }

    // http://localhost:8080/api/v1/get-api/name
    @GetMapping(value = "/name")
    public String getName() {
        return "Flature";
    }

    // http://localhost:8080/api/v1/get-api/variable1/{String 값}
    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable) {
        return variable;
    }

    /*
    위 코드와 다른점은 아래코드는 매개변수가 variable이 아닌, var이지만 괄호를 ("variable")로 묶어 var 매개변수를 넣었다.
     */

    // http://localhost:8080/api/v1/get-api/variable2/{String 값}
    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var) {
        return var;
    }

    // http://localhost:8080/api/v1/get-api/request1?name=flature&email=thinkground.flature@gmail.com&organization=thinkground
    @GetMapping(value = "/request1")
    public String getRequestParam1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization) {
        return name + " " + email + " " + organization;
    }

    // http://localhost:8080/api/v1/get-api/request2?key1=value1&key2=value2
    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param) {
        StringBuilder sb = new StringBuilder();

        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

    /*
    param.forEach((key, value) -> sb.append(key).append(" : ").append(value).append("\n"));
     */

        return sb.toString();
    }

    // http://localhost:8080/api/v1/get-api/request3?name=flature&email=thinkground.flature@gmail.com&organization=thinkground
    @GetMapping(value="/request3")
    public String getRequestParam3(MemberDTO memberDTO){
        //return memberDTO.getName() + " " + memberDTO.getEmail() + " " + memberDTO.getOrganization();
        return memberDTO.toString();
    }
}
