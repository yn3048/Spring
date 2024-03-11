package kr.co.ch06.mapper;

import kr.co.ch06.dto.User3DTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class User3MapperTest {

    @Autowired
    private User3Mapper mapper;


    @DisplayName("user3 등록")
    void insertUser3() {
        log.debug("insertUser1....");
        // 테스트 코드 패턴 : given - when - then

        // given : 테스트를 실행할 준비 단계
        User3DTO user3DTO = User3DTO.builder()
                                    .uid("b101")
                                    .name("김자바")
                                    .birth("2020-12-12")
                                    .hp("010-1212-1212")
                                    .addr("부산시")
                                    .build();
        // when : 테스트를 진행하는 단계
        mapper.insertUser3(user3DTO);

        // then : 테스트 결과를 검증하는 단계(Assertion 단정문 이용)
        User3DTO resultUser3 = mapper.selectUser3(user3DTO.getUid());
        Assertions.assertEquals(user3DTO.getUid(), resultUser3.getUid());
    }


    @DisplayName("user3 조회")
    void selectUser3() {
        log.info("selectUser3...");

        //given
        String uid = "b101";

        //when
        User3DTO user3DTO = mapper.selectUser3(uid);
        log.info(user3DTO.toString());

        //then
        assertEquals(uid, user3DTO.getUid());

    }


    @DisplayName("user3 목록")
    void selectUser3s() {
        log.info("selectUser3s...");

        // given
        List<User3DTO> users = null;

        // when
        users = mapper.selectUser3s();
        for(User3DTO user : users) {
            log.info(user.toString());
        }

        // then
        assertFalse(users.isEmpty());
    }

    @Test
    @DisplayName("user3 수정")
    void updateUser3() {
        log.info("updateUser3...");

        //given
        User3DTO user3DTO = User3DTO.builder()
                .uid("b101")
                .name("김자바")
                .birth("2020-12-12")
                .hp("010-1212-1212")
                .addr("부산시")
                .build();

        //when
        mapper.updateUser3(user3DTO);

        //then
        User3DTO resultUser3 = mapper.selectUser3(user3DTO.getUid());
        assertEquals(user3DTO.getName(), resultUser3.getName());
    }


    @DisplayName("user3 삭제")
    void deleteUser3() {
        //given
        String uid = "b101";

        // when
        mapper.deleteUser3(uid);

        // then
        User3DTO resultUser3 = mapper.selectUser3(uid);
        assertNull(resultUser3);
    }
}