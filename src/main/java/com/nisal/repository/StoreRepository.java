package com.nisal.repository;

import com.nisal.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {

    Store findByStoreAdminId(long adminId);
}
