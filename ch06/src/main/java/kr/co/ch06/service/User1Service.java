package kr.co.ch06.service;

import kr.co.ch06.dto.User1DTO;
import kr.co.ch06.mapper.User1Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class User1Service {

    private final User1Mapper mapper; // @AllArgsConstructor 달아주면 생성자 선언 안해줘도 됨

    public void insertUser1(User1DTO user1DTO) {
        mapper.insertUser1(user1DTO);
    }
    public User1DTO selectUser1(String uid){
        return mapper.selectUser1(uid);
    }
    public List<User1DTO> selectUser1s(){
        return mapper.selectUser1s();
    }
    public void updateUser1(User1DTO user1DTO) {
        mapper.updateUser1(user1DTO);
    }
    public void deleteUser1(String uid){
        mapper.deleteUser1(uid);
    }

}







