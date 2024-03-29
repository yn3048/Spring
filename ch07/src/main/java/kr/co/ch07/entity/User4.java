package kr.co.ch07.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.ch07.dto.User4DTO;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity // 엔티티 객체 정의
@Table(name = "user4") // 매핑 테이블 설정
public class User4 {

    @Id                 //pk 컬럼 설정
    private String uid;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private String gender;

    @Column(name = "age")
    private int age;

    private String hp;
    private String addr;

    // DTO 변환 메서드
    public User4DTO toDTO(){
        return User4DTO.builder()
                        .uid(uid)
                        .name(name)
                        .gender(gender)
                        .age(age)
                        .hp(hp)
                        .addr(addr)
                        .build();
    }

}
