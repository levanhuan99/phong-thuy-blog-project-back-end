package com.project.medium.repository;

import com.project.medium.model.SendMail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShareRepository extends JpaRepository<SendMail, Long> {
}
