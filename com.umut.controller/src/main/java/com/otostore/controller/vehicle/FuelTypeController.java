package com.otostore.controller.vehicle;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.otostore.model.sub.FuelType;
import com.otostore.service.FuelTypeService;


@Controller
public class FuelTypeController {
	
	@Autowired
	private FuelTypeService fuelTypeService;
	
	@RequestMapping(value = "/users/vendors/{vendorName}/fueltypes" , method = RequestMethod.GET)
	public String getFuelTypes(Model model) {
		
		List<FuelType> fuelTypes = fuelTypeService.findAllFuelType();
		model.addAttribute("fuelTypes" , fuelTypes);
		return "vehicle/fuel/viewFuelType";
	}
	
	@RequestMapping(value = "/users/vendors/{vendorName}/fueltypes" , params = "saveFuelType")
	public String createForm(Model model) {
		model.addAttribute("fuelType" , new FuelType());
		return "vehicle/fuel/saveFuelType";
	}
	
	@RequestMapping(value = "/users/vendors/{vendorName}/fueltypes", method = RequestMethod.POST)
	public String saveFuelType(@ModelAttribute("fuelType") @Valid FuelType fuelType, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "vehicle/fuel/saveFuelType";
		}
		fuelTypeService.saveFuelType(fuelType);
		return "redirect:/users/vendors/{vendorName}/fueltypes/";
		
	}
}
