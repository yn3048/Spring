package kr.co.ch10.security;

import kr.co.ch10.jwt.JwtAuthenticationFilter;
import kr.co.ch10.jwt.JwtProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Slf4j
@Configuration
public class SecurityConfig {

    @Autowired
    private JwtProvider jwtProvider;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        log.info("Bean생성 확인...");
        // 토큰기반 인증 시큐리티 설정
        httpSecurity
                .csrf(CsrfConfigurer::disable)              // 사이트 위변조 방지
                .httpBasic(HttpBasicConfigurer::disable)    // 기본 HTTP 인증 방식 비활성
                .formLogin(FormLoginConfigurer::disable)    // 폼로그인 비활성
                .sessionManagement(config -> config.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // 세션 비활성
                // 토큰 검사 필터 등록
                .addFilterBefore(new JwtAuthenticationFilter(jwtProvider), UsernamePasswordAuthenticationFilter.class)
                // 인가(권한) 설정
                .authorizeHttpRequests(authorize -> authorize
                                    .requestMatchers("/").permitAll()// 루트 경로에 대한 모든 요청 허용
                                    // "/admin/"으로 시작하는 모든 요청에 대해 admin 권한이 있는 사용자만 접근 허용
                                    .requestMatchers("/admin/**").hasAnyAuthority("ADMIN")
                                    // "/manager/"로 시작하는 모든 요청에 대해 admin 또는 manager 권한이 있는 사용자만 접근 허용
                                    .requestMatchers("/manager/**").hasAnyAuthority("ADMIN","MANAGER")
                                    // 존재하지 않는 페이지에 404 에러 띄우고, 존재하는 페이지는 모든 접근 허용!
                                    .anyRequest().permitAll());

        return httpSecurity.build();
    }

        // Security 인증 암호화 인코더 설정(같은 비밀번호도 다르게 암호화됨!)
        @Bean
        public PasswordEncoder passwordEncoder(){
            return new BCryptPasswordEncoder();

        }

        @Bean
        public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
            return config.getAuthenticationManager();
        }


}













