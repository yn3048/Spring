package kr.co.ch10.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @GetMapping("/user/login")
    public  String login(){
        return "/user/login";
    }

    @PreAuthorize("hasAnyAuthority('USER') or hasAuthority('MANAGER') or hasAnyAuthority('ADMIN')")
    @GetMapping("/user/list")
    public String list(){
        return "/user/list";
    }
}














