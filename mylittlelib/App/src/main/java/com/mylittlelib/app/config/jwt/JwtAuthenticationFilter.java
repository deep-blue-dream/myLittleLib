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

            // 정상인지 로그인 시도를 해봄. authenticationManager로 로그인 시도를 하면 PrincipalDetailsService가 호출 됨.
            // authenticationManager가 토큰을 넘기면 username이 매칭되는지 확인하고, password는 스프링에서 알아서 처리해줌.
            // 인증 성공하면(username,password일치) 그 결괏값으로 authentication에 내 로그인 정보가 담김.
            Authentication authentication =
                    authenticationManager.authenticate(authenticationToken);

            // 3. PrincipalDetails를 세션에 담고 (이걸 안담으면, security에서 권한 관리가 안됨. 관리 안하려면 담을 필요없음.)
            PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();

            // 인증이 정상적으로 작동되어서
            System.out.println("로그인 완료: " + principalDetails.getUser()); // 값이 있다는 건 로그인이 잘 되었다는 것.


            // authentication 객체가 session영역에 저장을 해야하고, 그 방법이 return 해주면 됨.
            // return의 이유는 권한 관리를 security가 대신 해주기 때문에 편하려고.
            // JWT토큰을 사용하면서 세션을 만들 이유가 없으나, 권한 처리 때문에 SESSION에 넣어줌.

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
        // 4. JWT 토큰 생성은 authentication을 반환하면 그 다음으로 successfulAuthentication메서드 실행.
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
