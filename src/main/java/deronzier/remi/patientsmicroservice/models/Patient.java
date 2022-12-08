package deronzier.remi.patientsmicroservice.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Data;

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
    @Past
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
