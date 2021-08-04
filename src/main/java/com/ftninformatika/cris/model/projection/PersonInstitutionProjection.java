package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.*;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDate;

@Projection(name = "PersonInstitutionProjection", types = {PersonInstitution.class})
public interface PersonInstitutionProjection {

    Long getId();
    LocalDate getStartDate();
    LocalDate getEndDate();
    String getDescription();
    String getResearchArea();
    Integer getPercentage();
    PersonInstitutionPosition getPersonInstitutionPosition();
    Person getPerson();
    Institution getInstitution();
    PersonInstitutionFunction getPersonInstitutionFunction();
    PersonInstitutionStatus getPersonInstitutionStatus();
}