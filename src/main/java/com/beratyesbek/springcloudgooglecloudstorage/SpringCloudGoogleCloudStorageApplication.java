package com.beratyesbek.springcloudgooglecloudstorage;

import com.beratyesbek.springcloudgooglecloudstorage.config.BucketConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(BucketConfig.class)
public class SpringCloudGoogleCloudStorageApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudGoogleCloudStorageApplication.class, args);
    }

}
