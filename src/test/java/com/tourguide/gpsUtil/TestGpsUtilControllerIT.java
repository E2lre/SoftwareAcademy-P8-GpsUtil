package com.tourguide.gpsUtil;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Locale;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestGpsUtilControllerIT {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getUserLocation_forUUID_OkIsReturn() throws Exception {
        //GIVEN : for a UUID

        Locale.setDefault(Locale.US);
        UUID userUUID = UUID.randomUUID();
        //WHEN call Controller
        //THEN return is OK
        mockMvc.perform(get("/getUserLocation?userId=" + userUUID))
                .andExpect(status().isOk());
    }
    @Test
    public void getUserLocation_forUUIDUnformated_errorIsReturn() throws Exception {
        //GIVEN : for abad  UUID
        Locale.setDefault(Locale.US);
        String userUUID = "1234567890";

        //WHEN call Controller
        //THEN return is KO
        mockMvc.perform(get("/getUserLocation?userId=" + userUUID))
                .andExpect(status().isBadRequest());
    }
    @Test
    public void getUserLocationV2_forUserUUID_OkIsReturn() throws Exception {
        //GIVEN : for a UUID
        //WHEN call Controller
        //THEN return is OK
        Locale.setDefault(Locale.US);
        UUID userUUID = UUID.randomUUID();
        String user = userUUID.toString();
        mockMvc.perform(get("/getUserLocationV2?userId=" + user))
                .andExpect(status().isOk());
    }
    @Test
    public void getUserLocationV2_forUUIDUnformated_errorIsReturn() throws Exception {
        //GIVEN : for a BAD UUID
        Locale.setDefault(Locale.US);
        String userUUID = "1234567890";
        //WHEN call Controller
        //THEN return is ko
        mockMvc.perform(get("/getUserLocationV2?userId=" + userUUID))
                .andExpect(status().isNotAcceptable());
    }
    @Test
    public void getAttractions_noData_OkIsReturn() throws Exception {
        //GIVEN :

        Locale.setDefault(Locale.US);

        //WHEN call Controller
        //THEN return is OK
        mockMvc.perform(get("/getAttractions"))
                .andExpect(status().isOk());
    }
}
