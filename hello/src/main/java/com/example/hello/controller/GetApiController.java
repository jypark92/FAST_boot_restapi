package com.example.hello.Controller;

import com.example.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path = "/hello") //http://localhost:8080/api/get/hello
    public String getHello(){
        return "get Hello";
    }

    @RequestMapping(path = "/hi", method = RequestMethod.GET) //get / post/ put / delete
    public String hi(){
        return "hi";
    }

    // http://localhost:8080/api/get/path-variable/{name}
    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable(name = "name") String pathName){ // pathVariable 이름과 동일한 다른 값이 있을 경우 (name=)을 통하여 매핑해줄 수 있다.
        System.out.println("PathVariable : " + pathName);
        return pathName;
    }

    //queryParameter
    // http://localhost:8080/api/get/query-parameter?user=steve&email=steve@gmail.com&age=30
    @GetMapping("query-param")
    public String queryParam(@RequestParam Map<String,String> queryParam){
        StringBuilder sb = new StringBuilder();
        queryParam.entrySet().forEach(entry ->{
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey() + " = " + entry.getValue() + "\n");
        });
        return sb.toString();
    }

    @GetMapping("/query-param02")
    public String queryParam02(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ){

        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name + " " + email + " " + age;
    }

    //?user=steve&email=steve@gmail.com&age=30
    //이때 RequestParam을 사용하지 않는다.
    //자동으로 Dto 멤버변수 이름과 키 name 을 매핑 시켜준다.

    //가장 추천하는 방법
    @GetMapping("/query-param03")
    public String queryParam03(UserRequest userRequest){

        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
    }

}
