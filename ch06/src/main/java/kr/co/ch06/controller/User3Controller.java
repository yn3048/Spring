package kr.co.ch06.controller;

import kr.co.ch06.dto.User3DTO;
import kr.co.ch06.service.User3Service;
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
public class User3Controller {

    // @AllArgsConstructor 선언으로 생성자 주입 -> 따로 생성자 정의 필요 없음
    private final User3Service service;

    @GetMapping("/user3/list")
    public String list(Model model) {
        List< User3DTO> users = service.selectUser3s();
        log.info(users.toString());

        model.addAttribute("users", users);
        return "/user3/list";

    }

    @GetMapping("/user3/register")
    public String register(){
        return "/user3/register";
    }

    @PostMapping("/user3/register")
    public String register(User3DTO user3DTO) {
        log.info(user3DTO.toString());
        service.insertUser3(user3DTO);
        return "/user3/register";
    }

    @GetMapping("/user3/modify")
    public String modify(String uid, Model model){
        log.info("modify : " + uid);

        User3DTO user3DTO = service.selectUser3(uid);
        log.info(user3DTO.toString());

        model.addAttribute(user3DTO);
        return "/user3/modify";
    }

    @PostMapping("/user3/modify")
    public String modify(User3DTO user3DTO) {
        log.info(user3DTO.toString());

        service.updateUser3(user3DTO);
        return "redirect:/user3/list";
    }

    @GetMapping("/user3/delete")
    public String delete(String uid){
        log.info("delete : " + uid);

        service.deleteUser3(uid);
        return "redirect:/user3/list";
    }

}
