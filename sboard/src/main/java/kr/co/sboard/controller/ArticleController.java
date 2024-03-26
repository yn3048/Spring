package kr.co.sboard.controller;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.sboard.dto.ArticleDTO;
import kr.co.sboard.dto.PageRequestDTO;
import kr.co.sboard.dto.PageResponseDTO;
import kr.co.sboard.entity.Article;
import kr.co.sboard.entity.Config;
import kr.co.sboard.repository.ConfigRepositioty;
import kr.co.sboard.service.ArticleService;
import kr.co.sboard.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Controller
public class ArticleController {

    private final ArticleService articleService;
    private final FileService fileService;
    private final ConfigRepositioty configRepositioty;

    /*
        @ModelAttribute("cate")
         - modelAttribute("cate", cate)와 동일
    */
    @GetMapping("/article/list")
    public String list(Model model, String cate, PageRequestDTO pageRequestDTO){

        PageResponseDTO pageResponseDTO = articleService.findByParentAndCate(pageRequestDTO);
        log.info("pageResponseDTO : " + pageResponseDTO);


        model.addAttribute(pageResponseDTO);

        return "/article/list";
    }

    @GetMapping("/article/write")
    public String write(Model model, String cate){
        return "/article/write";
    }


    @PostMapping("/article/write")
    public String write(HttpServletRequest req, ArticleDTO articleDTO){
        /*
            글작성을 테스트할 때는 로그인해야하기 때문에
            SecurityConfig 인가 설정 수정할 것
        */
        String regip = req.getRemoteAddr();
        articleDTO.setRegip(regip);

        log.info(articleDTO.toString());

        articleService.insertArticle(articleDTO);

        return "redirect:/article/list"+"?cate="+articleDTO.getCate();
    }

    @GetMapping("/article/view")
    public String view( Model model, String cate, int no){


        ArticleDTO articleDTO = articleService.findByID(no);
        // model에 articleDTO실어서 뿌려줌 => html 문서에서 article.cate로 값 받아오기 가능
        // write에서는 articleDTO 뿌려준적이 없기 때문에 param.cate로 값을 가져와야함
        model.addAttribute(articleDTO);

        return "/article/view";
    }

    // ajax로 요청
    @GetMapping("/article/filedownload")
    public ResponseEntity<?> fileDownload(int fno){
       return fileService.fileDownload(fno);

    }



    // 글 삭제
    @GetMapping("/article/delete")
    public String deleteArticle(int no, String cate) {
        articleService.deleteArticle(no);
        return "redirect:/article/list?cate=" + cate;
    }

}

















