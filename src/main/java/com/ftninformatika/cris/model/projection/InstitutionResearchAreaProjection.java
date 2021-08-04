package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.Institution;
import com.ftninformatika.cris.model.InstitutionResearchArea;
import com.ftninformatika.cris.model.ResearchArea;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "InstitutionResearchAreaProjection", types = {InstitutionResearchArea.class})
public interface InstitutionResearchAreaProjection {

    Long getId();
    String getNote();
    ResearchArea getResearchArea();
    Institution getInstitution();
}