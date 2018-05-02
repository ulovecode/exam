package com.ulovecode.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@ConfigurationProperties(prefix = "photo")
@Data
@Configuration
public class PhotoConfig {


    private String studentUpload;
    private String appDir;
    private String drive;
    private String contextPath;
    private String accessPath;
    private String fullPath;

}
