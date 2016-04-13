package com.donler.gym.repo;

import com.donler.gym.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jason on 4/13/16.
 */
@Repository
public interface AccountRepo extends JpaRepository<Account,Long> {
}
