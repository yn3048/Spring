package kr.co.sboard.repository;

import kr.co.sboard.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
                                                        //Entity //Entity의 기본키 타입
public interface ArticleRepository extends JpaRepository<Article, Integer> {
}
