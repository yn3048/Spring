package kr.co.sboard.dto;

import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConfigDTO {

    @Id
    private String cate;
    private String boardName;
    private String admin;

    @ColumnDefault("0")
    private int total;

    @CreationTimestamp
    private LocalDateTime createDate;

}
