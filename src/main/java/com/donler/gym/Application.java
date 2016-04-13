package com.donler.gym;

import com.donler.gym.model.Account;
import com.donler.gym.model.User;
import com.donler.gym.repo.AccountRepo;
import com.donler.gym.repo.UserRepo;
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
  public CommandLineRunner init(AccountRepo accountRepo, UserRepo userRepo) {
    return (args) -> {
      Account account = new Account("admin", "admin");
      User user = new User("jason", "asdf", Integer.toUnsignedLong(123123));
      userRepo.save(user);
      account.setUser(user);

      accountRepo.save(account);

      log.info("-----------");



    };
  }

}
