package kr.co.sboard.security;

import kr.co.sboard.oauth2.OAuth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@RequiredArgsConstructor
@Configuration
public class SecurityConfig {

    private final OAuth2UserService oauth2UserService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        // 인증 설정(로그인)
        httpSecurity.formLogin(login -> login
                .loginPage("/user/login")
                .defaultSuccessUrl("/")
                .failureUrl("/user/login?success=100")
                .usernameParameter("uid")
                .passwordParameter("pass")
        );


        // 로그아웃 설정
        httpSecurity.logout(logout -> logout
                .invalidateHttpSession(true) // 로그아웃시 현재 세션 무효화
                .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))

                .logoutSuccessUrl("/user/login?success=300"));

        // OAuth 설정
        httpSecurity.oauth2Login(oauth -> oauth
                .loginPage("/user/login")
                .defaultSuccessUrl("/")
                .userInfoEndpoint(userInfo -> userInfo.userService(oauth2UserService)));



        // 인가(권한) 설정
        httpSecurity.authorizeHttpRequests(authorize -> authorize
                                    //permitAll() 할경우 => index페이지로 바로 넘어감
                                    //로그인 한 경우에만 게시판 사용 가능하도록 authenticated()인증 후 허용 설정하기
                .requestMatchers("/").authenticated()
                .requestMatchers("/article/**").authenticated()
                .requestMatchers("/admin/**").hasAnyAuthority("ADMIN")
                .requestMatchers("/manager/**").hasAnyAuthority("ADMIN","MANAGER")
                // 존재하지 않는 페이지에 404 에러 띄우고, 존재하는 페이지는 모든 접근 허용!
                .anyRequest().permitAll());



        // 사이트 위변조 방지 설정
        // Cross - Site Request Forgery(CSRF) 공격 방지위한 CSRF 보호 기능 비활성화
        // CSRF란? 사용자가 의도하지 않은 요청을 악의적인 웹사이트를 통해 전송되도록 하는 공격😈
        httpSecurity.csrf(CsrfConfigurer::disable);

        return httpSecurity.build();
    }

        // Security 인증 암호화 인코더 설정(같은 비밀번호도 다르게 암호화됨!)
        @Bean
        //PasswordEncoder : 비밀번호 해시화하고 검증하는데 사용
        //BCryptPasswordEncoder는 비밀번호를 해시화 하기 위해 BCrypt 해시 함수 사용
        //BCrypt는 안전한 해시 알고리즘 중 하나
        public PasswordEncoder passwordEncoder(){
            return new BCryptPasswordEncoder();

        }


}













