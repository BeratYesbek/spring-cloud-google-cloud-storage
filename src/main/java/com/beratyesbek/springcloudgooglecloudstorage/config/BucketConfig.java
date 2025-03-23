package com.beratyesbek.springcloudgooglecloudstorage.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "gcs")
public class BucketConfig {
    private String bucketName;
    private String subdirectory;
}