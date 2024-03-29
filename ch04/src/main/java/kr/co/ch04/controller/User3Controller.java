package kr.co.ch04.controller;

import kr.co.ch04.dto.User3DTO;
import kr.co.ch04.service.User3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class User3Controller {

    @Autowired
    private User3Service service;

    @GetMapping("/user3/register")
    public String register(){
        return "/user3/register";
    }

    @PostMapping("/user3/register")
    public String register(User3DTO user3DTO) {
        System.out.println(user3DTO);

        // 등록
        service.insertUser3(user3DTO);

        // 리다이렉트
        return "redirect:/user3/list";
    }

    @GetMapping("/user3/list")
    public String list(Model model) {

        List<User3DTO> users = service.selectUser3s();

        // Model 참조(Controller 데이터를 view에서 참조)
        model.addAttribute("users", users);

        return "/user3/list";

    }

    @GetMapping("/user3/delete")
    public String delete(@RequestParam("uid") String uid) {
        System.out.println("uid : " + uid);

        service.deleteUser3(uid);

        return "redirect:/user3/list";
    }

    @GetMapping("/user3/modify")
    public String modify(@RequestParam("uid") String uid, Model model) {
        System.out.println("uid : " + uid);
        User3DTO user3DTO = service.selectUser3(uid);

        model.addAttribute(user3DTO);

        return "/user3/modify";
    }

    @PostMapping("/user3/modify")
    public String modify(@ModelAttribute User3DTO user3DTO) {
        System.out.println(user3DTO);

        service.updateUser3(user3DTO);

        return "redirect:/user3/list";
    }


}









