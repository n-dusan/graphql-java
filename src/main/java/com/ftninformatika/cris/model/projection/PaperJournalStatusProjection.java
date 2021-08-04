package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.PaperJournalStatus;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "PaperJournalStatusProjection", types = {PaperJournalStatus.class})
public interface PaperJournalStatusProjection {

    Long getId();
    String getName();
    String getDescription();
}
