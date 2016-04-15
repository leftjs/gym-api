package com.donler.gym.controller;

import com.donler.gym.model.Business;
import com.donler.gym.repo.BusinessRepo;
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
public class BusinessController {


  @Autowired
  private BusinessRepo businessRepo;

  @RequestMapping(value = "", method = RequestMethod.POST, produces = {"application/json"}, consumes = {"application/json"})
  public ResponseEntity<Business> addBusiness(@RequestHeader(value = "x-token",required = true) String token, @Valid @RequestBody Business input) {
    Business business = businessRepo.save(input);
    return ResponseEntity.ok(business);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json"}, consumes = {"application/json"})
  public String deleteBusiness(@PathVariable("id") Long id) {
    businessRepo.delete(id);
    return "delete success";
  }

  @RequestMapping(value = "", method = RequestMethod.GET, produces = {"application/json"}, consumes = {"application/json"})
  public ResponseEntity<List<Business>> findAllBusiness() {
    return ResponseEntity.ok(businessRepo.findAll());
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = {"application/json"}, consumes = {"application/json"})
  public ResponseEntity<Business> updateBusiness(@PathVariable("id") Long id,@Valid @RequestBody Business input) {
    return ResponseEntity.ok(businessRepo.save(input));
  }

}
