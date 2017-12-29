package com.otostore.controller.user.login;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.otostore.model.Vendor;
import com.otostore.service.VendorService;

@Controller
public class VendorLoginController {
	
	@Autowired
	private VendorService vendorService;
	
	@RequestMapping(value = "/login" , method = RequestMethod.GET)
	public String loginForm() {
		return "login";
	}
	
	@RequestMapping(value = "/login" , method = RequestMethod.POST)
	public String verifyLogin(@RequestParam String vendorName, @RequestParam String password , HttpSession session,Model model) {
		
		Vendor vendor = vendorService.loginVendor(vendorName, password);
		if(vendor == null) {
			model.addAttribute("loginError", "HATA ! Lütfen tekrar deneyiniz");
			return "login";
		}
		session.setAttribute("loggedInVendor", vendor);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/logout" , method = RequestMethod.GET)
	public String logoutVendor(HttpSession session) {
		session.removeAttribute("loggedInVendor");
		return "login";
	}
	
}	
