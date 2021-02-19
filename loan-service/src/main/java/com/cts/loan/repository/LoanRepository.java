package com.cts.loan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.loan.model.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {

	@Query("SELECT L FROM Loan L WHERE L.borrowerName LIKE %?1%")
	List<Loan> findByBorrowerName(String borrowerName);

	//@Query(value = "SELECT * FROM LOAN WHERE loan_number LIKE %?1%",nativeQuery = true)
	List<Loan> findByLoanNumber(String loanNumber);

	List<Loan> findByLoanAmount(double loanAmount);


}
