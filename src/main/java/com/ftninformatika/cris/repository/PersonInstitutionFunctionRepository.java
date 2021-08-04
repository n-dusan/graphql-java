package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.PersonInstitutionFunction;
import com.ftninformatika.cris.model.projection.PersonInstitutionFunctionProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = PersonInstitutionFunctionProjection.class)
public interface PersonInstitutionFunctionRepository extends PagingAndSortingRepository<PersonInstitutionFunction, Long> {

    @RestResource(path = "search", rel = "search")
    List<PersonInstitutionFunction> findByNameContainingAndDescriptionContainingAllIgnoreCase(
            @Param("name") String name,
            @Param("description") String description);
}
