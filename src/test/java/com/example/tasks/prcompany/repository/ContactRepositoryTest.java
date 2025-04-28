package com.example.tasks.prcompany.repository;

import com.example.tasks.prcompany.models.Contact;
import com.example.tasks.prcompany.models.Name;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ContactRepositoryTest {

    @Autowired
    private ContactRepository contactRepository;

    @Test
    void testSaveAndFindByCompany() {
        Name name = new Name("John", "Doe", "M", "Mr.");
        Contact contact = new Contact(name, "Manager", "OpenAI");

        contactRepository.save(contact);

        List<Contact> foundContacts = contactRepository.findByCompany("OpenAI");

        assertThat(foundContacts).isNotEmpty();
        assertThat(foundContacts.get(0).getCompany()).isEqualTo("OpenAI");
    }

    @Test
    void testFindByLastName() {
        Name name = new Name("Jane", "Smith", "A", "Ms.");
        Contact contact = new Contact(name, "Director", "TechCorp");

        contactRepository.save(contact);

        List<Contact> foundContacts = contactRepository.findByLastName("Smith");

        assertThat(foundContacts).isNotEmpty();
        assertThat(foundContacts.get(0).getName().getLastName()).isEqualTo("Smith");
    }
}

