package kr.co.sboard.controller;

import kr.co.sboard.dto.ArticleDTO;
import kr.co.sboard.service.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@RequiredArgsConstructor
@Controller
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/article/list")
    public String list(){

        return "/article/list";
    }

    @GetMapping("/article/write")
    public String write(){

        return "/article/write";
    }
    
    // 글등록
    @PostMapping("/article/write")
    public String writeArticle(@RequestParam("title") String title,
                               @RequestParam("content") String content) {
        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setTitle(title);
        articleDTO.setContent(content);

        articleService.insertArticle(articleDTO);

        return "redirect:/article/list";
    }

}