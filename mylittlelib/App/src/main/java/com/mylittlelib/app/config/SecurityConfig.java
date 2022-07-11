package com.mylittlelib.app.config;

import com.mylittlelib.app.config.jwt.JwtAuthenticationFilter;
import com.mylittlelib.app.config.jwt.JwtAuthorizationFilter;
import com.mylittlelib.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private CorsConfig corsConfig;
    //    private final CorsFilter corsFilter; // corsFilter 메서드가 bean에 등록되어있으므로 바로 가져올 수 있음.
    private final UserRepository userRepository;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // filter-chain을 securityConfig에 직접 추가할 수 있지만, FilterConfig에서 @Bean으로 등록해두고
        // 우선순위를 설정해두면 굳이 여기다가 직접 쓸 필요가 없다.
        // 근데, 만약 spring security가 동작하기 전에 필터가 적용되어야 한다면 여기다 써야한다.
//        http.addFilterBefore(new MyFilter3(),BasicAuthenticationFilter.class);
        // 필터의 실행순서는 securityConfig에서 가장 먼저 실행되고, 나머지가 FilterConfig에서 순서대로 실행된다.


        http.csrf().disable();

        // jwt 서버 세팅
        http.addFilter(corsConfig.corsFilter())
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 세션을 사용하지 않겠다는 뜻.
                // 서버가 stateless 서버임.
//                .and()
//                .cors()
                .and()
//                .addFilter(corsFilter) // @CrossOrigin(인증x) , 시큐리티 필터에 등록 인증(o)
//              // cors필터를 모두 거쳐서 감. corsConfig에서 모든 요청에 허용해놨으므로, Cors정책으로부터 벗어남.
                .formLogin().disable()
                // 인증이 필요 없어지므로 로그인 과정이 사라짐.
                .httpBasic().disable()
                .addFilter(new JwtAuthenticationFilter(authenticationManager())) // JwtFilter를 직접 등록해줌.
                .addFilter(new JwtAuthorizationFilter(authenticationManager(), userRepository)) // JwtFilter를 직접 등록해줌.
                .authorizeRequests()
                .antMatchers("/test2/**")
                .access("hasRole('ROLE_USER') or hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")

                // 로그인을 따로 안하기 때문에 인증과정은 없지만, 해당 클라이언트가 위의 주소로 접속하면 인증이 안된경우 403 forbidden error 반환.
                .anyRequest().permitAll();
    }
}

