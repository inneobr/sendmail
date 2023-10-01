package org.inneo.mail.repository;

import java.util.UUID;
import org.inneo.mail.model.Mail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRep extends JpaRepository<Mail, UUID>{

}
