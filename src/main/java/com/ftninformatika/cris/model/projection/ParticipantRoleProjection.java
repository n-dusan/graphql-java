package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.Participant;
import com.ftninformatika.cris.model.ParticipantRole;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "ParticipantRoleProjection", types = {ParticipantRole.class})
public interface ParticipantRoleProjection {

    Long getId();
    String getName();
    String getDescription();
    Participant getParticipant();
}
