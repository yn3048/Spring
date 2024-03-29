package kr.co.ch04.dao;

import kr.co.ch04.dto.User4DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class User4DAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertUser4(User4DTO user4DTO) {

        String sql = "INSERT INTO `user4` values (?,?,?,?,?,?)";

        Object[] params = {
                user4DTO.getUid(),
                user4DTO.getName(),
                user4DTO.getGender(),
                user4DTO.getAge(),
                user4DTO.getHp(),
                user4DTO.getAddr()
        };

        jdbcTemplate.update(sql, params);
    }

    public User4DTO selectUser4(String uid) {
        String sql = "SELECT * FROM `user4` WHERE `uid`=?";
        return jdbcTemplate.queryForObject(sql, new USer4RowMapper(), uid);
    }

    public List<User4DTO> selectUser4s() {
        String sql = "SELECT * FROM `user4`";
        return jdbcTemplate.query(sql, new USer4RowMapper());
    }

    public void updateUser4(User4DTO user4DTO) {

        String sql = "UPDATE `user4` SET `name`=?, `gender`=?, `age`=?, `hp`=?, `addr`=? WHERE `uid`=?";

        Object[] params = {
                user4DTO.getName(),
                user4DTO.getGender(),
                user4DTO.getAge(),
                user4DTO.getHp(),
                user4DTO.getAddr(),
                user4DTO.getUid()

        };

        jdbcTemplate.update(sql, params);

    }

    public void deleteUser4(String uid) {
        String sql = "DELETE FROM `user4` WHERE `uid`=?";
        jdbcTemplate.update(sql, uid);

    }
}









