package com.vcg.chat.server.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * created by wuyu on 2018/2/27
 */
public class JwtUtil {

    private static final String SECRET = "sFo^x@b%jQS47O2c";

    //加密，传入一个对象和有效期
    public static String sign(String id, long maxAge) {
        return Jwts.builder()
                .setSubject(id)
                .setExpiration(new Date(System.currentTimeMillis()+maxAge))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }

    //解密，传入一个加密后的token字符串和解密后的类型
    public static <T> Claims unsign(String jwt) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(jwt)
                .getBody();
    }

    public static void main(String[] args) {
        String sign = sign("1", Integer.MAX_VALUE);
        System.err.println(sign);
        Claims unsign = unsign(sign);
        System.err.println(unsign);
    }

}
