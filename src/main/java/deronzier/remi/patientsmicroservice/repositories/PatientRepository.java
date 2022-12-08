package deronzier.remi.patientsmicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import deronzier.remi.patientsmicroservice.models.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
