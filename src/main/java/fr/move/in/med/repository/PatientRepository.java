package fr.move.in.med.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.move.in.med.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
