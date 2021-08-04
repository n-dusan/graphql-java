package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.InstitutionType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * Created by Alek on 7/24/2017.
 */
@RepositoryRestResource(excerptProjection = InstitutionType.class)
public interface InstitutionTypeRepository extends PagingAndSortingRepository<InstitutionType, Long> {

    @RestResource(path = "search", rel = "search")
    List<InstitutionType> findByNameContainingAndDescriptionContainingAllIgnoreCase(
            @Param("name") String name,
            @Param("description") String description);
}
