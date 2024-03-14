package kr.co.ch09.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class MainController {

    @GetMapping("/")
    public String index(){
        return "/index";
    }

    @GetMapping("/user1/list")
    public String user1list(){
        return "/user1/list";
    }

    @GetMapping("/user1/register")
    public String user1Register(){
        return "/user1/register";
    }

    @GetMapping("/user1/modify")
    public String user1Modify(){
        return "/user1/modify";
    }

}










