package kr.co.ch07.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.ch07.dto.User3DTO;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity // 엔티티 객체 정의
@Table(name="user3") // 매핑 테이블 설정
public class User3 {

    @Id                 // PK 컬럼 설정
    private String uid;
    
    @Column(name = "name") // 매핑 컬럼 설정(생략가능)
    private String name;
    private String birth;
    private String hp;
    private String addr;

    public User3DTO toDTO(){
        return User3DTO.builder()
                .uid(uid)
                .name(name)
                .birth(birth)
                .hp(hp)
                .addr(addr)
                .build();
    }
    
}











