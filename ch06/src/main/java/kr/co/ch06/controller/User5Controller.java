package kr.co.ch06.controller;

import kr.co.ch06.dto.User5DTO;
import kr.co.ch06.service.User5Service;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Controller
public class User5Controller {

    private final User5Service service;

    @GetMapping("/user5/list")
    public String list(Model model) {
        List<User5DTO> users = service.selectUser5s();
        log.info(users.toString());

        model.addAttribute("users", users);
        return "/user5/list";
    }

}
