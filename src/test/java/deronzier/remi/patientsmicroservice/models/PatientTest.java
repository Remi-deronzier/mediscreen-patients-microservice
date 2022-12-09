package deronzier.remi.patientsmicroservice.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class PatientTest {

    private static final String FIRST_NAME = "Paul";
    private static final String LAST_NAME = "ZAKARIO";
    private static final String DATE_OF_BIRTH = "1996-09-21";
    private static final Sex SEX = Sex.M;
    private static final String ADDRESS = "Rue des Lillas";
    private static final String PHONE_NUMBER = "0707070707";

    @Test
    void givenTwoEqualsPatients_whenCompareThem_ThenSucces() {
        Patient patient1 = new Patient();
        patient1.setLastName(LAST_NAME);
        patient1.setFirstName(FIRST_NAME);
        patient1.setDateOfBirth(LocalDate.parse(DATE_OF_BIRTH));
        patient1.setSex(SEX);
        patient1.setAddress(ADDRESS);
        patient1.setPhoneNumber(PHONE_NUMBER);

        Patient patient2 = new Patient();
        patient2.setLastName(LAST_NAME);
        patient2.setFirstName(FIRST_NAME);
        patient2.setDateOfBirth(LocalDate.parse(DATE_OF_BIRTH));
        patient2.setSex(SEX);
        patient2.setAddress(ADDRESS);
        patient2.setPhoneNumber(PHONE_NUMBER);

        assertEquals(patient1, patient2);
        assertEquals(patient1.hashCode(), patient2.hashCode());
    }

    @Test
    void givenTwoDifferentPatients_whenCompareThem_ThenFailure() {
        Patient patient1 = new Patient();
        patient1.setLastName(LAST_NAME);
        patient1.setFirstName(FIRST_NAME);
        patient1.setDateOfBirth(LocalDate.parse(DATE_OF_BIRTH));
        patient1.setSex(SEX);
        patient1.setAddress(ADDRESS);
        patient1.setPhoneNumber(PHONE_NUMBER);

        Patient patient2 = new Patient(); // without last name
        patient2.setFirstName(FIRST_NAME);
        patient2.setDateOfBirth(LocalDate.parse(DATE_OF_BIRTH));
        patient2.setSex(SEX);
        patient2.setAddress(ADDRESS);
        patient2.setPhoneNumber(PHONE_NUMBER);

        assertNotEquals(patient1, patient2);
        assertNotEquals(patient1.hashCode(), patient2.hashCode());
    }

}
