package com.mch.contactmanagement.service;

import com.mch.contactmanagement.entities.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> findAllContact();
    Contact saveContact(Contact contact);
    Contact updateContact(Contact contact);
    Boolean deleteContact(Long idContact);
    Contact findContactById(Long idContact);

}
