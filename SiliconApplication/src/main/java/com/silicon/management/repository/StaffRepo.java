package com.silicon.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.silicon.management.model.Staff;

@Repository
public interface StaffRepo extends JpaRepository<Staff, Long>{

}
