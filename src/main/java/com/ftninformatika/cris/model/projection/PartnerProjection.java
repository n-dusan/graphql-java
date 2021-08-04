package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.Institution;
import com.ftninformatika.cris.model.Partner;
import com.ftninformatika.cris.model.Project;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "PartnerProjection", types = {Partner.class})
public interface PartnerProjection {

    Long getId();
    Integer getNumOrder();
    Institution getInstitution();
    Project getProject();
}
