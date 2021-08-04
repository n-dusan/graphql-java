package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.Language;
import com.ftninformatika.cris.model.Publisher;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "PublisherProjection", types = {Publisher.class})
public interface PublisherProjection {

    Long getId();
    String getNameSrb();
    String getNameEng();
    String getNameOth();
    String getAddress();
    String getUrl();
    String getCountry();
    Language getLanguage();
}