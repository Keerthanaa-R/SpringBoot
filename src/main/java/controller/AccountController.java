package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dao.IAccount;
import dao.IUser;
import model.Account;
import model.User;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class AccountController {
	@Autowired
	IAccount account;

	@Autowired
	IUser user;

	@GetMapping("/")
	public String welcome() {
		return "Welcome To Fund Transfer Appication";
	}

	@GetMapping("admin/viewAccount")
	public List<Account> viewAccount() {
		return account.findAll();
	}

	@DeleteMapping("admin/deleteAccount/{account_id}")
	public String deleteAccount(@PathVariable("account_id") long accountid) {
		account.deleteById(accountid);
		return "Account Deleted Successfully";
	}

	@GetMapping("admin/viewUser")
	public List<User> viewUser() {
		return user.findAll();
	}

	@PutMapping("admin/updateAccount")
	public String updateAccount(@RequestBody Account a) {
		account.findById(a.getAccountid()).map(update -> {
			update.setAccountid(a.getAccountid());
			update.setUsername(a.getUsername());
			update.setMailid(a.getMailid());
			update.setMobileno(a.getMobileno());
			update.setAccounttype(a.getAccounttype());
			update.setAccountbalance(a.getAccountbalance());
			update.setPassword(a.getPassword());
			return account.save(update);

		});
		return "Account Updated Successfully";
	}

//	@GetMapping("searchAccount/{account_id}")
//	public Optional<Account> viewDetails(@PathVariable("account_id") long accountid) {
//		Optional<Account> a = account.findById(accountid);
//		return a;
//	}

	@PostMapping("admin/addAccount")
	public String addAccount(@RequestBody Account a) {
		account.save(a);
		return "Account Added Sucessfully";
	}

}
