package kr.co.ch09.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.ch09.dto.User4DTO;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "user4")
public class User4 {

    @Id
    private String uid;
    private String name;
    private String gender;
    private int age;
    private String addr;
    private String hp;

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














