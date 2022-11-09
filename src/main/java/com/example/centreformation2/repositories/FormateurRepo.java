package com.example.centreformation2.repositories;

import com.example.centreformation2.entities.Formateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormateurRepo extends JpaRepository<Formateur, Long> {

}
