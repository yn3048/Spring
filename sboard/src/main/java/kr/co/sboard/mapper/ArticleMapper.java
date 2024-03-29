package kr.co.sboard.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ArticleMapper {
    public void insertArticle();
    public void selectArticle();
    public void selectArticles();
    public void updateByNo(int no, String title, String content);
    public void deleteArticle(int no);
}
