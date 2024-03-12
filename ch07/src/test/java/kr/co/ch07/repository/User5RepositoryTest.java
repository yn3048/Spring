package kr.co.ch07.repository;

import kr.co.ch07.entity.User5;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class User5RepositoryTest {

    @Autowired
    private User5Repository repository;

    @Test
    @DisplayName("user5 등록")
    public void insertUser5(){
        User5 user5 = User5.builder()
                            .name("여름밤")
                            .gender("F")
                            .age(23)
                            .addr("하와이")
                            .build();

        repository.save(user5);
    }
}