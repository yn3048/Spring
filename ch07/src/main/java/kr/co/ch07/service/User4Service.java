package kr.co.ch07.service;


import kr.co.ch07.dto.User4DTO;
import kr.co.ch07.entity.User4;
import kr.co.ch07.repository.User4Repository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Service
public class User4Service {

    // 생성자 주입
    private final User4Repository repository;

    public void insertUser4(User4DTO user4DTO){
        User4 user4 = user4DTO.toEntity();

        repository.save(user4);
    }

    public User4DTO selectUser4(String uid){
        Optional<User4> result = repository.findById(uid);
        User4 user4 = result.get();

        return user4.toDTO();
    }

    public List<User4DTO> selectUser4s(){

        // 전체조회
        List<User4> user4s = repository.findAll();

        // 내부반복자 사용
        List<User4DTO> user4DTOs = user4s.stream()
                .map(entity -> User4DTO.builder()
                        .uid(entity.getUid())
                        .name(entity.getName())
                        .gender(entity.getGender())
                        .age(entity.getAge())
                        .hp(entity.getHp())
                        .addr(entity.getAddr())
                        .build()
                ).collect(Collectors.toList());
        return  user4DTOs;
    }

    public void updateUser4(User4DTO user4DTO){
        User4 user4 = user4DTO.toEntity();

        repository.save(user4);
    }

    public void deleteUser4(String uid){
        repository.deleteById(uid);
    }
}
