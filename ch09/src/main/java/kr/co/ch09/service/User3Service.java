package kr.co.ch09.service;

import kr.co.ch09.dto.User3DTO;
import kr.co.ch09.entity.User3;
import kr.co.ch09.repository.User3Repository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class User3Service {

    private final User3Repository user3Repository;

    public ResponseEntity<?> insertUser3(User3DTO user3DTO) {

        /*
            JPA save()는 삽입, 수정을 동시에 할 수 있는 메서드 이기 때문에
            삽입을 수행하고자 할 경우에는 먼저 미리 existById()로 존재여부를 확인하고
            save()를 수행하면 됨
         */
        if(user3Repository.existsById(user3DTO.getUid())){
            //이미 존재하는 아이디이면
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(user3DTO.getUid() + " already exsist");
        }else{
            // 존재하지 않으면
            User3 user3 = user3DTO.toEntity();
            user3Repository.save(user3);

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(user3DTO);
        }
    }
    
    public ResponseEntity<?> selectUser3(String uid){
        
        try {
            // orElseThrow() 메서드로 존재하는 Entitiy를 가져오거나 존재하지 않으면 기본 예외 NoSuchElementException 발생
            User3 user3 = user3Repository.findById(uid).orElseThrow();

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(user3.toDTO());

        }catch(Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("user not found");
        }
    }

    public ResponseEntity<List<User3DTO>> selectUser3s(){

        List<User3DTO> user3DTOs = user3Repository.findAll()
                .stream()
                .map(entity -> User3DTO.builder()
                        .uid(entity.getUid())
                        .name(entity.getName())
                        .birth(entity.getBirth())
                        .hp(entity.getHp())
                        .addr(entity.getAddr())
                        .build())
                .toList();
        return ResponseEntity
                .ok()
                .body(user3DTOs);
    }

    public ResponseEntity<?> updateUser3(User3DTO user3DTO) {

        // 수정하기 전에 먼저 존재여부 확인
        if(user3Repository.existsById(user3DTO.getUid())) {
            // 이미 존재하는 아이디면 수정
            user3Repository.save(user3DTO.toEntity());

            // 수정 후 수정 데이터 반환
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(user3DTO);
        }else {
            // 사용자가 존재하지 않으면 NOT_FOUND 응답데이터와 user not found 메세지
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("user not found");
        }
    }

    public ResponseEntity<?> deleteUser3(String uid){

        // 삭제 전 삭제할 사용자 조회
        Optional<User3> optUser3 = user3Repository.findById(uid);

        if(optUser3.isPresent()){
            // 사용자가 존재하면 삭제 후 삭제한 사용자 정보 ResponseEntity로 반환
            user3Repository.deleteById(uid);
            return ResponseEntity
                    .ok()
                    .body(optUser3.get());
        }else {
            // 사용자가 존재하지 않으면 NOT_FOUND 응답데이터와 user not found 메세지
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("user not found");
        }
    }

}













