package org.app.test.task.sber.controller;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.app.test.task.sber.dto.MobilePhoneDTO;
import org.app.test.task.sber.service.MobilePhoneCRUDService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
public class MobilePhoneControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MobilePhoneCRUDService mobilePhoneCRUDService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetMobilePhoneById() throws Exception {
        MobilePhoneDTO mobilePhone = new MobilePhoneDTO();
        mobilePhone.setCompany("Apple");
        mobilePhone.setModel("12 ProMax");
        mobilePhone.setPrice(135000D);

        when(mobilePhoneCRUDService.getById(1L)).thenReturn(mobilePhone);

        mockMvc.perform(get("/api/phones/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.company").value("Apple"))
                .andExpect(jsonPath("$.model").value("12 ProMax"))
                .andExpect(jsonPath("$.price").value(135000D));
    }
}
