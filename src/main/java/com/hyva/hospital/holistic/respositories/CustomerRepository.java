package com.hyva.hospital.holistic.respositories;

import com.hyva.hospital.holistic.entities.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository  extends JpaRepository<Customers, Long> {

    Customers findById(Long Id);
    List<Customers> findAllByUserId(Long userid);
//    Customers findByFirstName(String firstName);
//    Customers findByFirstNameAndId(String First_name,Long Id);
    List<Customers> findAllByFirstNameContainingOrPhoneNumberContainingOrUhidContaining(String SearchText,String phoneno,String uhid);
    List<Customers> findByOrderByIdDesc();
    List<Customers> findByFirstNameAndIdNotIn(String firstname,Long id);
    List<Customers> findByFirstNameOrPhoneNumberOrUhid(String firstname,String phoneno,String uhid);
    List<Customers> findByFirstName(String firstname);
}
