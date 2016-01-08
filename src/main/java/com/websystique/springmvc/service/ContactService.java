package com.websystique.springmvc.service;

import com.websystique.springmvc.model.Contact;
import java.util.Collection;

public interface ContactService {

	Contact getContact(int id);
	Contact getContact(String phone);
	void addContact(Contact contact);
	void updateContact(Contact contact);
	void deleteContact(Contact contact);
	Collection<Contact> getAllContacts(); 
        void clearAll();	
}
