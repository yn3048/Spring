package kr.co.ch07.repository;

import kr.co.ch07.entity.User3;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@Slf4j
@SpringBootTest
class User3RepositoryTest {

    @Autowired
    private User3Repository repository;
    
    @DisplayName("user3 등록")
    public void insertUser3(){
        User3 user3 = User3.builder()
                            .uid("z111")
                            .name("마징가제트")
                            .birth("2010-09-21")
                            .hp("010-2222-2222")
                            .addr("일본")
                            .build();

        repository.save(user3);
    }

    @Test
    @DisplayName("user3 조회")
    public void selectUser3(){
        String uid = "z111";

        Optional<User3> result = repository.findById(uid);
        User3 user3 = result.get();
        log.info(user3.toString());
    }

    @DisplayName("user3 목록")
    public void selectUser3s(){

    }

    @DisplayName("user3 수정")
    public void updateUser3(){

    }

    @DisplayName("user3 삭제")
    public void deleteUser3(){

    }
}