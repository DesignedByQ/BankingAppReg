package com.techprj.registration.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techprj.registration.entity.RegDetails;

@Repository
public interface RegDetailsRepo extends JpaRepository<RegDetails, Long>{

	void deleteByEmail(String email);

	Optional<RegDetails> findByEmail(String email);

}
