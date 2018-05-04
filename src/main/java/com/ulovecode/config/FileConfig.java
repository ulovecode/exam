package com.ulovecode.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author JackZhu
 * @since 2018/05/04
 */
@ConfigurationProperties(prefix = "file")
@Data
@Configuration
public class FileConfig {
    private String fileUpload;
    private String appDir;
    private String drive;
    private String contextPath;
    private String accessPath;
    private String fullPath;
}
