package com.hyva.hospital.holistic.respositories;

import com.hyva.hospital.holistic.entities.OtpGeneration;
import com.hyva.hospital.holistic.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface OtpRepository extends JpaRepository<OtpGeneration, Long> {

    OtpGeneration findByPhoneNumber(String phoneno);

}
