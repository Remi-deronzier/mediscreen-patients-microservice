package deronzier.remi.patientsmicroservice.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import deronzier.remi.patientsmicroservice.models.Patient;
import deronzier.remi.patientsmicroservice.models.Sex;

@SpringBootTest
@AutoConfigureMockMvc
public class PatientControllerTest {

    private final static long GOOD_ID_FIRST_PATIENT = 1;
    private final static String LAST_NAME_OF_FIRST_PATIENT_IN_TEST_DB = "DERONZIER";
    private final static String SUCCESSFUL_MESSAGE_OF_DELETION_OF_FIRST_PATIENT = "Patient 1 successfully deleted";
    private final static long BAD_ID = 10;

    private final static Patient VALID_PATIENT = new Patient();
    private final static Patient INVALID_PATIENT = new Patient(); // without last name

    private final static ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @BeforeAll
    static void setUp() {
        String firstName = "Paul";
        String lastName = "ZAKARIO";
        String dateOfBirth = "1996-09-21";
        Sex sex = Sex.M;
        String addresss = "Rue des Lillas";
        String phoneNumber = "0707070707";

        VALID_PATIENT.setLastName(lastName);
        VALID_PATIENT.setFirstName(firstName);
        VALID_PATIENT.setDateOfBirth(LocalDate.parse(dateOfBirth));
        VALID_PATIENT.setSex(sex);
        VALID_PATIENT.setAddress(addresss);
        VALID_PATIENT.setPhoneNumber(phoneNumber);

        INVALID_PATIENT.setFirstName(firstName);
        INVALID_PATIENT.setDateOfBirth(LocalDate.parse(dateOfBirth));
        INVALID_PATIENT.setSex(sex);
        INVALID_PATIENT.setAddress(addresss);
        INVALID_PATIENT.setPhoneNumber(phoneNumber);

        OBJECT_MAPPER.registerModule(new JavaTimeModule());
    }

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void givenGoodId_whenGettingAPatient_thenSuccess() throws Exception {
        mockMvc.perform(get("/patients/{id}", GOOD_ID_FIRST_PATIENT))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.lastName", is(LAST_NAME_OF_FIRST_PATIENT_IN_TEST_DB)));
    }

    @Test
    public void givenBadId_whenGettingAPatient_thenFailure() throws Exception {
        mockMvc.perform(get("/patients/{id}", BAD_ID))
                .andExpect(status().isNotFound());
    }

    @Test
    public void givenFirstPage_whenGettingAllPatients_thenSuccess() throws Exception {
        mockMvc.perform(get("/patients"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.empty", is(false)));
    }

    @Test
    public void givenSecondPage_whenGettingAllPatients_thenSuccess() throws Exception {
        mockMvc.perform(get("/patients?page=1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content", is(IsEmptyCollection.empty())));
    }

    @Test
    public void givenValidPatient_whenCreatingAPatient_thenSuccess() throws Exception {
        mockMvc.perform(post("/patients")
                .content(OBJECT_MAPPER.writeValueAsString(VALID_PATIENT))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.lastName", is(VALID_PATIENT.getLastName())));
    }

    @Test
    public void givenInvalidPatient_whenCreatingAPatient_thenFailure() throws Exception {
        mockMvc.perform(post("/patients")
                .content(OBJECT_MAPPER.writeValueAsString(INVALID_PATIENT))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void givenUpdatedPatientWithGoodId_whenUpdatingAPatient_thenSuccess() throws Exception {
        mockMvc.perform(put("/patients/{id}", GOOD_ID_FIRST_PATIENT)
                .content(OBJECT_MAPPER.writeValueAsString(VALID_PATIENT))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", is(VALID_PATIENT.getFirstName())));
    }

    @Test
    public void givenUpdatedPatientWithBadId_whenUpdatingAPatient_thenFailure() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        mockMvc.perform(put("/patients/{id}", BAD_ID)
                .content(objectMapper.writeValueAsString(VALID_PATIENT))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void givenGoodId_whenDeletingAPatient_thenSuccess() throws Exception {
        mockMvc.perform(delete("/patients/{id}", GOOD_ID_FIRST_PATIENT))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is(SUCCESSFUL_MESSAGE_OF_DELETION_OF_FIRST_PATIENT)));
    }

    @Test
    public void givenBadId_whenDeletingAPatient_thenFailure() throws Exception {
        mockMvc.perform(delete("/patients/{id}", BAD_ID))
                .andExpect(status().isNotFound());
    }

}