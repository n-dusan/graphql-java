package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.ThesisType;
import com.ftninformatika.cris.model.projection.ThesisTypeProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * Created by Alek on 7/25/2017.
 */
@RepositoryRestResource(excerptProjection = ThesisTypeProjection.class)
public interface ThesisTypeRepository extends PagingAndSortingRepository<ThesisType, Long> {

    @RestResource(path = "search", rel = "search")
    List<ThesisType> findByNameContainingAndDescriptionContainingAllIgnoreCase(
            @Param("name") String name,
            @Param("description") String description);
}
