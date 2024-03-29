package kr.co.sboard.dto;

import jakarta.persistence.Id;
import kr.co.sboard.entity.File;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ArticleDTO {

    @Id
    private int no;
    private int parent;
    private int comment;
    private String cate;
    private String title;
    private String content;
    private String writer;
    private int file;
    private int hit;

    private String regip;
    private LocalDateTime rdate;

    private UserDTO user;
    private List<MultipartFile> files;

    private List<FileDTO> fileList;

    private String nick;

}
