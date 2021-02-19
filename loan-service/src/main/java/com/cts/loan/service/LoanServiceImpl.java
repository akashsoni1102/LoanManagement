package com.cts.loan.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.loan.exception.LoanNotFoundException;
import com.cts.loan.model.Loan;
import com.cts.loan.repository.LoanRepository;

@Service
public class LoanServiceImpl implements LoanService {

	@Autowired
	LoanRepository loanRepository;

	
	// Filter on the basis of LoanNumber
	void findByLoanNumber(List<Loan> list, String loanNumber) {
		list.retainAll(
	list.stream().filter(item -> item.getLoanNumber().equals(loanNumber)).collect(Collectors.toList()));
	}

	// Filter on the basis of LoanAmount
	void findByLoanAmount(List<Loan> list, double loanAmount) {
		list.retainAll(list.stream().filter(item -> item.getLoanAmount() == loanAmount).collect(Collectors.toList()));
	}

	// Search Loan
	public List<Loan> findLoan(String borrowerName, String loanNumber, double loanAmount) {

		List<Loan> list = null;

		int flag = 0;

		if (!borrowerName.equals(" ")) {
			list = loanRepository.findByBorrowerName(borrowerName);
		} 
		else if (!loanNumber.equals(" ")) {
			list = loanRepository.findByLoanNumber(loanNumber);
			flag += 1;
		}
		else if (loanAmount!= 0) {
			list = loanRepository.findByLoanAmount(loanAmount);
			flag += 2;
		}
		

		if (list != null && !list.isEmpty()) {
			
			if (flag != 2 && loanAmount != 0)
				findByLoanAmount(list, loanAmount);
			
			if (flag != 1 && !loanNumber.equals(" "))
				findByLoanNumber(list, loanNumber);
		} else throw new LoanNotFoundException();
		
		
		return list;

	}

}
