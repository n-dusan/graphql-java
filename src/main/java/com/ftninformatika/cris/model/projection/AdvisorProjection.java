package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.Advisor;
import com.ftninformatika.cris.model.Person;
import com.ftninformatika.cris.model.Thesis;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "AdvisorProjection", types = {Advisor.class})
public interface AdvisorProjection {

    Long getId();
    Integer getNumOrder();
    Person getPerson();
    Thesis getThesis();
}
