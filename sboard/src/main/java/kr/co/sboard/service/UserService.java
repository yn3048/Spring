package kr.co.sboard.service;

import jakarta.mail.Message;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpSession;
import kr.co.sboard.dto.TermsDTO;
import kr.co.sboard.dto.UserDTO;
import kr.co.sboard.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    // JavaMailSender 주입
    private final JavaMailSender javaMailSender;

    public TermsDTO selectTerms(){
        return userMapper.selectTerms();
    }

    public int selectCountUser(String type, String value) {
        return userMapper.selectCountUser(type, value);
    }

    // 아이디 찾기
   // public UserDTO selectUserForFindId(UserDTO userDTO){
     //   return userMapper.selectUserForFindId(userDTO.getName(), userDTO.getEmail());
   // }

  /*  public String findUid(String name, String email){
        UserDTO userDTO = new UserDTO();
        userDTO.setName(name);
        userDTO.setEmail(email);

        // UserMapper를 사용하여 사용자 조회
        UserDTO foundUser = userMapper.selectUserForFindId(userDTO);

        if(foundUser != null) {

        }
    }*/

    public void insertUser(UserDTO userDTO){
        String encoded = passwordEncoder.encode(userDTO.getPass());
        userDTO.setPass(encoded);

        userMapper.insertUser(userDTO);
    }

    @Value("${spring.mail.username}")
    private String sender;

    public void sendEmailCode(HttpSession session, String receiver){

        log.info("sender : " + sender);

        // MimeMessage 생성
        MimeMessage message = javaMailSender.createMimeMessage();

        // 인증코드 생성 후 세션 저장
        int code = ThreadLocalRandom.current().nextInt(100000, 1000000);
        session.setAttribute("code", String.valueOf(code));

        log.info("code : " + code);

        String title = "sboard 인증코드 입니다.";
        String content = "<h1>인증코드는 " + code + "입니다.</h1>";

        try {
            message.setFrom(new InternetAddress(sender, "보내는 사람", "UTF-8"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
            message.setSubject(title);
            message.setContent(content, "text/html;charset=UTF-8");

            javaMailSender.send(message);

        }catch(Exception e){
            log.error("sendEmailConde : " + e.getMessage());
        }

    }


    public void selectUsers(){}
    public void updateUser(){}
    public void deleteUser(){}


}
