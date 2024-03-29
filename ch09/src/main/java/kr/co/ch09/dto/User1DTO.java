package kr.co.ch09.dto;

import kr.co.ch09.entity.User;
import kr.co.ch09.entity.User1;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class User1DTO {

    private String uid;
    private String name;
    private String hp;
    private int age;

    public User1 toEntity(){
        return User1.builder()
                .uid(uid)
                .name(name)
                .hp(hp)
                .age(age)
                .build();
    }
}












