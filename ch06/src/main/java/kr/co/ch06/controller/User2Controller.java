package kr.co.ch06.controller;

import kr.co.ch06.dto.User2DTO;
import kr.co.ch06.service.User2Service;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Controller
public class User2Controller {

    // @AllArgsConstructor 선언으로 생성자 주입 -> 따로 생성자 정의 필요 없음
    private final User2Service service;

    @GetMapping("/user2/list")
    public String list(Model model) {
        List<User2DTO> users = service.selectUser2s();
        log.info(users.toString());

        model.addAttribute("users", users);
        return "/user2/list";
    }

    @GetMapping("/user2/register")
    public String register(){
        return "/user2/register";
    }

    @PostMapping("/user2/register")
    public String register(User2DTO user2DTO){
        log.info(user2DTO.toString());
        service.insertUser2(user2DTO);
        return "/user2/register";
    }

    @GetMapping("/user2/modify")
    public String modify(String uid, Model model){ // Spring Boot는 @RequestParam 선언 안해도 됨
        
        User2DTO user2DTO = service.selectUser2(uid);

        model.addAttribute(user2DTO);
        return "/user2/modify";
    }

    @PostMapping("/user2/modify")
    public String modify(User2DTO user2DTO){
        log.info(user2DTO.toString());

        service.updateUser2(user2DTO);
        return "redirect:/user2/list";

    }

    @GetMapping("/user2/delete")
    public String delete(String uid) {
        log.info("delete : " +uid);

        service.deleteUser2(uid);
        return "redirect:/user2/list";
    }


}
