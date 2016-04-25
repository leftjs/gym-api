package com.donler.gym.service;

import com.donler.gym.bean.MyOSSClient;
import com.donler.gym.expection.AttrValidateException;
import com.donler.gym.expection.UploadFileException;
import com.donler.gym.model.Bargain;
import com.donler.gym.model.Config;
import com.donler.gym.repo.BargainRepo;
import com.donler.gym.util.NullCheckUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

/**
 * Created by jason on 4/18/16.
 */
@Service
public class OSSService {



  @Autowired
  private BargainRepo bargainRepo;
  @Autowired
  private MyOSSClient ossClient;
  @Autowired
  private Config config;


  /**
   * 保存文件到OSS
   * @param bargainId
   * @param file
   * @return
   */
  public Bargain saveFileToOSS(Long bargainId, MultipartFile file) {

    Bargain bargain = bargainRepo.findOne(bargainId);
    if (NullCheckUtils.isNullOrEmpty(bargain)) {
      throw new AttrValidateException("请检查该合同是否存在");
    }

    String key = UUID.randomUUID().toString() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."), file.getOriginalFilename().length());

    try {

      ossClient.getOssClient().putObject(config.getBucketName(), key, file.getInputStream());

    } catch (Exception e) {
      throw new UploadFileException(file.getOriginalFilename() + " 文件上传错误");
//      e.printStackTrace();
    }

    String[] baseStr = config.getEndpoint().split("//");
    String filePath = baseStr[0] + "//" + config.getBucketName() + "." + baseStr[1] + "/" + key;

    bargain.setPdfPath(filePath);
    return bargainRepo.save(bargain);
  }

}
