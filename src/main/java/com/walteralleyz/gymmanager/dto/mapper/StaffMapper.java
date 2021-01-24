package com.walteralleyz.gymmanager.dto.mapper;

import com.walteralleyz.gymmanager.dto.request.StaffDTO;
import com.walteralleyz.gymmanager.entities.Staff;
import com.walteralleyz.gymmanager.exceptions.RoleNotFoundException;
import com.walteralleyz.gymmanager.services.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@AllArgsConstructor(onConstructor_ = @Autowired)
public class StaffMapper {
    private final RoleService roleService;

    public Staff toModel(StaffDTO staffDTO) {
        Staff staff = new Staff();

        staff.setId(staffDTO.getId());
        staff.setName(staffDTO.getName());
        staff.setEmail(staffDTO.getName());
        staff.setPassword(staffDTO.getPassword());
        staff.setEmail(staffDTO.getEmail());
        staff.setCreatedAt(staffDTO.getCreated());
        staff.setPhone(staffDTO.getPhone());

        try {
            staff.setRole(roleService.findById(staffDTO.getRoleId()));
        } catch (RoleNotFoundException s) {
            try {
                staff.setRole(roleService.findById(Long.parseLong("2")));
            } catch (RoleNotFoundException r) {
                System.out.println("Ocorreu algum erro no banco de dados.");
            }
        }

        return staff;
    }

    public StaffDTO toDTO(Staff staff) {
        StaffDTO staffDTO = new StaffDTO();

        staffDTO.setId(staff.getId());
        staffDTO.setName(staff.getName());
        staffDTO.setEmail(staff.getName());
        staffDTO.setPassword(staff.getPassword());
        staffDTO.setEmail(staff.getEmail());
        staffDTO.setCreated(staff.getCreatedAt());
        staffDTO.setPhone(staff.getPhone());
        staffDTO.setRoleId(staff.getRole().getId());
        staffDTO.setRole(staff.getRole());

        return staffDTO;
    }
}
