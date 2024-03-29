package kr.co.ch07.service;


import kr.co.ch07.dto.User1DTO;
import kr.co.ch07.dto.User3DTO;
import kr.co.ch07.entity.User3;
import kr.co.ch07.repository.User3Repository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Slf4j
@AllArgsConstructor
@Service
public class User3Service {

    private final User3Repository repository;

    public void insertUser3(User3DTO user3DTO){
        // DTO를 Entity로 변환
        User3 user3 = user3DTO.toEntity();

        // Entity 저장(데이터베이스 insert)
        repository.save(user3);

    }

    public User3DTO selectUser3(String uid){

        // 조회
        Optional<User3> result = repository.findById(uid);
        User3 user3 = result.get();

        return user3.toDTO();

    }


    public List<User3DTO> selectUser3s(){
        // 전체조회
        List<User3> user3s = repository.findAll();

        // 내부 반복자 사용
        List<User3DTO> user3DTOs = user3s.stream()
                .map(entity -> User3DTO.builder()
                        .uid(entity.getUid())
                        .name(entity.getName())
                        .birth(entity.getBirth())
                        .hp(entity.getHp())
                        .addr(entity.getAddr())
                        .build()
                ).collect(Collectors.toList());

        return user3DTOs;
    }
    
    public void updateUser3(User3DTO user3DTO){
        User3 user3 = user3DTO.toEntity();

        repository.save(user3);
    }
    
    public void deleteUser3(String uid){
        //Entity 삭제
        repository.deleteById(uid);
    }
}















