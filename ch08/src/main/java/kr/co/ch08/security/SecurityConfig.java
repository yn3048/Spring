package kr.co.ch08.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        // 인증 설정(로그인)
        httpSecurity.formLogin(login -> login
                .loginPage("/user4/login")
                .defaultSuccessUrl("/user4/success")
                .failureUrl("/user4/login/?success=100")
                .usernameParameter("uid")
                .passwordParameter("pass")
        );


        // 로그아웃 설정
        httpSecurity.logout(logout -> logout
                .invalidateHttpSession(true) // 로그아웃시 현재 세션 무효화
                // 로그아웃 처리할 url 패턴지정, url패턴을 사용하여 요청 매치
                .logoutRequestMatcher(new AntPathRequestMatcher("/user1/logout"))
                .logoutRequestMatcher(new AntPathRequestMatcher("/user4/logout"))
                // 로그아웃 성공후 사용자를 리다이렉션할 url 설정
                .logoutSuccessUrl("/user1/login?success=200")
                .logoutSuccessUrl("/user4/login?success=200"));

        // 인가(권한) 설정
        httpSecurity.authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/").permitAll()// 루트 경로에 대한 모든 요청 허용
                // "/admin/"으로 시작하는 모든 요청에 대해 admin 권한이 있는 사용자만 접근 허용
                .requestMatchers("/admin/**").hasAnyAuthority("ADMIN")
                // "/manager/"로 시작하는 모든 요청에 대해 admin 또는 manager 권한이 있는 사용자만 접근 허용
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













