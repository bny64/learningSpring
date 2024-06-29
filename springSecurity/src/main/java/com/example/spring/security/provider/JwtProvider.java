package com.example.spring.security.provider;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.stream.Collectors;

@Slf4j
@Component
public class JwtProvider {

    private final String secret = "fjldfjadfjaslkdfjksdlfjsadfklasdjfklsdjfklasjdfklasjfdkfjaklsdfjafjldfjadfjaslkdfjksdlfjsadfklasdjfklsdjfklasjdfklasjfdkfjaklsdfjafjldfjadfjaslkdfjksdlfjsadfklasdjfklsdjfklasjdfklasjfdkfjaklsdfja;";
    private final Key key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
    private static final String AUTHORITIES_KEY = "auth";
    private final long accessTokenExpTime = 1000 * 30;

    public String createAccessToken(Authentication authentication) {

        String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        long now = (new Date()).getTime();
        Date validity = new Date(now + this.accessTokenExpTime);

        return Jwts.builder()
                .setSubject(authentication.getName())
                .claim(AUTHORITIES_KEY, authorities) // 정보 저장
                .signWith(key, SignatureAlgorithm.HS512) // 사용할 암호화 알고리즘과 , signature 에 들어갈 secret값 세팅
                .setExpiration(validity) // set Expire Time 해당 옵션 안넣으면 expire안함
                .compact();
    }


}
