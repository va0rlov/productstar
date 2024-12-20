package ru.contacts.db.app.repository;

import ru.contacts.db.app.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}