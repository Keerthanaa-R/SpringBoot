package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import dao.IAccount;
import dao.IUser;
import model.Account;

@Configuration
public class UserService {
	@Autowired
	IAccount account;

	@Autowired
	IUser user;

	Account newaccount;
	Account at = null;

//	public String transferMoney(long accountid, long amount, Account newAccount) {
//		if (newAccount.getAccountbalance() < amount) {
//			return "Insufficient Balance";
//		} else {
//			newAccount.setAccountbalance(newAccount.getAccountbalance() - amount);
//			account.save(newAccount);
//			at = account.findByAccountid(accountid);
//			at.setAccountbalance(at.getAccountbalance() + amount);
//			account.save(at);
//			return "Your Transaction is Completed Successfully";
//		}
//	}

//	public String transferMoney(long accountid, long amount, Account newAccount) {
//		newAccount.setAccountbalance(newAccount.getAccountbalance() - amount);
//		account.save(newAccount);
//		at = account.findByAccountid(accountid);
//		at.setAccountbalance(at.getAccountbalance()+amount);
//		account.save(at);
//		return "Your Transaction is Completed Successfully";
//	}
	@SuppressWarnings("deprecation")
	public String transferMoney(long accountid, long amount, Account newAccount) {
		newAccount.setAccountbalance(newAccount.getAccountbalance() - amount);
		account.save(newAccount);
		at = account.getById(accountid);
		account.save(at);
		return "Your Transaction is Completed Successfully";
	}

}
