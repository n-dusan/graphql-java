package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.PaperJournalType;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "PaperJournalTypeProjection", types = {PaperJournalType.class})
public interface PaperJournalTypeProjection {

    Long getId();
    String getName();
    String getDescription();
}
