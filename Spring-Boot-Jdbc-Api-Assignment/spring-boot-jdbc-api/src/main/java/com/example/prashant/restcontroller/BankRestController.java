package com.example.prashant.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.prashant.entity.Account;
import com.example.prashant.service.IndianBankService;

@RestController
@RequestMapping("/bank")
public class BankRestController {

	@Autowired
	private IndianBankService bankService;

	@GetMapping("/accounts")
	public List<Account> getAll() {
		return bankService.getAll();
	}

	@GetMapping("/accounts/{id}")
	public Account getById(@PathVariable int id) {
		return bankService.getById(id);
	}

	@PostMapping("/accounts")
	public String add(@RequestBody Account account) {
		if (bankService.add(account)) {
			return "Account Created";
		}
		return "Failed to add Account";
	}

	// Not Done
	@PutMapping("/accounts")
	public String update(@RequestBody Account account) {
		if (bankService.update(account)) {
			return "Account Updated";
		}
		return "Failed to update Account";
	}

	@DeleteMapping("/accounts/{id}")
	public String delete(@PathVariable int id) {
		if (bankService.delete(id)) {
			return "Account Deleted";
		}
		return "Failed to delete Account";
	}

}
