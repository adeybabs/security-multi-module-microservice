package com.project.workflow.repository;

import com.project.workflow.entities.Loans;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends CrudRepository<Loans, Long> {
	
	List<Loans> findByEmailOrderByStartDtDesc(String email);

}
