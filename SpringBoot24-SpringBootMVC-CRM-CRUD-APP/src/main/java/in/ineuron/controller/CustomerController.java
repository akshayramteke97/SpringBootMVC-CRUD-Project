package in.ineuron.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.ineuron.model.Customer;
import in.ineuron.service.ICustomerService;

@Controller
@RequestMapping(value="/customer")
public class CustomerController {
	
	@Autowired
	private ICustomerService service;
	
	
	@GetMapping(value="home")
	public String showHome(Map<String,Object> model) {
		List<Customer> customer = service.getCustomer();
		model.put("customer", customer);
		return "home";
	}
	@GetMapping(value="/showform")
	public String getCustomerForm(Map<String,Object> map) {
		Customer customer = new Customer();
		map.put("customer", customer);
		return "customer-form";
	}
	@PostMapping("/savecustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		service.saveCustomer(customer);
		return "redirect:/customer/home";
	}
}
