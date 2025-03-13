package com.muhammetcet.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muhammetcet.dto.DtoAccount;
import com.muhammetcet.dto.DtoAccountIU;
import com.muhammetcet.model.Account;
import com.muhammetcet.repository.AccountRepository;
import com.muhammetcet.service.IAccountService;

@Service
public class AccountServiceImpl implements IAccountService {
@Autowired
private AccountRepository accountRepository;	
	
	
	
	public Account createAccount(DtoAccountIU dtoAccountIU) {
		Account account =new Account();
		account.setCreateTime(new Date());
		
		BeanUtils.copyProperties(dtoAccountIU, account);
		
		return account;
	}

	@Override
	public DtoAccount saveAccount(DtoAccountIU input) {
		DtoAccount dtoAccount=new DtoAccount();
	
		
		Account savedAccount = accountRepository.save(createAccount(input));
		BeanUtils.copyProperties(savedAccount,dtoAccount);
		
		return dtoAccount;
	}

	
}
