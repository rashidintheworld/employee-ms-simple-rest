package com.example.employeems.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "employees")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, name = "emp_name")
    String name;

    @Column(nullable = false, name = "emp_surnname")
    String surname;

    @Column(nullable = false,name = "emp_position")
    String position;

    @Column(nullable = false,name = "emp_email")
    String email;

    @Column(nullable = false,name = "emp_phone_num")
    String phone_number;

    @Column(nullable = false, name = "emp_salary")
    Double salary;

    @CreationTimestamp
    LocalDateTime createdAt;

    @UpdateTimestamp
    LocalDateTime updatedAt;

    Integer active;
}
