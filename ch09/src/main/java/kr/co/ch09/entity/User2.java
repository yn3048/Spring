package kr.co.ch09.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.ch09.dto.User2DTO;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "user2")
public class User2 {

    @Id
    private String uid;
    private String name;
    private int age;
    private String birth;
    private String addr;
    private String email;
    private String hp;

    public User2DTO toDTO(){

        return User2DTO.builder()
                .uid(uid)
                .name(name)
                .age(age)
                .birth(birth)
                .hp(hp)
                .email(email)
                .addr(addr)
                .build();
    }
}














