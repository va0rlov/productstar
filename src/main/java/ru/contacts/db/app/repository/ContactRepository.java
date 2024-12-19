package ru.contacts.db.app.repository;

import ru.contacts.db.app.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}