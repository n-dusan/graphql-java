package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.PaperMonograph;
import com.ftninformatika.cris.model.projection.PaperMonographProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(excerptProjection = PaperMonographProjection.class)
public interface PaperMonographRepository extends PagingAndSortingRepository<PaperMonograph, Long> {

    PaperMonograph findByScopusID(@Param("scopusID") String scopusID);

    @RestResource(path = "count", rel = "count")
    Integer countByIdNotNull();
}
