package deronzier.remi.patientsmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * This class is the entry point of the application
 * 
 * @author Rémi Deronzier
 */
@SpringBootApplication
@EnableSwagger2
public class PatientsMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientsMicroserviceApplication.class, args);
	}

}
