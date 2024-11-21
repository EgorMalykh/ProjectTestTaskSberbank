package org.app.test.task.sber.repository;

import org.app.test.task.sber.entity.MobilePhone;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MobilePhoneRepositoryTest {

    @Autowired
    private MobilePhoneRepository mobilePhoneRepository;

    @Test
    @DisplayName("Тест на сохранение объекта")
    public void testSaveMobilePhone() {

        MobilePhone mobilePhone = new MobilePhone();
        mobilePhone.setCompany("Apple");
        mobilePhone.setModel("12 ProMax");
        mobilePhone.setPrice(135000D);

        MobilePhone savedMobilePhone = mobilePhoneRepository.save(mobilePhone);
        Assertions.assertNotNull(savedMobilePhone);
        Assertions.assertEquals("Apple", savedMobilePhone.getCompany());
    }

    @Test
    public void testGetMobilePhone() {
        MobilePhone mobilePhone = new MobilePhone();
        mobilePhone.setCompany("Apple");
        mobilePhone.setModel("12 ProMax");
        mobilePhone.setPrice(135000D);

        MobilePhone savedMobilePhone = mobilePhoneRepository.save(mobilePhone);
        MobilePhone gettingMobilePhone = mobilePhoneRepository.findById(savedMobilePhone.getId()).orElse(null);
        Assertions.assertNotNull(gettingMobilePhone);
        Assertions.assertEquals(savedMobilePhone.getId(), gettingMobilePhone.getId());
    }

    @Test
    public void testGetListMobilePhones() {
        MobilePhone mobilePhoneOne = new MobilePhone();
        mobilePhoneOne.setCompany("Honor");
        mobilePhoneOne.setModel("Stark 11");
        mobilePhoneOne.setPrice(23500D);

        MobilePhone mobilePhoneTwo = new MobilePhone();
        mobilePhoneTwo.setCompany("Huawei");
        mobilePhoneTwo.setModel("Blue min 3");
        mobilePhoneTwo.setPrice(33300D);

        mobilePhoneRepository.save(mobilePhoneOne);
        mobilePhoneRepository.save(mobilePhoneTwo);
        List<MobilePhone> phones = mobilePhoneRepository.findAll();
        Assertions.assertNotNull(phones);
        Assertions.assertEquals(2, phones.size());
    }

    @Test
    @DisplayName("Тест на обновление объекта")
    public void testUpdateMobilePhone() {
        MobilePhone mobilePhone = new MobilePhone();
        mobilePhone.setCompany("Honor");
        mobilePhone.setModel("Stark 11");
        mobilePhone.setPrice(23500D);

        MobilePhone savedMobilePhone = mobilePhoneRepository.save(mobilePhone);
        savedMobilePhone.setCompany("Nokia");
        mobilePhoneRepository.save(savedMobilePhone);
        MobilePhone updatedMobilePhone = mobilePhoneRepository.findById(savedMobilePhone.getId()).orElse(null);
        Assertions.assertNotNull(updatedMobilePhone);
        Assertions.assertEquals("Nokia", updatedMobilePhone.getCompany());
    }

    @Test
    @DisplayName("Тест на удаление объекта")
    public void testDeleteMobilePhone() {
        MobilePhone mobilePhone = new MobilePhone();
        mobilePhone.setCompany("Honor");
        mobilePhone.setModel("Stark 11");
        mobilePhone.setPrice(23500D);

        MobilePhone savedMobilePhone = mobilePhoneRepository.save(mobilePhone);
        mobilePhoneRepository.deleteById(savedMobilePhone.getId());
        MobilePhone deletedMobilePhone = mobilePhoneRepository.findById(savedMobilePhone.getId()).orElse(null);
        Assertions.assertNull(deletedMobilePhone);
    }
}
