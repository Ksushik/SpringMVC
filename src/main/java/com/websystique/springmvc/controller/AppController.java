package com.websystique.springmvc.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.websystique.springmvc.model.Contact;
import com.websystique.springmvc.service.ContactService;
import java.util.Collection;

@Controller
@RequestMapping("/")
public class AppController {

	@Autowired
	ContactService service;
	
	@Autowired
	MessageSource messageSource;

	/*
	 * This method will list all existing employees.
	 */
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String allContacts(ModelMap model) {
		Collection<Contact> contacts = service.getAllContacts();
		model.addAttribute("contacts", contacts);
		return "allcontacts";
	}

	/*
	 * This method will provide the medium to add a new employee.
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newContact(ModelMap model) {
		Contact contact = new Contact();
		model.addAttribute("contact", contact);
		model.addAttribute("edit", false);
		return "registration";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving employee in database. It also validates the user input
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String saveContact(@Valid Contact contact, BindingResult result,
			ModelMap model) {
		if (result.hasErrors()) {
			return "registration";
		}

		/*
		 * Preferred way to achieve uniqueness of field [ssn] should be implementing custom @Unique annotation 
		 * and applying it on field [ssn] of Model class [Employee].
		 * 
		 * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
		 * framework as well while still using internationalized messages.
		 * 
		 */

		service.addContact(contact);

		model.addAttribute("success", "Contact " + contact.getFirstName()+ " registered successfully");
		return "success";
	}


	/*
	 * This method will provide the medium to update an existing employee.
	 */
	@RequestMapping(value = { "/edit-{phone}-contact" }, method = RequestMethod.GET)
	public String getContact(@PathVariable String phone, ModelMap model) {
		Contact contact = service.getContact(phone);
		model.addAttribute("contact", contact);
		model.addAttribute("edit", true);
		return "registration";
	}
	
	/*
	 * This method will be called on form submission, handling POST request for
	 * updating employee in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit-{phone}-contact" }, method = RequestMethod.POST)
	public String updateContact(@Valid Contact contact, BindingResult result,
			ModelMap model, @PathVariable String phone) {

		if (result.hasErrors()) {
			return "registration";
		}


		service.updateContact(contact);

		model.addAttribute("success", "Contact " + contact.getFirstName()+ " updated successfully");
		return "success";
	}

	
	/*
	 * This method will delete an employee by it's SSN value.
	 */
	@RequestMapping(value = { "/delete-{id}-contact" }, method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable int id) {
                Contact contact = service.getContact(id);
		service.deleteContact(contact);
		return "redirect:/list";
	}

}
