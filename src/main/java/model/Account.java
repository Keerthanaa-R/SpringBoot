package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Account {
	@Id
	@Column(name = "account_id")
	private Long accountid;
	private String username;
	@Column(name = "mail_id")
	private String mailid;
	@Column(name = "mobile_no")
	private long mobileno;
	@Column(name = "account_type")
	private String accounttype;
	@Column(name = "account_balance")
	private long accountbalance;
	private String password;

	public Long getAccountid() {
		return accountid;
	}

	public void setAccountid(Long accountid) {
		this.accountid = accountid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMailid() {
		return mailid;
	}

	public void setMailid(String mailid) {
		this.mailid = mailid;
	}

	public long getMobileno() {
		return mobileno;
	}

	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}

	public String getAccounttype() {
		return accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}

	public long getAccountbalance() {
		return accountbalance;
	}

	public void setAccountbalance(long accountbalance) {
		this.accountbalance = accountbalance;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
