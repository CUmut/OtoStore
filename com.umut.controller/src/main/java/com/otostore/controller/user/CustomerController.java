package com.otostore.controller.user;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.otostore.model.Customer;
import com.otostore.service.CustomerService;
import com.otostore.validators.CustomerValidator;

@Controller
@RequestMapping(value = "/users/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CustomerValidator customerValidator;
	
	
	@RequestMapping(params = "registerCustomer")
	public String createForm(Model model) { /*Model,Spring tarafýndan saðlanan bir inteface'dir.Model ile View arasýndaki veri senkronizasyonu saðlanmaktadýr.*/
		model.addAttribute("customer" , new Customer());
		return "user/customer/registerCustomer";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer") @Valid Customer customer, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "user/customer/registerCustomer";
		}
		customerService.saveCustomer(customer);
		return "redirect:/users/customers/" + customer.getProfileName();
	}
	
	@RequestMapping(value = "/{profileName}")
	public String getCustomerProfile(@PathVariable String profileName, Map<String , Object> model) {
		
		Customer customer = customerService.findCustomerByProfileName(profileName);
		model.put("customer", customer);
		return "user/customer/viewCustomer";
	}
	
	@RequestMapping(value = "/{profileName}/edit" , method = RequestMethod.GET)
	public String editCustomerProfile(@PathVariable String profileName , Map<String, Object> model) {
		
		Customer customer = customerService.findCustomerByProfileName(profileName);
		model.put("customer", customer);
		return "user/customer/editCustomer";
	}
	
	
	@RequestMapping(value = "/{profileName}/edit" , method = RequestMethod.POST)
	public String updateCustomerProfile(@ModelAttribute("customer") @Valid Customer  customer, BindingResult result) {
		
		if(result.hasErrors()) {
			return "user/customer/editCustomer";
		}
		customerService.updateCustomer(customer);
		return "redirect:/users/customers/" + customer.getProfileName();
	}
	
	@InitBinder/*CustomerController'a inject edilmiþ customerValidator nesnesi çaðýrýlmakta ve setValidator ile validasyon yapýlmaktadýr.*/
	private void initBinder(WebDataBinder webDataBinder) {
		
		webDataBinder.setValidator((Validator) customerValidator);
		webDataBinder.setAllowedFields("firstName" , "lastName" , "profileName" , "phone" , "email" , "password");
	}
	
	
	@ExceptionHandler(Exception.class)
	public ModelAndView errorHandler(HttpServletRequest  httpRequest, Exception exception) {
		
		ModelAndView model = new ModelAndView();
		model.addObject("exception" , exception);
		model.addObject("url" , httpRequest.getRequestURI());
		model.setViewName("user/customer/errorCustomer");
		return model;
	}
	
	
	
}
