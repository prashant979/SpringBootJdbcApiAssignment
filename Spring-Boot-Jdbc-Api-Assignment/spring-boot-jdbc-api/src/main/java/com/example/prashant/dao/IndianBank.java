package com.example.prashant.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.prashant.entity.Account;

@Repository
public class IndianBank {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private AccountMapper accountMapper;

	public List<Account> getAll() {
		return jdbcTemplate.query("select * from accounts", accountMapper);
	}

	public Account getById(int id) {
//		return jdbcTemplate.queryForObject("select * from accounts where id = ?", new Object[] { id }, accountMapper);
		return jdbcTemplate.queryForObject("select * from accounts where id = ?", accountMapper, id); // new way
		}

	public boolean add(Account account) {
		int rowAffected = jdbcTemplate.update("insert into accounts (name, password, balance) values (?, ?, ?)",
				new Object[] { account.getAccountName(), account.getAccountPassword(), account.getAccountBalance() });
		if (rowAffected > 0) {
			return true;
		}
		return false;
	}

	// Need to be done
	public boolean update(Account account) {
		int rowAffected = jdbcTemplate.update("update accounts set balance = ? where id = ?",
				new Object[] { account.getAccountBalance(), account.getAccountId() });
		if (rowAffected > 0) {
			return true;
		}
		return false;
	}

	public boolean delete(int id) {
		int rowAffected = jdbcTemplate.update("delete from accounts where id = ?", new Object[] { id });
		if (rowAffected > 0) {
			return true;
		}
		return false;
	}

}

@Component
class AccountMapper implements RowMapper<Account> {

	@Override
	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
		Account theAccount = new Account();
		theAccount.setAccountId(rs.getInt("id"));
		theAccount.setAccountName(rs.getString("name"));
		theAccount.setAccountPassword(rs.getString("password"));
		theAccount.setAccountBalance(rs.getInt("balance"));
		return theAccount;

	}

}
