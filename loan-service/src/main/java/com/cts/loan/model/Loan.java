package com.cts.loan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Loan {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int loanId;

	private String borrowerName;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String legalDescription;
	private String lienId;
	private String lienType;
	private double loanAmount;
	private String loanNumber;
	private float loanTerm;
	private String state;
	private int zip;

	public Loan() {
		super();
	}

	public Loan(int loanId, String borrowerName, String addressLine1, String addressLine2, String city,
			String legalDescription, String lienId, String lienType, double loanAmount, String loanNumber,
			float loanTerm, String state, int zip) {
		super();
		this.loanId = loanId;
		this.borrowerName = borrowerName;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.legalDescription = legalDescription;
		this.lienId = lienId;
		this.lienType = lienType;
		this.loanAmount = loanAmount;
		this.loanNumber = loanNumber;
		this.loanTerm = loanTerm;
		this.state = state;
		this.zip = zip;
	}

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public String getBorrowerName() {
		return borrowerName;
	}

	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLegalDescription() {
		return legalDescription;
	}

	public void setLegalDescription(String legalDescription) {
		this.legalDescription = legalDescription;
	}

	public String getLienId() {
		return lienId;
	}

	public void setLienId(String lienId) {
		this.lienId = lienId;
	}

	public String getLienType() {
		return lienType;
	}

	public void setLienType(String lienType) {
		this.lienType = lienType;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getLoanNumber() {
		return loanNumber;
	}

	public void setLoanNumber(String loanNumber) {
		this.loanNumber = loanNumber;
	}

	public float getLoanTerm() {
		return loanTerm;
	}

	public void setLoanTerm(float loanTerm) {
		this.loanTerm = loanTerm;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "Loan [loanId=" + loanId + ", borrowerName=" + borrowerName + ", addressLine1=" + addressLine1
				+ ", addressLine2=" + addressLine2 + ", city=" + city + ", legalDescription=" + legalDescription
				+ ", lienId=" + lienId + ", lienType=" + lienType + ", loanAmount=" + loanAmount + ", loanNumber="
				+ loanNumber + ", loanTerm=" + loanTerm + ", state=" + state + ", zip=" + zip + "]";
	}

}
