package com.muhammetcet.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muhammetcet.dto.DtoAccount;
import com.muhammetcet.dto.DtoAddress;
import com.muhammetcet.dto.DtoCustomer;
import com.muhammetcet.dto.DtoCustomerIU;
import com.muhammetcet.exception.BaseException;
import com.muhammetcet.exception.ErrorMessage;
import com.muhammetcet.exception.MessageType;
import com.muhammetcet.model.Account;
import com.muhammetcet.model.Adress;
import com.muhammetcet.model.Customer;
import com.muhammetcet.repository.AccountRepository;
import com.muhammetcet.repository.AddressRepository;
import com.muhammetcet.repository.CustomerRepository;
import com.muhammetcet.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private AddressRepository addressRepository;

	public Customer createCustomer(DtoCustomerIU dtoCustomerIU) {
	    if (dtoCustomerIU.getAdressId() == null) {
	        throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, "Adress ID yok"));
	    }
	    if (dtoCustomerIU.getAccountId() == null) {
	        throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, "Account ID yok"));
	    }

	    Optional<Adress> optAdress = addressRepository.findById(dtoCustomerIU.getAdressId());
	    if (optAdress.isEmpty()) {
	        throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, "Adress ID bulunamadı: " + dtoCustomerIU.getAdressId()));
	    }

	    Optional<Account> optAccount = accountRepository.findById(dtoCustomerIU.getAccountId());
	    if (optAccount.isEmpty()) {
	        throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, "Account ID bulunamadı " + dtoCustomerIU.getAccountId()));
	    }

	    Customer customer = new Customer();
	    customer.setCreateTime(new Date());

	    // Yanlış eşleşmeleri önlemek için tek tek set edelim
	    customer.setFirstName(dtoCustomerIU.getFirstName());
	    customer.setLastName(dtoCustomerIU.getLastName());
	    customer.setTckn(dtoCustomerIU.getTckn());
	    customer.setBirthOfDate(dtoCustomerIU.getBirthOfDate());

	    customer.setAdress(optAdress.get()); // Doğrudan adres objesini set et
	    customer.setAccount(optAccount.get()); // Doğrudan hesap objesini set et

	    return customer;
	}

	@Override
	public DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU) {
		DtoCustomer dtoCustomer = new DtoCustomer();
		DtoAddress dtoAddress = new DtoAddress();
		DtoAccount dtoAccount = new DtoAccount();

		Customer savedCustomer = customerRepository.save(createCustomer(dtoCustomerIU));
		BeanUtils.copyProperties(savedCustomer, dtoCustomer);
		BeanUtils.copyProperties(savedCustomer.getAdress(), dtoAddress);
		BeanUtils.copyProperties(savedCustomer.getAccount(), dtoAccount);

		dtoCustomer.setAdress(dtoAddress);
		dtoCustomer.setAccount(dtoAccount);

		return dtoCustomer;
	}

}
