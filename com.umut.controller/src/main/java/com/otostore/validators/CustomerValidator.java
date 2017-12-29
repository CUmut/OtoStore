package com.otostore.validators;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.otostore.model.Customer;

@Component
public class CustomerValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Customer.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		Customer customer = (Customer) target;
		String profileName = customer.getProfileName();

		if (!StringUtils.hasLength(profileName)) {
			errors.rejectValue("profileName", "required", "lütfen profile name belirleyiniz");
		} else if (profileName.trim().length() < 5) {
			errors.rejectValue("profileName", "required", "profile name en az 5 karakter olmalýdýr");
		}
	}
}
