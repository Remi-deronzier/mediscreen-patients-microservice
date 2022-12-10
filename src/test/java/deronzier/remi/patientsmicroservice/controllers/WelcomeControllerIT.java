package deronzier.remi.patientsmicroservice.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import deronzier.remi.patientsmicroservice.utils.Constants;

@ActiveProfiles(Constants.TEST_PROFILE)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class WelcomeControllerIT {

    @Value("${label.welcome}")
    private String greetings;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void givenRootBaseUrl_whenApiIsListening_thenSuccess() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is(greetings)));
    }

}
