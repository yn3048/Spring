package kr.co.ch07.repository;

import kr.co.ch07.entity.User2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class User2RepositoryTest {

    @Autowired
    private User2Repository repository;

    @DisplayName("user2 등록")
    public void insertUser2(){
        User2 user2 = User2.builder()
                            .uid("b101")
                            .name("아몬드")
                            .birth("1980-01-20")
                            .addr("제주도")
                            .build();

        repository.save(user2);
    }

    @Test
    @DisplayName("user2 조회")
    public void selectUser2(){
        // given - 조회 아이디
        String uid = "b101";

        // when - 조회하기
        Optional<User2> result = repository.findById(uid);
        User2 user2 = result.get();
        log.info(user2.toString());
    }
}


















