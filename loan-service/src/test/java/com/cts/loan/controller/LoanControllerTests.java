package com.cts.loan.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import com.cts.loan.exception.LoanNotFoundException;
import com.cts.loan.model.Loan;
import com.cts.loan.service.LoanServiceImpl;

@ExtendWith(MockitoExtension.class)
class LoanControllerTests {

	@InjectMocks
	LoanController loanController;

	@Mock
	LoanServiceImpl loanService;

	@Test
	void validLoanControllerTest() {
		Loan loan = new Loan();
		loan.setBorrowerName(" ");
		loan.setLoanAmount(0);
		loan.setLoanNumber(" ");

		when(loanService.findLoan(" ", " ", 0)).thenThrow(LoanNotFoundException.class);

		assertEquals(HttpStatus.NOT_FOUND, loanController.getLoans(loan).getStatusCode());
	}
	
	@Test
	void validLoanControllerOKTest() {
		Loan loan = new Loan();
		loan.setBorrowerName("a");
		loan.setLoanAmount(0);
		loan.setLoanNumber("7");

		when(loanService.findLoan("a", "7", 0)).thenReturn(new ArrayList());

		assertEquals(HttpStatus.OK, loanController.getLoans(loan).getStatusCode());
	} 

}
