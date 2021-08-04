package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.PersonInstitutionStatus;
import com.ftninformatika.cris.model.projection.PersonInstitutionStatusProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = PersonInstitutionStatusProjection.class)
public interface PersonInstitutionStatusRepository extends PagingAndSortingRepository<PersonInstitutionStatus, Long> {

    @RestResource(path = "search", rel = "search")
    List<PersonInstitutionStatus> findByNameContainingAndDescriptionContainingAllIgnoreCase(
            @Param("name") String name,
            @Param("description") String description);
}
