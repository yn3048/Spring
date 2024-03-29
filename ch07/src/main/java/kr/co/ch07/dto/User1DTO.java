package kr.co.ch07.dto;


import kr.co.ch07.entity.User1;
import lombok.*;

@ToString
@Data
@Builder
public class User1DTO {

    private String uid;
    private String name;
    private String hp;
    private int age;

    // Entity 변환 메서드
    public User1 toEntity(){
        return User1.builder()
                .uid(uid)
                .name(name)
                .hp(hp)
                .age(age)
                .build()
;    }
}
