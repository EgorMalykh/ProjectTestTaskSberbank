package org.app.test.task.sber.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class MobilePhoneDTO {
    private Long id;
    private String company;
    private String model;
    private Double price;
    private LocalDateTime dateTimeRelease;
}
