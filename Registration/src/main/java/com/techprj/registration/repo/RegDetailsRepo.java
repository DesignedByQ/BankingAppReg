package com.techprj.registration.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techprj.registration.entity.RegDetails;

@Repository
public interface RegDetailsRepo extends JpaRepository<RegDetails, Long>{

}
