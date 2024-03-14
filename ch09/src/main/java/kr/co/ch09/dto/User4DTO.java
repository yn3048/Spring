package kr.co.ch09.dto;

import jakarta.validation.constraints.*;
import kr.co.ch09.entity.User4;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class User4DTO {
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

    private String gender;

    @Min(1) // 최소값
    @Max(100) // 최대값 검사
    private int age;
    private String addr;
    private String hp;

    public User4 toEntity(){
        return User4.builder()
                .uid(uid)
                .name(name)
                .gender(gender)
                .age(age)
                .hp(hp)
                .addr(addr)
                .build();
    }
}












