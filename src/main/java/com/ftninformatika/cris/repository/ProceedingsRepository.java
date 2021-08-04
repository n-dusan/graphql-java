package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.Proceedings;
import com.ftninformatika.cris.model.projection.ProceedingsProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(excerptProjection = ProceedingsProjection.class)
public interface ProceedingsRepository extends PagingAndSortingRepository<Proceedings, Long> {

    @RestResource(path = "count", rel = "count")
    Integer countByIdNotNull();
}
