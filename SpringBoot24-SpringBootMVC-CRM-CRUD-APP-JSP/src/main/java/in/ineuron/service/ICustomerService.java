package in.ineuron.service;

import java.util.List;
import java.util.Optional;

import in.ineuron.model.Customer;

public interface ICustomerService {
	public List<Customer> getAllCustomer();
	public void saveCustomer(Customer customer);
	public Customer getOneCustomer(Integer id);
	public void deleteCustomerById(Integer id);
}
