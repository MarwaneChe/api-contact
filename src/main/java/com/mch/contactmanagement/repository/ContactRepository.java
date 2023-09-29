package com.mch.contactmanagement.repository;

import com.mch.contactmanagement.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,Long> {
}
