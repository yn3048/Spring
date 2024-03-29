package kr.co.sboard.controller;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.sboard.config.AppInfo;
import kr.co.sboard.dto.ArticleDTO;
import kr.co.sboard.dto.PageRequestDTO;
import kr.co.sboard.dto.PageResponseDTO;
import kr.co.sboard.entity.Config;
import kr.co.sboard.repository.ConfigRepository;
import kr.co.sboard.service.ArticleService;
import kr.co.sboard.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Controller
public class ArticleController {

    private final ArticleService articleService;
    private final ConfigRepository configRepository;
    /*
        @ModelAttribute("cate")
         - modelAttribute("cate", cate)와 동일
    */
    @GetMapping("/article/list")
    public String list(Model model, String cate, PageRequestDTO pageRequestDTO){

        PageResponseDTO pageResponseDTO = null;

        if(pageRequestDTO.getKeyword() == null) {
            // 일반 글 목록 조회
            pageResponseDTO = articleService.selectArticles(pageRequestDTO);
        }else {
            // 검색 글 목록 조회
            pageResponseDTO = articleService.searchArticles(pageRequestDTO);
        }

        log.info("pageResponseDTO : " + pageResponseDTO);

        model.addAttribute(pageResponseDTO);

        return "/article/list";
    }

    @GetMapping("/article/write")
    public String write(Model model, String cate, PageRequestDTO pageRequestDTO){

        PageResponseDTO pageResponseDTO = PageResponseDTO.builder()
                .pageRequestDTO(pageRequestDTO)
                .build();

        model.addAttribute(pageResponseDTO);

        return "/article/write";
    }



    @GetMapping("/article/view")
    public String view(Model model, String cate, int no){
        ArticleDTO articleDTO = articleService.findById(no);

        // ✨model에 articleDTO실어서 뿌려줌 => html 문서에서 article.cate로 값 받아오기 가능
        // ✨write에서는 articleDTO 뿌려준적이 없기 때문에 param.cate로 값을 가져와야함
        model.addAttribute(articleDTO);

        return "/article/view";
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

        return "redirect:/article/list?" + "cate=" + articleDTO.getCate();
    }

    // 🎈글수정
    @GetMapping("/article/modify")
    public String modify(Model model, int no){
        // 파일 넘버로 원래 글 조회 => 괄호 안에 Article DTO article DTO 써도 되지만 그렇게 되면
        // 주소 파라미터 값이 너무 길어져서 비추함
        // 파일 넘버 값으로 글 내용 받아와서 articleDTO에 담는다.
        ArticleDTO articleDTO = articleService.findById(no);
        log.info("get article..1");
        // model => 화면에 데이터 뿌려줄 때 사용
        model.addAttribute(articleDTO);
        log.info("get article...2");
        return "/article/modify";
    }

    @PostMapping("/article/modify")
    public String modify(ArticleDTO articleDTO){
        log.info(articleDTO.toString());
        articleService.updateArticle(articleDTO);
        log.info("ddd1");
        return "redirect:/article/list?" + "cate="+ articleDTO.getCate();
    }

    // fileDownload 메서드 FileController로 이동

    //🎈 글 삭제
    @GetMapping("/article/delete")
    public String delete(int no, ArticleDTO articleDTO) {
        articleService.deleteArticle(no);
        return "redirect:/article/list?" + "cate=" + articleDTO.getCate();
    }

}
















