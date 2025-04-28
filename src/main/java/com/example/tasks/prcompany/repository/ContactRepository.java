package com.example.tasks.prcompany.repository;

import com.example.tasks.prcompany.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    @Query("SELECT c FROM Contact c WHERE c.company = :company")
    List<Contact> findByCompany(String company);

    @Query("SELECT c FROM Contact c WHERE c.name.lastName = :lastName")
    List<Contact> findByLastName(String lastName);

    @Query(value = "SELECT * FROM contacts WHERE company LIKE :pattern", nativeQuery = true)
    List<Contact> findByCompanyPattern(String pattern);
}
