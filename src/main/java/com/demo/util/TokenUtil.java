package com.demo.util;

import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class TokenUtil {
	
	private static final long EXPIRE_TIME = 24 * 60 * 60 * 1000;
    
    private static final String TOKEN_SECRET = "online";

    /**
     * 签名生成
     * @param username
     * @return
     */
    public static String sign(int idtype,String username){
        String token = null;
        try {
            Date expiresAt = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            token = JWT.create()
                    .withIssuer("auth0")
                    .withClaim("idtype", idtype)
                    .withClaim("username",username)
                    .withExpiresAt(expiresAt)
                    //使用HMAC256算法加密
                    .sign(Algorithm.HMAC256(TOKEN_SECRET));
        } catch (Exception e){
            e.printStackTrace();
        }
        return token;
    }

    public static boolean verify(String token){
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256((TOKEN_SECRET)))
                    .withIssuer("auth0").build();
            DecodedJWT jwt = verifier.verify(token);
            System.out.println("认证通过");
            System.out.println("username" +jwt.getClaim("username").asString());
            return true;
        } catch (Exception e){
            return false;
        }
    }

}
