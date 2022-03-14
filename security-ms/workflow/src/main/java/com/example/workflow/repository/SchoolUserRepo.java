package com.example.workflow.repository;

import com.example.reportms.models.SchoolUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolUserRepo extends JpaRepository<SchoolUser, Long> {


    SchoolUser findByUsername(String username);
}
