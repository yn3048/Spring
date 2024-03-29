package kr.co.ch05.service;

import kr.co.ch05.dao.User1DAO;
import kr.co.ch05.dto.User1DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User1Service {

    private final User1DAO dao;

    public User1Service(User1DAO dao){
        this.dao = dao;
    }

    public void insertUser1(User1DTO user1DTO){
        dao.insertUser1(user1DTO);
    }
    public User1DTO selectUser1(String uid){
        return dao.selectUser1(uid);
    }
    public List<User1DTO> selectUser1s(){
        return dao.selectUser1s();
    }
    public void updateUser1(User1DTO user1DTO){
        dao.updateUser1(user1DTO);
    }
    public void deleteUser1(String uid){
        dao.deleteUser1(uid);
    }
}