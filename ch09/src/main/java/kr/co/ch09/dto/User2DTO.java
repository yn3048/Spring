package kr.co.ch09.dto;

import jakarta.validation.constraints.*;
import kr.co.ch09.entity.User2;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class User2DTO {
    /*
    *   -REST API 서비스 특성상 프론트엔드에서 유효성 검사를 진행하기 어려움
    *   -@Validated, @NotBlank, @NotEmpty등 백엔드에서 유효성 검사를 진행
    *
    */


    @NotBlank // null, "", " " 모두 허용 안함 (가장 강력함!)
    @Pattern(regexp = "^[a-z0-9]{4,10}$", message = "영어 소문자와 숫자로 최소4자~최대10자 입력")
    private String uid;

    @NotEmpty // null, "" 허용 안함
    @Pattern(regexp = "^[가-힣]{2,10}$", message = "이름은 한글 2~10자 입력")
    private String name;

    @NotNull // null 허용 안함
    @Pattern(regexp = "^(19[0-9][0-9]|20\\d{2})-(0[0-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$")
    private String birth;

    @Min(1) // 최소값
    @Max(100) // 최대값 검사
    private int age;

    @Email // email 형식 검사
    private String email;

    private String addr;
    private String hp;

    public User2 toEntity(){
        return User2.builder()
                .uid(uid)
                .name(name)
                .age(age)
                .birth(birth)
                .email(email)
                .hp(hp)
                .addr(addr)
                .build();
    }
}












