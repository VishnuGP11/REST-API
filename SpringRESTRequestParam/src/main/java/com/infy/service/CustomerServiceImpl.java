package com.infy.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infy.dto.CustomerDTO;
import com.infy.entity.Customer;
import com.infy.exception.InfyBankException;
import com.infy.repository.CustomerRepository;

@Service(value = "customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public CustomerDTO getCustomer(Integer customerId) throws InfyBankException {
		Optional<Customer> optional = customerRepository.findById(customerId);
		Customer customer = optional.orElseThrow(() -> new InfyBankException("Service.CUSTOMER_NOT_FOUND"));

		return modelMapper.map(customer, CustomerDTO.class);
	}

	@Override
	public List<CustomerDTO> getAllCustomers() throws InfyBankException {
		Iterable<Customer> customers = customerRepository.findAll();

		return modelMapper.map(customers, new TypeToken<List<CustomerDTO>>() {
		}.getType());

	}

	@Override
	public Integer addCustomer(CustomerDTO customerDTO) throws InfyBankException {

		return customerRepository.save(modelMapper.map(customerDTO, Customer.class)).getCustomerId();

	}

	@Override
	public void updateCustomer(Integer customerId, String emailId) throws InfyBankException {
		Optional<Customer> customer = customerRepository.findById(customerId);
		Customer c = customer.orElseThrow(() -> new InfyBankException("Service.CUSTOMER_NOT_FOUND"));
		c.setEmailId(emailId);
	}

	@Override
	public void deleteCustomer(Integer customerId) throws InfyBankException {
		Optional<Customer> customer = customerRepository.findById(customerId);
		customer.orElseThrow(() -> new InfyBankException("Service.CUSTOMER_NOT_FOUND"));
		customerRepository.deleteById(customerId);
	}

}
