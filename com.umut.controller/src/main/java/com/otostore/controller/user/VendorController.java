package com.otostore.controller.user;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.otostore.model.Vendor;
import com.otostore.service.VendorService;

@Controller
@RequestMapping(value = "/users/vendors")
public class VendorController {
	
	@Autowired
	private VendorService vendorService;
	
	@RequestMapping(params = "registerVendor")
	public String createForm(Model model) {
		model.addAttribute("vendor" , new Vendor());
		return "user/vendor/registerVendor";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String saveVendor(@ModelAttribute("vendor") @Valid Vendor vendor , BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "user/vendor/registerVendor";
		}
		vendorService.saveVendor(vendor);
		return "redirect:/users/vendors/" + vendor.getVendorName();
	}
	
	@RequestMapping(value = "/{vendorName}")
	public String getVendorProfile(@PathVariable String vendorName , Map<String, Object> model) {
		
		Vendor vendor = vendorService.findVendorByVendorName(vendorName);
		model.put("vendor", vendor);
		return "user/vendor/viewVendor";
	}
	
	@RequestMapping(value = "/{vendorName}/edit" , method = RequestMethod.GET)
	public String editVendorProfile(@PathVariable String vendorName, Map<String, Object> model) {
		
		Vendor vendor = vendorService.findVendorByVendorName(vendorName);
		model.put("vendor", vendor);
		return "user/vendor/editVendor";
	}
	
	@RequestMapping(value = "/{vendorName}/edit" , method = RequestMethod.POST)
	public String updateVendorProfile(@ModelAttribute("vendor") @Valid Vendor vendor , BindingResult result) {
		
		if(result.hasErrors()) {
			return "user/vendor/editVendor";
		}
		vendorService.updateVendor(vendor);
		return "redirect:/users/vendors/" + vendor.getVendorName();
	}
}
