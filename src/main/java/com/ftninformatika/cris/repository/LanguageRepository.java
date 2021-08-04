package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.Language;
import com.ftninformatika.cris.model.projection.LanguageProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = LanguageProjection.class)
public interface LanguageRepository extends PagingAndSortingRepository<Language, Long> {


    @RestResource(path = "search", rel = "search")
    List<Language> findByCodeContainingAndNameContainingAllIgnoreCase(
            @Param("code") String code,
            @Param("name") String name);

    @RestResource(path = "count", rel = "count")
    Integer countByIdNotNull();


}
