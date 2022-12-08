package deronzier.remi.patientsmicroservice.services;

import java.util.List;

import deronzier.remi.patientsmicroservice.exceptions.PatientNotFoundException;
import deronzier.remi.patientsmicroservice.models.Patient;

public interface PatientService {
    public List<Patient> findAll();

    public Patient find(long id) throws PatientNotFoundException;

    public Patient save(Patient patient);

    public String delete(long id) throws PatientNotFoundException;

    public Patient update(long id, Patient patient) throws PatientNotFoundException;
}
