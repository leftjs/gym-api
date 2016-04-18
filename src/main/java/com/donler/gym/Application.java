package com.donler.gym;

import com.donler.gym.model.Business;
import com.donler.gym.model.OSSConfig;
import com.donler.gym.repo.BusinessRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by jason on 4/13/16.
 */
@SpringBootApplication
public class Application {

  private static final Logger log = LoggerFactory.getLogger(Application.class);

  public static void main(String[] args) {
     SpringApplication.run(Application.class, args);
  }


  @Bean
  public CommandLineRunner init(BusinessRepo businessRepo, OSSConfig ossConfig) {

    return (evt) -> {
//      User user = new User("jason", "jason", "jason");
//      userRepo.save(user);
      Business business1 = new Business(1, 488);
      Business business2 = new Business(3, 1288);
      Business business3 = new Business(6, 2100);
      Business business4 = new Business(12, 3800);

      businessRepo.save(business1);
      businessRepo.save(business2);
      businessRepo.save(business3);
      businessRepo.save(business4);


    };
  }

}



