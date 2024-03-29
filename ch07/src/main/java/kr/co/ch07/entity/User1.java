package kr.co.ch07.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.ch07.dto.User1DTO;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity // 엔티티 객체 정의
@Table(name="user1") // 매핑 테이블 설정
public class User1 {

    @Id             // PK 컬럼 설정
    private String uid;

    @Column(name = "name") // 매핑 컬럼 설정(생략 가능)
    private String name;

    @Column(name = "hp")
    private String hp;

    @Column(name = "age")
    private int age;

    // DTO 변환 메서드
    public User1DTO toDTO(){
        return User1DTO.builder()
                .uid(uid)
                .name(name)
                .hp(hp)
                .age(age).build();
    }

}














