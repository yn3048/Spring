package kr.co.ch06.mapper;

import kr.co.ch06.dto.User2DTO;
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
class User2MapperTest {

    @Autowired
    private User2Mapper mapper;

    @DisplayName("user2 등록")
    void insertUser2() {
        log.debug("insertUser2...");
        // 테스트 코드 패턴 : given - when - then

        // given : 테스트를 실행할 준비 단계
        User2DTO user2DTO = User2DTO.builder()
                                    .uid("d101")
                                    .name("오예스")
                                    .birth("2010-01-25")
                                    .addr("부산시")
                                    .build();

        // when : 테스트를 진행하는 단계
        mapper.insertUser2(user2DTO);

        // then : 테스트 결과를 검증하는 단계(Assertion 단정문 이용)
        User2DTO resultUser2 = mapper.selectUser2(user2DTO.getUid());
        Assertions.assertEquals(user2DTO.getUid(), resultUser2.getUid());


    }

    @DisplayName("user2 조회")
    void selectUser2() {
        log.info("selectUser2...");

        //given
        String uid = "d101";

        //when
        User2DTO user2DTO = mapper.selectUser2(uid);
        log.info(user2DTO.toString());

        //then
        assertEquals(uid, user2DTO.getUid());
    }

    @Test
    @DisplayName("user2 목록")
    void selectUser2s() {
        log.info("selectUser2s...");

        //given
        List<User2DTO> users =  null;

        //when
        users = mapper.selectUser2s();
        for(User2DTO user : users) {
            log.info(user.toString());
        }

        //then
        assertFalse(users.isEmpty());
    }

    @Test
    @DisplayName("user2 수정")
    void updateUser2() {
        log.info("updateUser2...");

        // given
        User2DTO user2DTO = User2DTO.builder()
                .uid("d101")
                .name("오예스")
                .birth("2010-01-25")
                .addr("부산시")
                .build();

        // when
        mapper.updateUser2(user2DTO);

        // then
        User2DTO resultUser2 = mapper.selectUser2(user2DTO.getUid());
        assertEquals(user2DTO.getName(), resultUser2.getName());
    }

    @Test
    @DisplayName("user2 삭제")
    void deleteUser2() {
        //given
        String uid = "d101";

        //when
        mapper.deleteUser2(uid);

        //then
        User2DTO resultUser2 = mapper.selectUser2(uid);
        assertNull(resultUser2);
    }
}