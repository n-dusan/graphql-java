package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.PaperProceedings;
import com.ftninformatika.cris.model.projection.PaperProceedingsProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(excerptProjection = PaperProceedingsProjection.class)
public interface PaperProceedingsRepository extends PagingAndSortingRepository<PaperProceedings, Long> {

    PaperProceedings findByScopusID(@Param("scopusID") String scopusID);

    @RestResource(path = "count", rel = "count")
    Integer countByIdNotNull();
}
