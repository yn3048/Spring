package kr.co.ch07.repository;

import kr.co.ch07.entity.User4;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class User4RepositoryTest {

    @Autowired
    private User4Repository repository;

    @DisplayName("user4 등록")
    public void insertUser4(){

        User4 user4 = User4.builder()
                            .uid("f101")
                            .name("프레임")
                            .gender("M")
                            .age(20)
                            .hp("010-1234-1007")
                            .addr("경기도")
                            .build();

        repository.save(user4);
    }


    @DisplayName("user4 조회")
    public void selectUser4(){
        // 조회 아이디
        String uid = "f101";

        Optional<User4> result = repository.findById(uid);
        User4 user4 = result.get();
        log.info(user4.toString());
    }

    @Test
    @DisplayName("user4 목록")
    public void selectUser4s(){
        List<User4> user4s = repository.findAll();

        for(User4 user4 : user4s) {
            log.info(user4.toString());
        }
    }

    @DisplayName("user4 수정")
    public void updateUser4(){

        String uid = "f101";
    }

    @DisplayName("user4 삭제")
    public void deleteUser4(){

    }



}