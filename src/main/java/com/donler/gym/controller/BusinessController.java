package com.donler.gym.controller;

import com.donler.gym.expection.AttrValidateException;
import com.donler.gym.model.Business;
import com.donler.gym.model.dto.DeleteStatusModel;
import com.donler.gym.repo.BusinessRepo;
import com.donler.gym.util.NullCheckUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by jason on 4/15/16.
 */
@RestController
@RequestMapping(value = "/business")
@Api(value = "business", tags = {"项目"})
public class BusinessController {


  @Autowired
  private BusinessRepo businessRepo;

  @ApiOperation(value = "添加一个项目选项", notes = "通过传入的选项信息生成一个项目选项")
  @RequestMapping(value = "", method = RequestMethod.POST, produces = {"application/json"}, consumes = {"application/json"})
  public ResponseEntity<Business> addBusiness(@Valid @RequestBody Business input) {
    Business business = businessRepo.save(input);
    return ResponseEntity.ok(business);
  }

  @ApiOperation(value = "删除指定的项目选项", notes = "删除指定的项目选项,并给出反馈")
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json"})
  public ResponseEntity<DeleteStatusModel> deleteBusiness(@PathVariable("id") Long id) {
    Business business = businessRepo.findOne(id);
    if (NullCheckUtils.isNullOrEmpty(business)) {
      throw new AttrValidateException("请传入正确的id");
    }
    businessRepo.delete(id);

    return ResponseEntity.ok(new DeleteStatusModel());
  }

  @ApiOperation(value = "获取所有项目选项", notes = "获得所有的项目选项列表")
  @RequestMapping(value = "", method = RequestMethod.GET, produces = {"application/json"})
  public ResponseEntity<List<Business>> findAllBusiness() {
    return ResponseEntity.ok(businessRepo.findAll());
  }


  @ApiOperation(value = "更新指定项目选项", notes = "传入项目选项的信息更新指定的项目选项(ps.传入的实体中的id忽略,后台不予以识别)")
  @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = {"application/json"}, consumes = {"application/json"})
  public ResponseEntity<Business> updateBusiness(@PathVariable("id") Long id, @Valid @RequestBody Business input) {
    Business business = businessRepo.findOne(id);
    if (NullCheckUtils.isNullOrEmpty(business)) {
      throw new AttrValidateException("请检查传入的id");
    }

    /**
     * 更新操作
     */
    business.setPrice(input.getPrice());
    business.setMonthCount(input.getMonthCount());

    return ResponseEntity.ok(businessRepo.save(business));
  }

}
