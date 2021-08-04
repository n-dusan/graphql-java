package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.Founder;
import com.ftninformatika.cris.model.Language;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "FounderProjection", types = {Founder.class})
public interface FounderProjection {

    Long getId();
    String getNameSrb();
    String getNameEng();
    String getNameOth();
    String getDescription();
    String getAddress();
    String getNote();
    Language getLanguage();

}