package com.websystique.springmvc.dao;

import com.websystique.springmvc.entity.MappedContact;
import java.util.Collection;

/**
 *
 * @author ksu
 */
public interface ContactDao {

	MappedContact selectContact(int id);
        MappedContact selectContact(String phone);
        void updateContact(MappedContact contact);
	void insertContact(MappedContact contact);
	void deleteContact(MappedContact contact);
	Collection <MappedContact> selectAllContacts();
	void clearAll();
}
