package kr.co.ch07.entity;

import jakarta.persistence.*;
import kr.co.ch07.dto.User4DTO;
import kr.co.ch07.dto.User5DTO;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "user5") // 매핑 테이블 설정
public class User5 {

    @Id                 //pk 컬럼 설정
    @Column(name = "seq", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto_Increment
    private int seq;
    private String name;
    private String gender;
    private int age;
    private String addr;
    
    // DTO 변환 메서드
    public User5DTO toDTO(){
        return User5DTO.builder()
                //.seq(seq)
                .name(name)
                .gender(gender)
                .age(age)
                .addr(addr)
                .build();
    }
}
