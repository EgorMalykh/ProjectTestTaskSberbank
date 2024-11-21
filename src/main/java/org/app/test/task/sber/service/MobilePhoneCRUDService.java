package org.app.test.task.sber.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.app.test.task.sber.dto.MobilePhoneDTO;
import org.app.test.task.sber.entity.MobilePhone;
import org.app.test.task.sber.repository.MobilePhoneRepository;
import org.springframework.stereotype.Service;
import java.util.Collection;

@AllArgsConstructor
@Service
@Slf4j
public class MobilePhoneCRUDService {

    private final MobilePhoneRepository mobilePhoneRepository;


    public MobilePhoneDTO getById(Long id) {
        log.info("Mobile phone by id: {}", id);
        return mapToDTO(mobilePhoneRepository.findById(id).orElseThrow());
    }

    public Collection<MobilePhoneDTO> getAll() {
        log.info("List all the mobile phones");
        return mobilePhoneRepository.findAll()
                .stream()
                .map(MobilePhoneCRUDService::mapToDTO)
                .toList();
    }

    public void create(MobilePhoneDTO mobilePhoneDTO) {
        log.info("Successfully created a mobile phone");
        mapToDTO(mobilePhoneRepository.save(mapToEntity(mobilePhoneDTO)));
    }

    public void update(MobilePhoneDTO mobilePhoneDTO) {
        log.info("Successfully updated a mobile phone");
        mapToDTO(mobilePhoneRepository.save(mapToEntity(mobilePhoneDTO)));
    }

    public void delete(Long id) {
        log.info("Successfully deleted a mobile phone");
        mobilePhoneRepository.deleteById(id);
    }

    public static MobilePhone mapToEntity(MobilePhoneDTO mobilePhoneDTO) {
        MobilePhone mobilePhone = new MobilePhone();
        mobilePhone.setId(mobilePhoneDTO.getId());
        mobilePhone.setCompany(mobilePhoneDTO.getCompany());
        mobilePhone.setModel(mobilePhoneDTO.getModel());
        mobilePhone.setPrice(mobilePhoneDTO.getPrice());
        mobilePhone.setDateTimeRelease(mobilePhoneDTO.getDateTimeRelease());
        return mobilePhone;
    }

    public static MobilePhoneDTO mapToDTO(MobilePhone mobilePhone) {
        MobilePhoneDTO mobilePhoneDTO = new MobilePhoneDTO();
        mobilePhoneDTO.setId(mobilePhone.getId());
        mobilePhoneDTO.setCompany(mobilePhone.getCompany());
        mobilePhoneDTO.setModel(mobilePhone.getModel());
        mobilePhoneDTO.setPrice(mobilePhone.getPrice());
        mobilePhoneDTO.setDateTimeRelease(mobilePhone.getDateTimeRelease());
        return mobilePhoneDTO;
    }
}
