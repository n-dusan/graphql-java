package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.Institution;
import com.ftninformatika.cris.model.projection.InstitutionProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(excerptProjection = InstitutionProjection.class)
public interface InstitutionRepository extends PagingAndSortingRepository<Institution, Long> {

    @RestResource(path = "count", rel = "count")
    Integer countByIdNotNull();

}

/*
path = "people" changed the value in href from /persons to /people
rel = "people" changed the name of that link from persons to people
*/