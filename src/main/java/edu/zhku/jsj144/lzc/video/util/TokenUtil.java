package edu.zhku.jsj144.lzc.video.util;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

import java.security.Key;
import java.util.Date;
import java.util.UUID;

/**
 * 令牌管理工具
 *
 * @author ele
 */
public class TokenUtil {

    private static Key key = generateKey();

    /**
     * 创建令牌
     * @param id
     * @param ttlMillis  令牌过期时间，单位毫秒
     * @return
     */
    public static String createToken(String id, long ttlMillis) {
        long nowMillis = System.currentTimeMillis(); // 生成Token的时间
        Date now = new Date(nowMillis);

        JwtBuilder builder = Jwts.builder()
                .setId(UUID.randomUUID().toString())
                .setSubject(id)
                .signWith(SignatureAlgorithm.HS512, key)
                .setIssuedAt(now);

        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);     //设置过期时间
        }

        return builder.compact();
    }

    /**
     * 检查Token是否合法
     *
     * @param token
     * @return subject值，即用户ID
     */
    public static String checkToken(String token) {
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getSubject();
    }

    /**
     * 生成签名密钥
     *
     * @return
     */
    private static Key generateKey() {
        return MacProvider.generateKey();
    }

}
