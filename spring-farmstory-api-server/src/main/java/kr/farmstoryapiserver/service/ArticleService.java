package kr.farmstoryapiserver.service;


import kr.farmstoryapiserver.dto.ArticleDTO;
import kr.farmstoryapiserver.dto.PageRequestDTO;
import kr.farmstoryapiserver.dto.PageResponseDTO;
import kr.farmstoryapiserver.entity.Article;
import kr.farmstoryapiserver.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final ModelMapper modelMapper;

    public int register(ArticleDTO articleDTO){
        Article article = modelMapper.map(articleDTO, Article.class);
        Article savedArticle = articleRepository.save(article);
        return savedArticle.getNo();
    }

    public PageResponseDTO<ArticleDTO> list(PageRequestDTO pageRequestDTO) {


        log.info("pageRequestDTO : " + pageRequestDTO);

        Pageable pageable = PageRequest.of(
                pageRequestDTO.getPg() - 1 ,  // 1페이지가 0이므로 주의
                pageRequestDTO.getSize(),
                Sort.by("no").descending());

        Page<Article> pageArticle = articleRepository.findByCate(pageRequestDTO.getCate(), pageable);

        List<ArticleDTO> dtoList = pageArticle.getContent().stream()
                .map(entity -> {
                    ArticleDTO dto = modelMapper.map(entity, ArticleDTO.class);
                    //dto.setWriter(entity.getWriter().getNick());
                    return dto;
                })
                .toList();

        int total = (int) pageArticle.getTotalElements();

        PageResponseDTO<ArticleDTO> responseDTO = PageResponseDTO.<ArticleDTO>builder()
                .dtoList(dtoList)
                .pageRequestDTO(pageRequestDTO)
                .total(total)
                .build();

        return responseDTO;
    }


    public ArticleDTO get(int no) {

        Article article = articleRepository.findById(no).orElseThrow();

        ArticleDTO articleDTO = modelMapper.map(article, ArticleDTO.class);

        return articleDTO;
    }


    public void modify(ArticleDTO articleDTO) {

    }


    public void remove(int no) {

    }
}