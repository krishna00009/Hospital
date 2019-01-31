package com.hyva.hospital.holistic.respositories;

import com.hyva.hospital.holistic.entities.Appointments;
import com.hyva.hospital.holistic.entities.Customers;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointments,Long> {
    Appointments findById(Long Id);
    Appointments findFirstByUserId(Sort sort,Long userid);
    Appointments findFirstBy(Sort sort);
    List<Appointments> findAllByUserId(Pageable pageable,Long userid);
    List<Appointments> findAllBy(Pageable pageable);
    List<Appointments> findAllByCustomersInAndUserId(List<Customers> name, Pageable pageable,Long userid);
    List<Appointments> findAllByCustomersIn(List<Customers> name, Pageable pageable);
    List<Appointments> findAllByCustomersInAndUserId(List<Customers> name,Long userid);
    List<Appointments> findAllByCustomersIn(List<Customers> name);
    List<Appointments> findAllByUserId(Long userid);
    Appointments findFirstByCustomersIn(Customers name, Sort sort);
    Appointments findFirstByCustomersInAndUserId(Customers name,Long userId, Sort sort);
    List<Appointments> findAllByBookDatetime(Date date);
    List<Appointments> findAllByCustomers(Customers customers);
    List<Appointments> findAllByBookDatetimeBetween(Date fromdate,Date todate);
}
