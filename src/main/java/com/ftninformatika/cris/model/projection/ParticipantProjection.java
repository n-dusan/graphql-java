package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.Participant;
import com.ftninformatika.cris.model.Person;
import com.ftninformatika.cris.model.Project;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "ParticipantProjection", types = {Participant.class})
public interface ParticipantProjection {

    Long getId();
    Integer getNumOrder();
    String getFirstName();
    String getLastName();
    String getMiddleName();
    String getEmail();
    String getAffiliations();
    Person getPerson();
    Project getProject();
}
