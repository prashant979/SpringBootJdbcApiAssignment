package com.example.prashant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prashant.dao.IndianBank;
import com.example.prashant.entity.Account;

@Service
public class IndianBankService {

	@Autowired
	private IndianBank indianBankDao;

	public List<Account> getAll() {
		return indianBankDao.getAll();
	}

	public Account getById(int id) {
		return indianBankDao.getById(id);
	}
	
	public boolean add(Account account) {
		return indianBankDao.add(account);
	}
	
	public boolean update(Account account) {
		return indianBankDao.update(account);
	}
	
	
	public boolean delete(int id) {
		return indianBankDao.delete(id);
	}
	
	
	
	
}
