package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.PersonType;
import com.ftninformatika.cris.model.projection.PersonTypeProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = PersonTypeProjection.class)
public interface PersonTypeRepository extends PagingAndSortingRepository<PersonType, Long> {

    @RestResource(path = "search", rel = "search")
    List<PersonType> findByNameContainingAndDescriptionContainingAllIgnoreCase(
            @Param("name") String name,
            @Param("description") String description);
}
