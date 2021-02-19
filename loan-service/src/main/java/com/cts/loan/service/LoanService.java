package com.cts.loan.service;

import java.util.List;

import com.cts.loan.model.Loan;

public interface LoanService {

	List<Loan> findLoan(String borrowerName,String loanNumber,double loanAmount);

}
