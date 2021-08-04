package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.Person;
import com.ftninformatika.cris.model.Proceedings;
import com.ftninformatika.cris.model.ProceedingsEditors;
import org.springframework.data.rest.core.config.Projection;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Projection(name = "ProceedingsEditorsProjection", types = {ProceedingsEditors.class})
public interface ProceedingsEditorsProjection {

    Long getId();
    LocalDate getStartDate();
    LocalDate getEndDate();
    String getFirstName();
    String getLastName();
    String getMiddleName();
    String getEmail();
    String getAffiliations();
    Person getPerson();
    Proceedings getProceedings();
}