package kr.farmstoryapiserver.controller;

import jakarta.servlet.http.HttpServletRequest;
import kr.farmstoryapiserver.dto.UserDTO;
import kr.farmstoryapiserver.entity.User;
import kr.farmstoryapiserver.security.MyUserDetails;
import kr.farmstoryapiserver.service.UserService;
import kr.farmstoryapiserver.util.JWTProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Log4j2
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JWTProvider jwtProvider;


    @PostMapping("/user/login")
    public ResponseEntity login(@RequestBody UserDTO userDTO){

        log.info("login...1 : " + userDTO);

        try {
            // Security 인증 처리
            UsernamePasswordAuthenticationToken authToken
                    = new UsernamePasswordAuthenticationToken(userDTO.getUid(), userDTO.getPass());


            // 사용자 DB 조회
            Authentication authentication = authenticationManager.authenticate(authToken);
            log.info("login...2");

            // 인증된 사용자 가져오기
            MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
            User user = userDetails.getUser();

            log.info("login...3 : " + user);


            // 토큰 발급(액세스, 리프레쉬)
            String access  = jwtProvider.createToken(user, 1); // 1일
            String refresh = jwtProvider.createToken(user, 7); // 7일

            // 리프레쉬 토큰 DB 저장

            // 액세스 토큰 클라이언트 전송
            Map<String, Object> map = new HashMap<>();
            map.put("grantType", "Bearer");
            map.put("username", user.getUid());
            map.put("accessToken", access);
            map.put("refreshToken", refresh);

            return ResponseEntity.ok().body(map);

        }catch (Exception e){
            log.info("login...3 : " + e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user not found");
        }
    }

    @PostMapping("/user")
    public Map<String, String> register(@RequestBody UserDTO userDTO, HttpServletRequest req){

        String regip = req.getRemoteAddr();
        userDTO.setRegip(regip);
        userDTO.setRole("USER");
        log.info(userDTO);

        String uid = userService.register(userDTO);
        return Map.of("userid", uid);
    }


}