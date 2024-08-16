package in.ineuron.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ineuron.model.Customer;
import in.ineuron.service.ICustomerService;

@Controller
@RequestMapping(value="/customer")
public class CustomerController {
	
	@Autowired
	private ICustomerService service;
	
	
	@GetMapping(value="home")
	public String showHome(Map<String,Object> model) {
		List<Customer> customer = service.getAllCustomer();
		model.put("customer", customer);
		return "/customers/list-customers";
	}
	@GetMapping(value="/showform")
	public String getCustomerForm(Map<String,Object> map) {
		Customer customer = new Customer(); 
		map.put("customer", customer);
		return "/customers/customer-form";
	}
	@PostMapping("/savecustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		service.saveCustomer(customer);
		return "redirect:/customer/home";
	}
	@PostMapping(value="showUpdate")
	public String doUpdate(@RequestParam Integer customerId,Map<String,Object> map) {
		Customer customer = service.getOneCustomer(customerId);
		System.out.println(customer);
		map.put("customer", customer);
		return "/customers/customer-form";
	}
	
	@PostMapping(value="/showDelete")
	public String doIndividualDelete(@RequestParam Integer customerId) {
		service.deleteCustomerById(customerId);
		return "redirect:/customer/home";
	}
}
