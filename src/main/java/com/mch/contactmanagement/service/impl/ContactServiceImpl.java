package com.mch.contactmanagement.service.impl;

import com.mch.contactmanagement.entities.Contact;
import com.mch.contactmanagement.repository.ContactRepository;
import com.mch.contactmanagement.service.ContactService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    @Override
    public List<Contact> findAllContact() {
        return contactRepository.findAll();
    }

    @Override
    public Contact saveContact(Contact contact) {
        contact.setCreationDate(new Date());
        contact.setUpdateDate(new Date());
        return contactRepository.save(contact);
    }

    @Override
    public Contact updateContact(Contact contact) {
        contact.setUpdateDate(new Date());
        return contactRepository.save(contact);
    }

    @Override
    public Boolean deleteContact(Long idContact) {
        Optional<Contact> contact = contactRepository.findById(idContact);
        if (contact.isPresent()) {
            contactRepository.delete(contact.get());
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    @Override
    public Contact findContactById(Long idContact) {
        Optional<Contact> contact = contactRepository.findById(idContact);
        return contact.orElse(null);
    }
}
