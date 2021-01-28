package com.walteralleyz.gymmanager.services;

import com.walteralleyz.gymmanager.dto.mapper.StaffMapper;
import com.walteralleyz.gymmanager.dto.request.StaffDTO;
import com.walteralleyz.gymmanager.entities.Staff;
import com.walteralleyz.gymmanager.exceptions.StaffNotFoundException;
import com.walteralleyz.gymmanager.repositories.StaffRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StaffService {
    @Autowired
    private final StaffRepository staffRepository;

    @Autowired
    private final StaffMapper staffMapper;

    public String create(StaffDTO staffDTO) {
        Staff staff = staffMapper.toModel(staffDTO);
        staff.setPassword(encoder().encode(staff.getPassword()));
        staffRepository.save(staff);

        return "Funcionario salvo com sucesso!";
    }

    public List<StaffDTO> findAll() {
        return staffRepository.findAll().stream()
            .map(staffMapper::toDTO)
            .collect(Collectors.toList());
    }

    public StaffDTO findById(Long id) throws StaffNotFoundException {
        return staffMapper.toDTO(staffRepository.findById(id)
            .orElseThrow(() -> new StaffNotFoundException(id)));
    }

    public String update(Long id, StaffDTO staffDTO) throws StaffNotFoundException {
        staffRepository.findById(id)
            .orElseThrow(() -> new StaffNotFoundException(id));

        Staff staff = staffMapper.toModel(staffDTO);
        staffRepository.save(staff);

        return "Funcionario atualizado.";
    }

    public String delete(Long id) throws StaffNotFoundException {
        staffRepository.findById(id)
            .orElseThrow(() -> new StaffNotFoundException(id));

        staffRepository.deleteById(id);

        return "Funcionario apagado.";
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
