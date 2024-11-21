package org.app.test.task.sber.service;

import org.app.test.task.sber.dto.MobilePhoneDTO;
import org.app.test.task.sber.entity.MobilePhone;
import org.app.test.task.sber.repository.MobilePhoneRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;
import static org.mockito.Mockito.when;

public class MobilePhoneServiceTest {
    @InjectMocks
    private MobilePhoneCRUDService mobilePhoneCRUDService;

    @Mock
    private MobilePhoneRepository mobilePhoneRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindMobilePhoneById() {
        MobilePhone mobilePhone = new MobilePhone();
        mobilePhone.setCompany("Apple");
        mobilePhone.setModel("12 ProMax");
        mobilePhone.setPrice(135000D);

        when(mobilePhoneRepository.findById(1L)).thenReturn(Optional.of(mobilePhone));
        MobilePhoneDTO foundMobilePhoneDTO = mobilePhoneCRUDService.getById(1L);
        Assertions.assertEquals("Apple", foundMobilePhoneDTO.getCompany());
    }
}
