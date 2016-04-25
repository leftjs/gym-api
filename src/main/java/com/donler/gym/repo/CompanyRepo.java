package com.donler.gym.repo;

import com.donler.gym.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jason on 4/15/16.
 */
@Repository
public interface CompanyRepo extends JpaRepository<Company, Long> {


}
