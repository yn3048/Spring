package kr.co.ch08.controller;

import jakarta.servlet.http.HttpSession;
import kr.co.ch08.dto.UserDTO;
import kr.co.ch08.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@AllArgsConstructor
@Controller
public class User4Controller {

    private final UserService service;

    @GetMapping("/user4/login")
    public String login(){
        return "/user4/login";
    }

    @GetMapping("/user4/register")
    public String register(){
        return "/user4/register";
    }

    @PostMapping("/user4/register")
    public String register(UserDTO userDTO){
        service.insertUser(userDTO);
        return "redirect:/user4/login";
    }

    @GetMapping("/user4/success")
    public String success(){
        return "/user4/success";
    }

}











