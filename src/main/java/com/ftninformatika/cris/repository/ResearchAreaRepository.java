package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.ResearchArea;
import com.ftninformatika.cris.model.projection.ResearchAreaProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = ResearchAreaProjection.class)
public interface ResearchAreaRepository extends PagingAndSortingRepository<ResearchArea, Long> {

    @RestResource(path = "search", rel = "search")
    List<ResearchArea> findByNameContainingAndDescriptionContainingAllIgnoreCase(
            @Param("name") String name,
            @Param("description") String description);

    @RestResource(path = "search2", rel = "search2")
    List<ResearchArea> findByNameContainingAndDescriptionContainingAndLanguageIdAllIgnoreCase(
            @Param("name") String name,
            @Param("description") String description,
            @Param("languageId") Long languageId);
}
