package com.kuang.tools.jwtUtils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class JwtUtil {
    private static final long EXPIRE_TIME = 7 * 24 * 60 * 60 * 1000;
    //私钥
    private static final String TOKEN_SECRET = "privateKey";
    /**
     * 生成签名，15分钟过期
     * @param **username**
     * @param **password**
     * @return
     */

    public static String sign(String userId) {
        try {
            // 设置过期时间
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            // 私钥和加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            // 设置头部信息
            Map<String, Object> header = new HashMap<>(2);
            header.put("Type", "Jwt");
            header.put("alg", "HS256");
            // 返回token字符串
            return JWT.create()
                    .withHeader(header)
                    .withClaim("userId", userId)
                    .withClaim("dateMsg",date)
                    .sign(algorithm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 检验token是否正确
     * @param **token**
     * @return
     */
    public static String verify(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            String userId = jwt.getClaim("userId").asString();
            return userId;
        } catch (Exception e){
            return null;
        }
    }

    public static boolean JudgeDate(String token) {
        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT jwt = verifier.verify(token);
        Claim claim = jwt.getHeaderClaim(token);
        System.out.println(claim);
        return false;
    }

    public  static String createJWT(String username) {

        //id，issuer，subject，ttlMillis都是放在payload中的，可根据自己的需要修改
        //签名的算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        //当前的时间
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        //签名算法的秘钥，解析token时的秘钥需要和此时的一样
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("miyao");
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        //构造
        JwtBuilder builder = Jwts.builder().setId(username)
                .setIssuedAt(now)
                .signWith(signatureAlgorithm, signingKey)
                .setExpiration(new Date( nowMillis + EXPIRE_TIME));
        //压缩
        return builder.compact();
    }

    public  static  Object parseJWT(String jwt) {
        try {
            Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary("miyao")).parseClaimsJws(jwt).getBody();
            /*logger.info("------解析token----");
            logger.info("ID: " + claims.getId());
            logger.info("Subject: " + claims.getSubject());
            logger.info("Issuer: " + claims.getIssuer());
            logger.info("IssuerAt:   " + claims.getIssuedAt());
            logger.info("Expiration: " + claims.getExpiration());*/
            /*
            检验token是或否即将过期，如快要过期，就提前更新token。如果已经过期的，会抛出ExpiredJwtException 的异常
            */
            Long exp=claims.getExpiration().getTime(); //过期的时间
            long nowMillis = System.currentTimeMillis();//现在的时间
            Date now=new Date(nowMillis);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String format = simpleDateFormat.format(now);
            /*
            显示token是否过期
            System.out.println("现在时间"+format);
            System.out.println("过期时间"+simpleDateFormat.format(exp));
            */
            if ((exp - nowMillis < 0)){
                System.out.println("过期");
                return "false";
            }
            else {
                return "success";
            }

        }catch (ExpiredJwtException e){
            e.printStackTrace();
            return ExpiredJwtException.class.getName();
        }catch (SignatureException e1){
            e1.printStackTrace();
            return  SignatureException.class.getName();
        }catch (MalformedJwtException e2){
            e2.printStackTrace();
            return MalformedJwtException.class.getName();
        }
    }
    public  static  String parseVer(String jwt) {
        Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary("miyao")).parseClaimsJws(jwt).getBody();
        String id = claims.getId();
        return id;
    }
}
