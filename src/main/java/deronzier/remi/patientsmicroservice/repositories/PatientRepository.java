package deronzier.remi.patientsmicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import deronzier.remi.patientsmicroservice.models.Patient;

/**
 * This interface is the DAO layer for Patient entity
 * 
 * @author Rémi Deronzier
 */
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
