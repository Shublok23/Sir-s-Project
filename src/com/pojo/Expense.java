package com.pojo;

public class Expense {

	private int expId;
	private String exp,expDetails,expDate,email;
	public int getExpId() {
		return expId;
	}
	public void setExpId(int expId) {
		this.expId = expId;
	}
	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}
	public String getExpDetails() {
		return expDetails;
	}
	public void setExpDetails(String expDetails) {
		this.expDetails = expDetails;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Expense [expId=" + expId + ", exp=" + exp + ", expDetails=" + expDetails + ", expDate=" + expDate
				+ ", email=" + email + "]";
	}
	
	
	
}
