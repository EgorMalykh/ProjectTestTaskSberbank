package org.app.test.task.sber.controller;

import org.app.test.task.sber.dto.MobilePhoneDTO;
import org.app.test.task.sber.service.MobilePhoneCRUDService;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping("/api/phones")
public class MobilePhoneController {

    private final MobilePhoneCRUDService mobilePhoneCRUDService;

    public MobilePhoneController(MobilePhoneCRUDService mobilePhoneCRUDService) {
        this.mobilePhoneCRUDService = mobilePhoneCRUDService;
    }

    @GetMapping("/{id}")
    public MobilePhoneDTO getMobilePhoneById(@PathVariable("id") Long id) {
        return mobilePhoneCRUDService.getById(id);
    }

    @GetMapping
    public Collection<MobilePhoneDTO> getAllMobilePhones() {
        return mobilePhoneCRUDService.getAll();
    }
    @PostMapping
    public void createMobilePhone(@RequestBody MobilePhoneDTO mobilePhoneDTO) {
        mobilePhoneCRUDService.create(mobilePhoneDTO);
    }
    @PutMapping("/{id}")
    public void updateMobilePhone(@PathVariable("id") Long id, @RequestBody MobilePhoneDTO mobilePhoneDTO) {
        mobilePhoneDTO.setId(id);
        mobilePhoneCRUDService.update(mobilePhoneDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteMobilePhone(@PathVariable("id") Long id) {
        mobilePhoneCRUDService.delete(id);
    }
}
