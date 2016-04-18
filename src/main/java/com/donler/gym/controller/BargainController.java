package com.donler.gym.controller;

import com.donler.gym.expection.AttrValidateException;
import com.donler.gym.expection.AuthValidateException;
import com.donler.gym.expection.UploadFileException;
import com.donler.gym.model.Bargain;
import com.donler.gym.model.User;
import com.donler.gym.model.dto.DeleteStatusModel;
import com.donler.gym.repo.BargainRepo;
import com.donler.gym.service.OSSService;
import com.donler.gym.service.TokenService;
import com.donler.gym.util.NullCheckUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by jason on 4/15/16.
 */
@RestController()
@RequestMapping("/bargain")
@Api(value = "bargain", tags = {"合同"})
public class BargainController {


  @Autowired
  private BargainRepo bargainRepo;
  @Autowired
  private TokenService tokenService;
  @Autowired
  private OSSService ossService;


  @ApiOperation(value = "提交合同",notes = "根据token判断销售员的身份,提交一份合同信息")
  @RequestMapping(value = "", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
  public ResponseEntity<Bargain> saveBargainInfo(@RequestHeader(value = "x-token", required = true) String token, @Valid @RequestBody Bargain input) {
    User user = tokenService.getUserFromCheckingToken(token);
    input.setSalerId(user.getId());
    return ResponseEntity.ok(bargainRepo.save(input));
  }


  @ApiOperation(value = "删除指定合同",notes = "通过token判断销售员,用于删除自己所签售的指定合同")
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json"})
  public ResponseEntity<DeleteStatusModel> deleteBargainInfo(@RequestHeader(value = "x-token", required = true) String token, @PathVariable(value = "id") Long id) {

    Bargain bargain = bargainRepo.findOne(id);
    if (NullCheckUtils.isNullOrEmpty(bargain)) {
      throw new AttrValidateException("请检查需要删除的合同id是否正确");
    }

    User user = tokenService.getUserFromCheckingToken(token);
    if (!user.getId().equals(bargain.getSalerId())) {
      throw new AuthValidateException("您不是当前合同的销售者,没有权利这么做");
    }
    bargainRepo.delete(id);
    return ResponseEntity.ok(new DeleteStatusModel());
  }


  @ApiOperation(notes = "通过token判断身份,用于给该订单的销售员修改自己所签售的指定id的合同信息",value = "更新指定合同")
  @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = {"application/json"}, consumes = {"application/json"})
  public ResponseEntity<Bargain> updateBargainInfo(@RequestHeader(value = "x-token", required = true) String token, @PathVariable Long id, @Valid @RequestBody Bargain input) {

    Bargain bargain = bargainRepo.findOne(id);
    if (NullCheckUtils.isNullOrEmpty(bargain)) {
      throw new AttrValidateException("请检查您要修改的合同的id是否正确");
    }
    User user = tokenService.getUserFromCheckingToken(token);

    if (!user.getId().equals(bargain.getSalerId())) {
      throw new AuthValidateException("您不是当前合同的销售者,没有权利这么做");
    }

    input.setId(bargain.getId());

    Bargain newBargain = bargainRepo.save(input);

    return ResponseEntity.ok(newBargain);
  }


  @ApiOperation(value = "获取某一销售员的所有合同", notes = "获取某一销售员的所签售的所有合同")
  @RequestMapping(value = "/saler/{id}", method = RequestMethod.GET, produces = {"application/json"})
  public ResponseEntity<List<Bargain>> getAllBargainByUserId(@PathVariable Long id) {
    List<Bargain> list = bargainRepo.findBargainBySalerId(id);
    return ResponseEntity.ok(list);
  }

  @ApiOperation(value = "获取指定合同的详情", notes = "通过传入的id返回指定合同的详情")
  @RequestMapping(value = "/{id}/detail", method = RequestMethod.GET, produces = {"application/json"})
  public ResponseEntity<Bargain> getBargainById(@PathVariable Long id) {

    Bargain bargain = bargainRepo.findOne(id);
    if (NullCheckUtils.isNullOrEmpty(bargain)) {
      throw new AttrValidateException("当前合同不存在,请检查您传入的id");
    }
    return ResponseEntity.ok(bargain);
  }

  @RequestMapping(value = "/upload/{id}",method = RequestMethod.POST, produces = {"application/json"}, consumes = {"multipart/form-data"})
  public ResponseEntity<Bargain> uploadPDFBargain(@PathVariable Long id, @RequestPart("file") MultipartFile file) {
    Bargain bargain = ossService.saveFileToOSS(id, file);
    if (NullCheckUtils.isNullOrEmpty(bargain)) {
      throw new UploadFileException("上传错误");
    }
    return ResponseEntity.ok(bargain);
  }


}
