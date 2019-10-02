package fr.move.in.med.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.move.in.med.model.Professionnel;

@Repository
public interface ProfessionnelRepository extends JpaRepository<Professionnel, Long> {

}
