package in.ineuron.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.dao.ICustomerDao;
import in.ineuron.model.Customer;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerDao repo;
	
	@Override
	public List<Customer> getCustomer() {
		return (List<Customer>) repo.findAll() ;
	}

	@Override
	public void saveCustomer(Customer customer) {
		repo.save(customer);
	}

}
