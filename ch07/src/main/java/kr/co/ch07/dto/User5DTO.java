package kr.co.ch07.dto;

import kr.co.ch07.entity.User5;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User5DTO {
    private Integer seq;
    private String name;
    private String gender;
    private int age;
    private String addr;

    public User5 toEntity() {
        User5 user5 = new User5();
        // seq 필드가 null이 아닌 경우에만 값을 설정
        if (this.seq != null) {
            user5.setSeq(this.seq);
        }
        user5.setName(this.name);
        user5.setGender(this.gender);
        user5.setAge(this.age);
        user5.setAddr(this.addr);
        return user5;
    }
}
