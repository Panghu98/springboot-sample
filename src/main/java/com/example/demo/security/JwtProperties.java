package com.example.demo.security;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author dgh
 * @date 19-1-18 下午2:35
 */
@Data
@Component
public class JwtProperties {

    /**
     * token签名
     **/
    private String secret;

    /**
     * token过期时间
     */
    private String expiration;

    private String tokenStart;

    private String tokenName;

    private String notInterceptionPath;

    private String uploadedFolder;

    private String notInterceptionPathTomcat;
}
