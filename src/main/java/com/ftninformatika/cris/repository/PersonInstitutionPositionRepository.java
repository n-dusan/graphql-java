package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.PersonInstitutionPosition;
import com.ftninformatika.cris.model.projection.PersonInstitutionPositionProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = PersonInstitutionPositionProjection.class)
public interface PersonInstitutionPositionRepository extends PagingAndSortingRepository<PersonInstitutionPosition, Long>{

    @RestResource(path = "search", rel = "search")
    List<PersonInstitutionPosition> findByNameContainingAndDescriptionContainingAllIgnoreCase(
            @Param("name") String name,
            @Param("description") String description);
}
