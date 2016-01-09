package com.websystique.springmvc.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.websystique.springmvc.service.ContactService;
import com.websystique.springmvc.dao.ContactDao;
import com.websystique.springmvc.entity.MappedContact;
import com.websystique.springmvc.eventlistener.ClearEvent;
import com.websystique.springmvc.model.Contact;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;

@Service("contactService")
@Transactional
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactDao dao;

    @Value("${maxSize}")
    private String maxContactBookSize;
    private int contactsNumber;
    private ApplicationEventPublisher publisher;

    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    @Transactional
    public void addContact(Contact contact) {
        dao.insertContact(new MappedContact(contact));
    }

    @Override
    @Transactional
    public void updateContact(Contact contact) {
        dao.updateContact(new MappedContact(contact));
    }

    @Override
    @Transactional
    public void deleteContact(Contact contact) {
        publisher.publishEvent(new ClearEvent(this, contact));
        dao.deleteContact(new MappedContact(contact));
    }

    @Override
    @Transactional
    public Contact getContact(String phone) {
        return new Contact(dao.selectContact(phone));
    }

    @Override
    @Transactional
    public Contact getContact(int id) {
        return new Contact(dao.selectContact(id));
    }

    @Override
    @Transactional
    public Collection<Contact> getAllContacts() {
        Collection<MappedContact> mappedContacts = dao.selectAllContacts();
        Collection<Contact> contacts = new ArrayList<Contact>(mappedContacts.size());
        for (MappedContact mappedContact : mappedContacts) {
            Contact contact = null;
            contact = new Contact(mappedContact);
            contacts.add(contact);
        }
        return contacts;
    }

    @Override
    @Transactional
    public void clearAll() {
        dao.clearAll();
    }

    @Transactional
    public void clear() {
        Contact contact = new Contact(dao.selectContact(contactsNumber - 1));
        publisher.publishEvent(new ClearEvent(this, contact));
        dao.selectAllContacts().remove(contact);
    }

    /**
     * @return the dao
     */
    public ContactDao dao() {
        return dao;
    }

    /**
     * @param dao the dao to set
     */
    public void setDao(ContactDao dao) {
        this.dao = dao;
    }

    /**
     * @return the maxContactBookSize
     */
    public String getMaxContactBookSize() {
        return maxContactBookSize;
    }

    /**
     * @param maxContactBookSize the maxContactBookSize to set
     */
    public void setMaxContactBookSize(String maxContactBookSize) {
        this.maxContactBookSize = maxContactBookSize;
    }
}
