package com.hyva.hospital.holistic.respositories;

import com.hyva.hospital.holistic.entities.Users;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, Long> {

    Users findByUsernameAndPassword(String  userName, String Password);
    Users findByPhoneNumberAndPassword(String  phoneno, String Password);
    Users findByPhoneNumberOrUsernameAndPassword(String username,String  phoneno, String Password);
    Users findByEmail(String Email);
    Users findByUsername(String name);
    Users findById(Long Id);

    List<Users> findByFirstNameContaining(String firstName);

    List<Users> findByOrderByIdDesc();
    Users findFirstBy(Sort sort);
    List<Users> findAllBy(Pageable pageable);
    List<Users> findByUsernameAndIdNotIn(String username,Long id);
    List<Users> findAllByUsername(String firstname);
    Users findByPhoneNumberAndIdNotIn(String phoneno,Long id);
    Users findByPhoneNumber(String phoneno);
    List<Users> findAllByUsernameContaining(String searchText);
    Users findFirstByUsernameContaining(String searchText,Sort sort);
    List<Users> findAllByUsernameContaining(String searchText, Pageable pageable);
    List<Users> findAllByIdNot(Long id);
    Users findAllByLoginStatus(String login);


}
