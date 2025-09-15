package com.nisal.repository;

import com.nisal.model.Branch;
import com.nisal.model.Store;
import com.nisal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    List<User> findByStore(Store store);
    List<User> findByBranchId(Long branchId);

}
