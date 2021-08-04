package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.MonographOfPaperType;
import com.ftninformatika.cris.model.projection.MonographOfPaperTypeProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * Created by Alek on 7/25/2017.
 */
@RepositoryRestResource(excerptProjection = MonographOfPaperTypeProjection.class)
public interface MonographOfPaperTypeRepository extends PagingAndSortingRepository<MonographOfPaperType, Long> {

    @RestResource(path = "search", rel = "search")
    List<MonographOfPaperType> findByNameContainingAndDescriptionContainingAllIgnoreCase(
            @Param("name") String name,
            @Param("description") String description);
}
