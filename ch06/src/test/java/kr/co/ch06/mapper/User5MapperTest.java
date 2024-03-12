package kr.co.ch06.mapper;

import kr.co.ch06.dto.User1DTO;
import kr.co.ch06.dto.User5DTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class User5MapperTest {

    @Autowired
    private User5Mapper mapper;

    @Test
    @DisplayName("user5 등록")
    void insertUser5() {
        log.info("insertUser5...");
        // 테스트 코드 패턴 : given - when - then

        // given : 테스트를 실행할 준비 단계
        User5DTO user5DTO = User5DTO.builder()
                //.seq(20)
                .name("이길동")
                .gender("F")
                .age(22)
                .addr("부산시")
                .build();
        // when: 테스트를 진행하는 단계
        mapper.insertUser5(user5DTO);

        //then : 테스트 결과를 검증하는 단계(Assertion 단정문 이용)
        User5DTO resultUser5 = mapper.selectUser5(user5DTO.getSeq());
        Assertions.assertEquals(user5DTO.getName(), resultUser5.getName());
        //        //Assertions.assertEquals(rs,1);
    }



    @DisplayName("user5 조회")
    void selectUser5() {
        log.info("selectUser5...");

        // given
        int seq = 13;
        // when
        User5DTO user5DTO = mapper.selectUser5(seq);
        log.info(user5DTO.toString());

        // then
        assertEquals(seq, user5DTO.getSeq());
        
    }


    @DisplayName("user5 목록")
    void selectUser5s() {
    }


    @DisplayName("user5 수정")
    void updateUser5() {
    }
    

    @DisplayName("user5 삭제")
    void deleteUser5() {
    }
}