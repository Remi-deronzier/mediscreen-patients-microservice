package deronzier.remi.patientsmicroservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import deronzier.remi.patientsmicroservice.exceptions.PatientNotFoundException;
import deronzier.remi.patientsmicroservice.models.CreateClass;
import deronzier.remi.patientsmicroservice.models.Patient;
import deronzier.remi.patientsmicroservice.models.UpdateClass;
import deronzier.remi.patientsmicroservice.services.PatientService;

/**
 * This class is the controller class for the Patient entity
 * 
 * @author Rémi Deronzier
 */
@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService service;

    /**
     * @param pageable
     * @return Page<Patient>
     */
    @GetMapping
    public Page<Patient> findAll(@SortDefault(sort = "lastName") Pageable pageable) {
        return service.findAll(pageable);
    }

    /**
     * @param id
     * @return Patient
     * @throws PatientNotFoundException
     */
    @GetMapping("/{id}")
    public Patient find(@PathVariable long id) throws PatientNotFoundException {
        return service.find(id);
    }

    /**
     * @param patient
     * @return Patient
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Patient save(@Validated(CreateClass.class) @RequestBody Patient patient) {
        return service.save(patient);
    }

    /**
     * @param id
     * @param patient
     * @return Patient
     * @throws PatientNotFoundException
     */
    @PutMapping("/{id}")
    public Patient update(@PathVariable long id, @Validated(UpdateClass.class) @RequestBody Patient patient)
            throws PatientNotFoundException {
        return service.update(id, patient);
    }

    /**
     * @param id
     * @return String
     * @throws PatientNotFoundException
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id) throws PatientNotFoundException {
        return service.delete(id);
    }
}
