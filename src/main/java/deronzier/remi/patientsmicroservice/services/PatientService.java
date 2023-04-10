package deronzier.remi.patientsmicroservice.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import deronzier.remi.patientsmicroservice.exceptions.PatientNotFoundException;
import deronzier.remi.patientsmicroservice.models.Patient;

/**
 * This interface defines all the methods for the services related to the
 * Patient entity
 * 
 * @author Rémi Deronzier
 */
public interface PatientService {
    public Page<Patient> findAll(Pageable pageable);

    public Patient find(long id) throws PatientNotFoundException;

    public Patient save(Patient patient);

    public String delete(long id) throws PatientNotFoundException;

    public Patient update(long id, Patient patient) throws PatientNotFoundException;
}
