package kr.co.ch06.mapper;

import kr.co.ch06.dto.User4DTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class User4MapperTest {

    private User4Mapper mapper;
    
    @Test
    @DisplayName("user4 등록")
    void insertUser4() {
        log.debug("insertUser4...");
        // given
        User4DTO user4DTO = User4DTO.builder()
                                    .uid("c101")
                                    .name("박자바")
                                    .gender("M")
                                    .age(25)
                                    .hp("010-9988-7755")
                                    .addr("서울시")
                                    .build();
        // when: 테스트를 진행하는 단계
        mapper.insertUser4(user4DTO);

        // then : 테스트 결과를 검증하는 단계
        User4DTO resultUser4 = mapper.selectUser4(user4DTO.getUid());
        Assertions.assertEquals(user4DTO.getUid(), resultUser4.getUid());
    }

    @Test
    @DisplayName("user4 조회")
    void selectUser4() {
        log.info("selectUser4...");

        //given
        String uid = "c101";

        //when
        User4DTO user4DTO = mapper.selectUser4(uid);
        log.info(user4DTO.toString());

        //then
        assertEquals(uid, user4DTO.getUid());
    }

    @Test
    @DisplayName("user4 목록")
    void selectUser4s() {
        log.info("selectUser4s");

        // given
        List<User4DTO> users = null;

        // when
        users = mapper.selectUser4s();
        for(User4DTO user : users){
            log.info(user.toString());
        }
        // then
        assertFalse(users.isEmpty());
    }

    @Test
    @DisplayName("user4 수정")
    void updateUser4() {
        log.info("updateUser4...");

        //given
        User4DTO user4DTO = User4DTO.builder()
                                    .uid("c101")
                                    .name("박자바")
                                    .gender("M")
                                    .age(25)
                                    .hp("010-9988-7755")
                                    .addr("서울시")
                                    .build();

        //when
        mapper.updateUser4(user4DTO);

        //then
        User4DTO resultUser4 = mapper.selectUser4(user4DTO.getUid());
        assertEquals(user4DTO.getName(), resultUser4.getName());
    }

    @Test
    @DisplayName("user4 삭제")
    void deleteUser4() {
        //given
        String uid = "c101";

        //when
        mapper.deleteUser4(uid);

        //then
        User4DTO resultUser4 = mapper.selectUser4(uid);
        assertNull(resultUser4);
    }
}











