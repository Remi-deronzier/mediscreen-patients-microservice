package deronzier.remi.patientsmicroservice.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    @NotBlank(message = "Patient last name cannot be null")
    private String lastName;

    @Column(nullable = false)
    @NotBlank(message = "Patient last name cannot be null")
    private String firstName;

    @Column(nullable = false)
    @NotBlank(message = "Patient date of birth cannot be null")
    private LocalDate dateOfBirth;

    @Column(nullable = false)
    @NotBlank(message = "Patient sex cannot be null")
    @Enumerated
    private Sex sex;

    @Column(nullable = false)
    @NotBlank(message = "Patient address cannot be null")
    private String address;

    @Column(nullable = false)
    @NotBlank(message = "Patient phone number cannot be null")
    private String phoneNumber;
}
