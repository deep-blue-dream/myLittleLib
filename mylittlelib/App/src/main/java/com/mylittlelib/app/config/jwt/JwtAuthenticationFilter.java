package com.mylittlelib.app.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mylittlelib.app.config.auth.PrincipalDetails;
import com.mylittlelib.app.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;

    // "/login" 요청을 하면 로그인 시도를 위해 실행되는 함수
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        System.out.println("JwtAuthenticationFilter: 로그인 시도중");

        // 1. username, password 받아서
        try {

            ObjectMapper om = new ObjectMapper(); // JSON데이터를 파싱해줌.
            User user = om.readValue(request.getInputStream(),User.class);
            System.out.println(user.toString());

            // 토큰 생성
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());

            Authentication authentication =
                    authenticationManager.authenticate(authenticationToken);
            PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();

           
            System.out.println("로그인 완료: " + principalDetails.getUser()); // 값이 있다는 건 로그인이 잘 되었다는 것.


            return authentication;
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("======================================");

        return null;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        System.out.println("successfulAuthentication 메서드 실행됨.");
        
        PrincipalDetails principalDetails = (PrincipalDetails) authResult.getPrincipal();

//        Hash암호방식
        String jwtToken = JWT.create()
                .withSubject("userToken")
                .withExpiresAt(new Date(System.currentTimeMillis() + (60000*10))) // 10분 동안 토큰 유지
                .withClaim("id",principalDetails.getUser().getEmail())
                .withClaim("username",principalDetails.getUser().getUsername())
                .sign(Algorithm.HMAC512("sdajkljwqekljszoidjawioejs"));

        response.setHeader("Authorization","Bearer "+jwtToken);

    }
}
