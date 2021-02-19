package com.cts.loan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.loan.exception.LoanNotFoundException;
import com.cts.loan.model.Loan;
import com.cts.loan.service.LoanServiceImpl;

@RestController
public class LoanController {

	@Autowired
	LoanServiceImpl loanService;

	@PostMapping("/getLoan")
	ResponseEntity<List<Loan>> getLoans(@RequestBody Loan loan) {
		List<Loan> list;
		try {
			list = loanService.findLoan(loan.getBorrowerName(), loan.getLoanNumber(), loan.getLoanAmount());
			return new ResponseEntity<List<Loan>>(list, HttpStatus.OK);
		} catch (LoanNotFoundException ex) {
			return new ResponseEntity<List<Loan>>(HttpStatus.NOT_FOUND);
		}

	}

}
