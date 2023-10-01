package com.mch.contactmanagement.controller;

import com.mch.contactmanagement.entities.Contact;
import com.mch.contactmanagement.exception.ContactNotFoundException;
import com.mch.contactmanagement.service.ContactService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
@Tag(name = "Contact", description = "Methods for Contact Management")
@CrossOrigin
public class ContactController {

    private final ContactService contactService;

    @GetMapping
    @Operation(description = "search all contacts saved in the database", summary = "Get list of contact")
    public ResponseEntity<List<Contact>> findAllContacts() {
        List<Contact> contactList = contactService.findAllContact();
        if (!contactList.isEmpty()) {
            return new ResponseEntity<>(contactList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    @Operation(description = "Save a contact in the database", summary = "Save contact")
    public ResponseEntity<Contact> saveNewContact(@RequestBody Contact contact) {
        Optional<Contact> newContact = Optional.ofNullable(contactService.saveContact(contact));
        return newContact.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.BAD_REQUEST));
    }

    @PutMapping
    @Operation(description = "Update a contact in the database", summary = "Update contact")
    public ResponseEntity<Contact> updateContact(@RequestBody Contact contact) {
        Optional<Contact> newContact = Optional.ofNullable(contactService.updateContact(contact));
        return newContact.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.BAD_REQUEST));
    }

    @DeleteMapping(value = "/{idContact}")
    @Operation(description = "Delete a contact in the database", summary = "Delete contact")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<Boolean> deleteContact(@PathVariable("idContact") Long id) {
        Boolean result = contactService.deleteContact(id);
        if (Boolean.TRUE.equals(result)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/{idContact}")
    @Operation(description = "find contact by Id ", summary = "Find contact by Id")
    @ApiResponses(value = {
            @ApiResponse( responseCode = "200", description = "contact found"),
            @ApiResponse( responseCode = "404", description = "contact not found")
    })
    public ResponseEntity<Contact> findContactById(@PathVariable("idContact") Long id) {
        Contact contact = contactService.findContactById(id);
        if (contact == null) {
            throw new ContactNotFoundException("id Contact : " + id);
        }
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }
}
