package com.donler.gym.repo;

import com.donler.gym.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jason on 4/14/16.
 */
@Repository
public interface TokenRepo extends JpaRepository<Token, Long> {

  Token findTokenByUserId(Long id);

  Token findTokenByToken(String token);
}
