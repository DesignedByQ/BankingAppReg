package com.techprj.registration.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techprj.registration.entity.File;

@Repository
public interface FileRepo extends JpaRepository<File, String>{

}
