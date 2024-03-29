package kr.co.ch05.service;

import kr.co.ch05.dto.User2DTO;
import kr.co.ch05.mapper.User2Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User2Service {

    private final User2Mapper mapper;

    public User2Service(User2Mapper mapper) {
        this.mapper = mapper;
    }
    public void insertUser2(User2DTO user2DTO){
        mapper.insertUser2(user2DTO);
    }
    public User2DTO selectUser2(String uid){
        return mapper.selectUser2(uid);
    }
    public List<User2DTO> selectUser2s(){
        return mapper.selectUser2s();
    }
    public void updateUser2(User2DTO user2DTO){
        mapper.updateUser2(user2DTO);
    }
    public void deleteUser2(String uid){
        mapper.deleteUser2(uid);
    }
}
