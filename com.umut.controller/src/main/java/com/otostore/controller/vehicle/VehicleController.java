package com.otostore.controller.vehicle;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.otostore.model.Vehicle;
import com.otostore.model.Vendor;
import com.otostore.service.FuelTypeService;
import com.otostore.service.VehicleService;
import com.otostore.service.VendorService;

@Controller
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

	@Autowired
	private VendorService vendorService;

	@Autowired
	private FuelTypeService fuelTypeService;

	@RequestMapping(value = "/users/vendors/{vendorName}/vehicles", method = RequestMethod.GET)
	public String getVehicles(@PathVariable String vendorName, Model model) {

		List<Vehicle> vehicles = vehicleService.findVehicleByVendor(vendorName);
		model.addAttribute("vehicles", vehicles);
		return "vehicle/viewVehicles";
	}

	@RequestMapping(value = "/users/vendors/{vendorName}/vehicles" , params = "saveVehicle")
	public String createForm(Model model) {
		model.addAttribute("vehicle" , new Vehicle());
		return "/vehicle/saveVehicle";
	}

	@RequestMapping(value = "/users/vendors/{vendorName}/vehicles" , method = RequestMethod.POST)
	public String saveVehicle(@PathVariable String vendorName,@ModelAttribute("vehicle") @Valid Vehicle vehicle , BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "vehicle/saveVehicle";
		}
		
		Vendor vendor = vendorService.findVendorByVendorName(vendorName);
		vehicle.setVendor(vendor);
		vehicle.setVendorName(vendorName);
		vehicleService.saveVehicle(vehicle);;
		return "redirect:/users/vendors/{vendorName}/vehicles";
		
	}
	
	@ModelAttribute("fuelTypes")/*FuelList metodu controllera yüklendi.*/
	private void fuelListString(Model model) {
		List<String> fuelTypes = fuelTypeService.findAllFuel();
		model.addAttribute("fuelTypes" , fuelTypes);
	}
	
}
