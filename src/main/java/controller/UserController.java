package controller;

import java.util.Optional;

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
import service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class UserController {

	@Autowired
	IAccount account;
	@Autowired
	IUser user;

	@Autowired
	UserService userService;

	Account newAccount = null;

	@PostMapping("userLogin")

	public String userLogin(@RequestBody User u) {
		if (user.findByUsername(u.getUsername()) != null) {
			if (user.findByPassword(u.getPassword()) != null) {
				return "true";

			} else {

				return "false";
			}
		}
		return "false";

	}

	@PutMapping("user/updatePassword/{uid}")
	public String updatePassword(@RequestBody User iuser, @PathVariable("uid") int uid) {
		user.findById(uid).map(update -> {
			update.setPassword(iuser.getPassword());
			return user.save(update);

		});
		return "Password Updated Successfully";

	}

	@GetMapping("user/viewDetail/{account_id}")
	public Optional<Account> viewDetails(@PathVariable("account_id") long accountid) {
		Optional<Account> u = account.findById(accountid);
		return u;

	}

	@DeleteMapping("admin/deleteUser/{uid}")
	public String deleteUser(@PathVariable("uid") int uid) {
		System.out.println("delete"+uid);
		user.deleteById(uid);
		return "User Account Deleted Successfully";

	}
	@GetMapping("searchAccount/{account_id}")
	public Optional<Account> viewDetail(@PathVariable("account_id") long accountid) {
		Optional<Account> a = account.findById(accountid);
		return a;
	}

	@PutMapping("transfer/{account_id}/{amount}/{username}")
	public String transfermoney(@PathVariable("account_id") long accountid, @PathVariable("amount") long amount,
			@PathVariable("username") String username) {
		newAccount = account.findById(accountid).get();
		return userService.transferMoney(accountid, amount, newAccount);
	}
	
//	@PutMapping("transfer/{account_id}/{amount}/{username}")
//	public String transfermoney(@PathVariable("account_id") long accountid, @PathVariable("amount") long amount,
//			@PathVariable("username") String username) {
//		newAccount = account.findById(accountid).get();
//		return userService.transferMoney(accountid, amount, newAccount);
//	}


}