package com.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
