package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.JournalStatus;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "JournalStatusProjection", types = {JournalStatus.class})
public interface JournalStatusProjection {

    Long getId();
    String getName();
    String getDescription();
}
