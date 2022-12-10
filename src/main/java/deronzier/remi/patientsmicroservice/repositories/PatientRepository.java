package deronzier.remi.patientsmicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import deronzier.remi.patientsmicroservice.models.Patient;

/**
 * This interface is the DAO layer for Patient entity
 * 
 * @author Rémi Deronzier
 */
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
