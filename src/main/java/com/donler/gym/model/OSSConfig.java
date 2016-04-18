package com.donler.gym.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by jason on 4/18/16.
 */
@Component
@ConfigurationProperties(prefix = "oss")
public class OSSConfig {
  private String endpoint;
  private String accessKeyId;
  private String accessKeySecret;
  private String bucketName;
  private String key;

  public String getEndpoint() {
    return endpoint;
  }

  @Override
  public String toString() {
    return "OSSConfig{" +
        "endpoint='" + endpoint + '\'' +
        ", accessKeyId='" + accessKeyId + '\'' +
        ", accessKeySecret='" + accessKeySecret + '\'' +
        ", bucketName='" + bucketName + '\'' +
        ", key='" + key + '\'' +
        '}';
  }

  public void setEndpoint(String endpoint) {
    this.endpoint = endpoint;
  }

  public String getAccessKeyId() {
    return accessKeyId;
  }

  public void setAccessKeyId(String accessKeyId) {
    this.accessKeyId = accessKeyId;
  }

  public String getAccessKeySecret() {
    return accessKeySecret;
  }

  public void setAccessKeySecret(String accessKeySecret) {
    this.accessKeySecret = accessKeySecret;
  }

  public String getBucketName() {
    return bucketName;
  }

  public void setBucketName(String bucketName) {
    this.bucketName = bucketName;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }
}
