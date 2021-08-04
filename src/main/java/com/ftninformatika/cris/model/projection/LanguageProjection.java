package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.Founder;
import com.ftninformatika.cris.model.Language;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "LanguageProjection", types = {Language.class})
public interface LanguageProjection {

    Long getId();
    String getCode();
    String getName();

}