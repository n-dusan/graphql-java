package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.InstitutionStatus;
import com.ftninformatika.cris.model.projection.InstitutionStatusProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * Created by Alek on 7/21/2017.
 */
@RepositoryRestResource(excerptProjection = InstitutionStatusProjection.class)
public interface InstitutionStatusRepository extends PagingAndSortingRepository<InstitutionStatus, Long> {

    @RestResource(path = "search", rel = "search")
    List<InstitutionStatus> findByNameContainingAndDescriptionContainingAllIgnoreCase(
            @Param("name") String name,
            @Param("description") String description);
}
