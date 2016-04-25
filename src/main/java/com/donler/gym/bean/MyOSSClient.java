package com.donler.gym.bean;

import com.aliyun.oss.OSSClient;
import com.donler.gym.model.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by jason on 4/25/16.
 */
@Component
public class MyOSSClient {

  @Autowired
  private Config config;

  public OSSClient getOssClient() {
    if (ossClient == null) {
      ossClient = new OSSClient(config.getEndpoint(), config.getAccessKeyId(), config.getAccessKeySecret());
    }
    return ossClient;
  }

  public void setOssClient(OSSClient ossClient) {
    this.ossClient = ossClient;
  }



  private OSSClient ossClient ;


}
