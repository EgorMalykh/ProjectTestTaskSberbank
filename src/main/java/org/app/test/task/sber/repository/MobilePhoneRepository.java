package org.app.test.task.sber.repository;

import org.app.test.task.sber.entity.MobilePhone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobilePhoneRepository extends JpaRepository<MobilePhone, Long> {
}
