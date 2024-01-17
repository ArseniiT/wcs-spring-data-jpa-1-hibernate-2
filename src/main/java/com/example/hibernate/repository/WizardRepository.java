package com.example.hibernate.repository;

import com.example.hibernate.entity.Wizard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WizardRepository extends JpaRepository<Wizard, Long> {
}
