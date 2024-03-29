package kr.co.ch09.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.ch09.dto.User3DTO;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "user3")
public class User3 {

    @Id
    private String uid;
    private String name;
    private String birth;
    private String addr;
    private String hp;

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














