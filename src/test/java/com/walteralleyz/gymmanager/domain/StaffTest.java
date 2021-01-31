package com.walteralleyz.gymmanager.domain;

import com.walteralleyz.gymmanager.dto.request.StaffDTO;
import com.walteralleyz.gymmanager.services.StaffService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Staff test")
public class StaffTest {
    @Autowired
    private StaffService staffService;

    @Test
    @DisplayName("Should Return one Staff")
    public void shouldReturnOneStaff() throws Exception {
        StaffDTO staffDTO = staffService.findById(Long.parseLong("69"));

        Assertions.assertNotNull(staffDTO);
    }


    @Test
    @DisplayName("Should create a staff")
    public void shouldCreateAStaff() {
        StaffDTO dummy = new StaffDTO();
        dummy.setUsername("another@staff.com");
        dummy.setPassword("password");
        dummy.setRoleId(Long.parseLong("1"));

        String response = staffService.create(dummy);

        Assertions.assertEquals(response, "Funcionario salvo com sucesso!");
    }
}
