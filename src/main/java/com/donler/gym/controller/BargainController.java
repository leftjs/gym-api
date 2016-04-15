package com.donler.gym.controller;

import com.donler.gym.model.Bargain;
import com.donler.gym.repo.BargainRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by jason on 4/15/16.
 */
@RestController()
@RequestMapping("/bargain")
public class BargainController {


  @Autowired
  private BargainRepo bargainRepo;

  @RequestMapping(value = "", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
  public ResponseEntity<Bargain> saveBargainInfo(@RequestHeader(value = "x-token",required = true) String token, @Valid @RequestBody Bargain input) {


    return ResponseEntity.ok(bargainRepo.save(input));
  }
}
