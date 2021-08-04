package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.Commission;
import com.ftninformatika.cris.model.Person;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "CommissionProjection", types = {Commission.class})
public interface CommissionProjection {

    Long getId();
    Integer getOrdNum();
    Person getPerson();
}