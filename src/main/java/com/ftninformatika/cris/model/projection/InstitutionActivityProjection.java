package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.Activity;
import com.ftninformatika.cris.model.Institution;
import com.ftninformatika.cris.model.InstitutionActivity;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "InstitutionActivityProjection", types = {InstitutionActivity.class})
public interface InstitutionActivityProjection {

    Long getId();
    String getNote();
    Institution getInstitution();
    Activity getActivity();
}