package com.example.spring.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;

    private final String userEmail = "bny64@naver.com";
    private final String password = "9164";

    @Override
    public UserDetails loadUserByUsername(final String username) {

        Map<String, String> user;

        if (!userEmail.equals(username)) {
            throw new UsernameNotFoundException("USER NAME NOT FOUND");
        } else {

            //Core에서 인증 후 전달되는 값
            user = Map.of("email", userEmail, "password", passwordEncoder.encode(password));
        }

        return createUser(user);
    }

    private User createUser(Map<String, String> userInfo) {

        String email = userInfo.get("email");
        String password = userInfo.get("password");
        List<GrantedAuthority> grantedAuthorities = Collections.emptyList();

        return new User(email,
                password,
                grantedAuthorities);
    }
}
