package kr.co.ch06.controller;



import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class MainControllerTest {
    
    /*
        MockMvc는 웹 애플리케이션을 서버에 실행하지 않고
        Spring MVC 동작을 재현해서 테스트하는 가상 객체
    
     */

    @Autowired
    private MockMvc mockMvc;


    @Test
    void index() throws Exception {

        mockMvc
                .perform(get("/index"))             // index 요청 테스트
                .andExpect(status().isOk())         // 요청 결과 상태 테스트
                .andExpect(view().name("/index"))   // 요청 뷰 테스트
                .andDo(print());                    // 요청 결과 상태 출력
    }



    void content1() {
    }

   
    void content2() {
    }
}












