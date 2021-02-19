package com.cts.loan.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.cts.loan.exception.LoanNotFoundException;
import com.cts.loan.model.Loan;
import com.cts.loan.repository.LoanRepository;

@ExtendWith(MockitoExtension.class)
class LoanServiceTest {
	
	
	@InjectMocks
	LoanServiceImpl loanService;

	@Mock
	LoanRepository loanRepository;
	
	@Test
	void validfindLoanTest() {
		
		Loan loan=new Loan();
		loan.setBorrowerName("a");
		loan.setLoanNumber("7");
		loan.setLoanAmount(200);
		
		List<Loan> loanList=new ArrayList();
		loanList.add(loan);
		when(loanRepository.findByBorrowerName(loan.getBorrowerName())).thenReturn(loanList);
		//when(loanRepository.findByLoanAmount(loan.getLoanAmount())).thenReturn(loanList);
		//when(loanRepository.findByLoanNumber(loan.getLoanNumber())).thenReturn(loanList);
		
		assertEquals(1, loanService.findLoan(loan.getBorrowerName(), loan.getLoanNumber(), loan.getLoanAmount()).size());
		
	}
	
	@Test
	void validfindLoanTest2() {
		
		Loan loan=new Loan();
		loan.setBorrowerName(" ");
		loan.setLoanNumber("7");
		loan.setLoanAmount(200);
		
		List<Loan> loanList=new ArrayList();
		loanList.add(loan);
		//when(loanRepository.findByBorrowerName(loan.getBorrowerName())).thenReturn(loanList);
		//when(loanRepository.findByLoanAmount(loan.getLoanAmount())).thenReturn(loanList);
		when(loanRepository.findByLoanNumber(loan.getLoanNumber())).thenReturn(loanList);
		
		assertEquals(1, loanService.findLoan(loan.getBorrowerName(), loan.getLoanNumber(), loan.getLoanAmount()).size());
		
	}
	
	@Test
	void validfindLoanTest3() {
		
		Loan loan=new Loan();
		loan.setBorrowerName(" ");
		loan.setLoanNumber(" ");
		loan.setLoanAmount(200);
		
		List<Loan> loanList=new ArrayList();
		loanList.add(loan);
		//when(loanRepository.findByBorrowerName(loan.getBorrowerName())).thenReturn(loanList);
		when(loanRepository.findByLoanAmount(loan.getLoanAmount())).thenReturn(loanList);
		//when(loanRepository.findByLoanNumber(loan.getLoanNumber())).thenReturn(loanList);
		
		assertEquals(1, loanService.findLoan(loan.getBorrowerName(), loan.getLoanNumber(), loan.getLoanAmount()).size());
		
	}
	
	@Test
	void validfindLoanTest4() {
		
		Loan loan=new Loan();
		loan.setBorrowerName(" ");
		loan.setLoanNumber(" ");
		loan.setLoanAmount(0);
		
		List<Loan> loanList=new ArrayList();
		loanList.add(loan);
		//when(loanRepository.findByBorrowerName(loan.getBorrowerName())).thenReturn(loanList);
		//when(loanRepository.findByLoanAmount(loan.getLoanAmount())).thenReturn(loanList);
		//when(loanRepository.findByLoanNumber(loan.getLoanNumber())).thenReturn(loanList);
		
		try{
			loanService.findLoan(loan.getBorrowerName(), loan.getLoanNumber(), loan.getLoanAmount());}
		catch(Exception ex) {
			assertThat(ex).isInstanceOf(LoanNotFoundException.class);
		}
		}
	
	@Test
	void validfindLoanTest5() {
		
		Loan loan=new Loan();
		loan.setBorrowerName("a");
		loan.setLoanNumber("7");
		loan.setLoanAmount(2000);
		
		List<Loan> loanList=new ArrayList();
		loanList.add(loan);
		when(loanRepository.findByBorrowerName(loan.getBorrowerName())).thenReturn(loanList);
		//when(loanRepository.findByLoanAmount(loan.getLoanAmount())).thenReturn(loanList);
		//when(loanRepository.findByLoanNumber(loan.getLoanNumber())).thenReturn(loanList);
		
		
			assertEquals(1,loanService.findLoan(loan.getBorrowerName(), loan.getLoanNumber(), loan.getLoanAmount()).size());}
		
	
		

@Test
void validfindLoanTest6() {
	
	Loan loan=new Loan();
	loan.setBorrowerName("a");
	loan.setLoanNumber("7");
	loan.setLoanAmount(2000);
	
	List<Loan> loanList=new ArrayList();
	
	when(loanRepository.findByBorrowerName("b")).thenReturn(loanList);
	//when(loanRepository.findByLoanAmount(loan.getLoanAmount())).thenReturn(loanList);
	//when(loanRepository.findByLoanNumber(loan.getLoanNumber())).thenReturn(loanList);
	
	
		try {
			loanService.findLoan("b", loan.getLoanNumber(), loan.getLoanAmount());
		}catch(Exception ex) {
			assertThat(ex).isInstanceOf(LoanNotFoundException.class);
		}
		

	
}
}
	

