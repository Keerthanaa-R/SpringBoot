package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dao.IAdmin;
import model.Admin;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class AdminController {

	@Autowired
	IAdmin admin;

	@PostMapping("adminLogin")
	public String adminLogin(@RequestBody Admin a) {
		if (admin.findById(a.getUsername()).isPresent()) {
			if (admin.findById(a.getUsername()).get().getPassword().equals(a.getPassword())) {
				return "true";
			} else {
				return "false";
			}
		}
		return "false";
	}

	@PutMapping("updateAdmin/{username}")
	public String updateAdmin(@RequestBody Admin a, @PathVariable("username") String username) {
		admin.findById(username).map(update -> {
			update.setPassword(a.getPassword());
			return admin.save(update);

		});
		return "Admin Details Updated Successfully";

	}

}
