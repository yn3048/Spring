package kr.co.sboard.service;

import com.querydsl.core.Tuple;
import kr.co.sboard.dto.ArticleDTO;
import kr.co.sboard.dto.FileDTO;
import kr.co.sboard.dto.PageRequestDTO;
import kr.co.sboard.dto.PageResponseDTO;
import kr.co.sboard.entity.Article;
import kr.co.sboard.entity.Config;
import kr.co.sboard.entity.File;
import kr.co.sboard.mapper.ArticleMapper;
import kr.co.sboard.mapper.UserMapper;
import kr.co.sboard.repository.ArticleRepository;
import kr.co.sboard.repository.ConfigRepository;
import kr.co.sboard.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Slf4j
@RequiredArgsConstructor
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final ConfigRepository configRepository;
    private final FileService fileService;
    private final FileRepository fileRepository;
    private final ModelMapper modelMapper;
    private final ArticleMapper articleMapper;

    public PageResponseDTO selectArticles(PageRequestDTO pageRequestDTO){

        log.info("selectArticles...1");
        Pageable pageable = pageRequestDTO.getPageable("no");

        log.info("selectArticles...2");
        Page<Tuple> pageArticle = articleRepository.selectArticles(pageRequestDTO, pageable);

        log.info("selectArticles...3 : " + pageArticle);
        List<ArticleDTO> dtoList = pageArticle.getContent().stream()
                .map(tuple ->
                        {
                            log.info("tuple : " + tuple);
                            Article article = tuple.get(0, Article.class);
                            String nick = tuple.get(1, String.class);
                            article.setNick(nick);

                            log.info("article : " + article);

                            return modelMapper.map(article, ArticleDTO.class);
                        }
                )
                .toList();

        log.info("selectArticles...4 : " + dtoList);

        int total = (int) pageArticle.getTotalElements();

        return PageResponseDTO.builder()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total(total)
                .build();
    }

    public PageResponseDTO searchArticles(PageRequestDTO pageRequestDTO){

        Pageable pageable = pageRequestDTO.getPageable("no");
        Page<Tuple> pageArticle = articleRepository.searchArticles(pageRequestDTO, pageable);

        List<ArticleDTO> dtoList = pageArticle.getContent().stream()
                .map(tuple ->
                        {
                            log.info("tuple : " + tuple);
                            Article article = tuple.get(0, Article.class);
                            String nick = tuple.get(1, String.class);
                            article.setNick(nick);

                            log.info("article : " + article);

                            return modelMapper.map(article, ArticleDTO.class);
                        }
                )
                .toList();

        int total = (int) pageArticle.getTotalElements();

        return PageResponseDTO.builder()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total(total)
                .build();
    }

    public ArticleDTO findById(int no){

        Optional<Article> optArticle = articleRepository.findById(no);
        log.info("findById...1");

        ArticleDTO articleDTO = null;

        if(optArticle.isPresent()){
            log.info("findById...2");
            Article article = optArticle.get();

            log.info("findById...3 : " + article.toString());
            articleDTO = modelMapper.map(article, ArticleDTO.class);
            log.info("findById...4");
        }

        log.info("articleDTO : " + articleDTO.toString());

        return articleDTO;
    }


    // 🎈글 수정
    public void updateArticle(ArticleDTO articleDTO) {
        articleMapper.updateByNo(articleDTO.getNo(), articleDTO.getTitle(), articleDTO.getContent());
        log.info(""+ articleDTO);
    }

    // 🎈글 등록 with 파일
    public void insertArticle(ArticleDTO articleDTO){

        // 파일 첨부 처리
        // 파일 첨부 처리
        List<FileDTO> files = fileService.fileUpload(articleDTO);

        // 파일 첨부 갯수 초기화
        articleDTO.setFile(files.size());

        // articleDTO를 articleEntity로 변환
        Article article = modelMapper.map(articleDTO, Article.class);
        log.info(article.toString());

        // 저장 후 저장한 엔티티 객체 반환(사실 JPA sava() 메서드는 default로 저장한 Entity를 반환)
        Article savedArticle = articleRepository.save(article);
        log.info("insertArticle : " + savedArticle.toString());

        // 파일 insert
        for(FileDTO fileDTO : files){

            fileDTO.setAno(savedArticle.getNo());

            // 여기서 에러나는데 RootConfig 파일에 ModelMapper 설정에 이거 추가 -> .setMatchingStrategy(MatchingStrategies.STRICT)
            File file = modelMapper.map(fileDTO, File.class);

            fileRepository.save(file);
        }
    }

    // 🎈글 삭제
    public void deleteArticle(int no){
        articleMapper.deleteArticle(no);
    }



}