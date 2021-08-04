package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.Category;
import com.ftninformatika.cris.model.Person;
import com.ftninformatika.cris.model.PersonCategory;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDate;

@Projection(name = "PersonCategoryProjection", types = {PersonCategory.class})
public interface PersonCategoryProjection {

    Long getId();
    LocalDate getStartDate();
    LocalDate getEndDate();
    Category getCategory();
    Person getPerson();
}
