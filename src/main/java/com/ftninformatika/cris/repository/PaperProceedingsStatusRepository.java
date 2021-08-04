package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.PaperProceedingsStatus;
import com.ftninformatika.cris.model.projection.PaperProceedingsStatusProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = PaperProceedingsStatusProjection.class)
public interface PaperProceedingsStatusRepository extends PagingAndSortingRepository<PaperProceedingsStatus, Long> {

    @RestResource(path = "search", rel = "search")
    List<PaperProceedingsStatus> findByNameContainingAndDescriptionContainingAllIgnoreCase(
            @Param("name") String name,
            @Param("description") String description);
}
