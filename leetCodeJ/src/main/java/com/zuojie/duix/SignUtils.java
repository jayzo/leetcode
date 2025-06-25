package com.zuojie.duix;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import java.util.Calendar;
import java.util.Date;

public class SignUtils {
    /**
     * Create Signature
     *
     * @param appId  Session Identifier
     * @param appKey Session Key
     * @param sigExp Signature validity time: in seconds
     * @return
     */
    public static String createSig(String appId, String appKey, int sigExp) {
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.SECOND, sigExp);
        Date expiresDate = nowTime.getTime();
        return JWT.create()
                //Release date
                .withIssuedAt(new Date())
                //effective time
                .withExpiresAt(expiresDate)
                //load
                .withClaim("appId", appId)
                //encryption
                .sign(Algorithm.HMAC256(appKey));
    }

    public static void main(String[] args) {
        String appId = "1376950347750313984";
        String appKey = "f5adebba-9ece-4711-bf19-217c505dc8e8";
        System.out.println(SignUtils.createSig(appId,appKey,360000));
    }
}