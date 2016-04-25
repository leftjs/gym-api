package com.donler.gym.controller;

import com.donler.gym.model.Company;
import com.donler.gym.repo.CompanyRepo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by jason on 4/15/16.
 */
@RestController
@RequestMapping(value = "/company")
@Api(value = "company", tags = {"公司"})
public class CompanyController {


  @Autowired
  private CompanyRepo companyRepo;


  @ApiOperation(notes = "更新公司信息,若公司信息不存在则新建一条公司信息", value = "更新或新建公司信息")
  @RequestMapping(value = "", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
  public ResponseEntity<Company> updateCompanyInfo(@Valid @RequestBody Company company) {

    Company result = null;
    if (companyRepo.findAll().size() == 0) {
      result = companyRepo.save(company);
    } else {
      result = companyRepo.findAll().get(0);
      company.setId(result.getId());
      companyRepo.save(company);
      result = company;
    }
    return ResponseEntity.ok(result);
  }


  @ApiOperation(notes = "获取公司的信息", value = "获取公司信息")
  @RequestMapping(value = "", method = RequestMethod.GET, produces = {"application/json"})
  public ResponseEntity<Company> getCompanyInfo() {


    List<Company> list = companyRepo.findAll();
    if (list.size() == 0) {
      return ResponseEntity.ok(new Company());
    }
    return ResponseEntity.ok(companyRepo.findAll().get(0));
  }
}
