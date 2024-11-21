package org.app.test.task.sber.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "mobile_phones")
public class MobilePhone {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "company")
    private String company;
    @Column(name = "model")
    private String model;
    @Column(name = "price")
    private Double price;
    @Column(name = "date_release")
    @CreationTimestamp
    private LocalDateTime dateTimeRelease;
}
