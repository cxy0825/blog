package com.cxy.blog.utils;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTUtils {
    //指定签名的时候使用的签名算法，也就是header那部分，jjwt已经将这部分内容封装好了。
    public static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public static String createJWT(Map<String, Object> claims) {

        return Jwts.builder().
                signWith(key).//加密密钥
                        setClaims(claims).//加密的数据
                        setIssuedAt(new Date()).//签发时间
                        setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000 * 24)).//过期时间
                        compact();//完成封装 返回字符串

    }

    public static Map<String, Object> checkJWT(String token) {
        try {
            Jwt parse = Jwts.parser().setSigningKey(key).parse(token);

            return (Map<String, Object>) parse.getBody();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;

    }

    public static void main(String[] args) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("用户ID", 156165456);
        claims.put("ID2", "15aaa456");
        String token = JWTUtils.createJWT(claims);
        System.out.println(token);

        System.out.println(JWTUtils.checkJWT(token));


    }
}
