package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.Founder;
import com.ftninformatika.cris.model.Institution;
import com.ftninformatika.cris.model.InstitutionFounder;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDate;

@Projection(name = "InstitutionFounderProjection", types = {InstitutionFounder.class})
public interface InstitutionFounderProjection {

    Long getId();
    String getRescriptNumber();
    LocalDate getDate();
    Institution getInstitution();
    Founder getFounder();

}