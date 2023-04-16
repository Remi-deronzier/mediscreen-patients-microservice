package deronzier.remi.patientsmicroservice.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import lombok.Data;

/**
 * This class is the POJO class for the Patient entity
 * 
 * @author Rémi Deronzier
 */
@Entity
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    @NotBlank(message = "Patient last name cannot be null", groups = CreateClass.class)
    private String lastName;

    @Column(nullable = false)
    @NotBlank(message = "Patient last name cannot be null", groups = CreateClass.class)
    private String firstName;

    @Column(nullable = false)
    @NotNull(groups = CreateClass.class)
    @PastOrPresent
    private LocalDate dateOfBirth;

    @Column(nullable = false)
    @NotNull(groups = CreateClass.class)
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Column(nullable = false)
    @NotBlank(message = "Patient address cannot be null", groups = CreateClass.class)
    private String address;

    @Column(nullable = false)
    @NotBlank(message = "Patient phone number cannot be null", groups = CreateClass.class)
    private String phoneNumber;
}
