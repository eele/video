package edu.zhku.jsj144.lzc.video.util;

import java.security.Key;
import java.util.Date;
import java.util.UUID;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

/**
 * 令牌管理工具
 * @author ele
 *
 */
public class TokenUtil {

	/**
	 * 创建令牌
	 * @param ttlMillis 令牌过期时间，单位毫秒
	 * @return
	 */
	public static String createToken(long ttlMillis) {
		Key key = MacProvider.generateKey();
		
		long nowMillis = System.currentTimeMillis(); // 生成Token的时间
        Date now = new Date(nowMillis);

        JwtBuilder builder = Jwts.builder()
		  .setSubject(UUID.randomUUID().toString())
		  .signWith(SignatureAlgorithm.HS512, key)
		  .setIssuedAt(now);
        
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);     //设置过期时间
        }
		
		return builder.compact();
	}

}
