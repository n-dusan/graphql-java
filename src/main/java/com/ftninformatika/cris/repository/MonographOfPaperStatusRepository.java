package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.MonographOfPaperStatus;
import com.ftninformatika.cris.model.projection.MonographOfPaperStatusProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * Created by Alek on 7/25/2017.
 */
@RepositoryRestResource(excerptProjection = MonographOfPaperStatusProjection.class)
public interface MonographOfPaperStatusRepository extends PagingAndSortingRepository<MonographOfPaperStatus, Long> {

    @RestResource(path = "search", rel = "search")
    List<MonographOfPaperStatus> findByNameContainingAndDescriptionContainingAllIgnoreCase(
            @Param("name") String name,
            @Param("description") String description);
}
