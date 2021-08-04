package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.PaperProceedingsType;
import com.ftninformatika.cris.model.projection.PaperProceedingsTypeProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = PaperProceedingsTypeProjection.class)
public interface PaperProceedingsTypeRepository extends PagingAndSortingRepository<PaperProceedingsType, Long> {

    @RestResource(path = "search", rel = "search")
    List<PaperProceedingsType> findByNameContainingAndDescriptionContainingAllIgnoreCase(
            @Param("name") String name,
            @Param("description") String description);
}
