package kr.co.ch09.service;

import kr.co.ch09.dto.User3DTO;
import kr.co.ch09.entity.User3;
import kr.co.ch09.repository.User3Repository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class User3Service {

    private final User3Repository user3Repository;

    public ResponseEntity<?> insertUser3(User3DTO user3DTO) {

        if(user3Repository.existsById(user3DTO.getUid())){
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(user3DTO.getUid() + " already exsist");
        }else{
            User3 user3 = user3DTO.toEntity();
            user3Repository.save(user3);

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(user3DTO);
        }
    }

}
