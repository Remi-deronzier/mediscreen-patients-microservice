package deronzier.remi.patientsmicroservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This class is the Exception class when no patient is found
 * 
 * @author Rémi Deronzier
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class PatientNotFoundException extends Exception {
    public PatientNotFoundException(String message) {
        super(message);
    }
}
