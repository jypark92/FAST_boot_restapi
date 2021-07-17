package com.example.hello.Controller;

import com.example.hello.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

    @RequestMapping("/main")
    public String main(){
        return "main.html";
    }

    // ResponseEntity
    // 보통은 RestController를 만들어서 json 객체를 내려주는 방식으로 서비스해야한다.
    @ResponseBody
    @GetMapping("/user")
    public User usre(){
        var user = new User();
        user.setName("steve");
        user.setAddress("패스트캠퍼스");
        return user;
    }
}
