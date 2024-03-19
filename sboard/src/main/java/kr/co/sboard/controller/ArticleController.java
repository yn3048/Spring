package kr.co.sboard.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class ArticleController {

    @GetMapping("/article/list")
    public String list(){
        return "/article/list";
    }

    @GetMapping("/article/write")
    public String write(){
        return "/article/write";
    }

}