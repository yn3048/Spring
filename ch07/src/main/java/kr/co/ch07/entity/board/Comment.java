package kr.co.ch07.entity.board;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
// 양방향 연관관계 설정에서 toString()이 무한 순환 참조 되는 실행을 막기위해
// 해당 엔티티의 참조되는 연관 엔티티를 exclude 속성으로 제외
@ToString(exclude = "article")
@Builder
@Entity
@Table(name = "board_comment")
public class Comment {

    @Id
    // Auto Increment
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cno;

    private String content;

    @CreationTimestamp
    private LocalDateTime rdate;

    @ManyToOne
    @JoinColumn(name = "writer")
    private User user;

    @ManyToOne
    @JoinColumn(name = "parent")
    private Article article;
}























