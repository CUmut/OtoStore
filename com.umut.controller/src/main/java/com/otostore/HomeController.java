package com.otostore;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.otostore.model.Vendor;
import com.otostore.service.VendorService;

@Controller
public class HomeController {

	@Autowired
	private VendorService vendorService;

	/*
	 * @RequesMapping anotasyonu ile metodun hangi url requeste cevep vereceði
	 * belirlendi.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		return new ModelAndView("home");
	}

	@RequestMapping(value = "/vendors", method = RequestMethod.GET)
	public ModelAndView getVendors() {
		List<Vendor> vendorList = vendorService.findAllVendors();
		return new ModelAndView("home" , "vendor" , vendorList);
	}

}
