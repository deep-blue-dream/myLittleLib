package com.mylittlelib.app.config.auth;

import com.mylittlelib.app.model.User;
import com.mylittlelib.app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// http://localhost:8080/login 요청 들어오면 해당 서비스 동작. -> loadUserByUsername()메서드 자동실행.

@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("loadUserByUsername 실행됨.");
        User user = userService.findByUsername(username);

        return new PrincipalDetails(user);
    }
}
