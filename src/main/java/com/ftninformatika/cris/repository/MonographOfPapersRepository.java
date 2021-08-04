package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.MonographOfPapers;
import com.ftninformatika.cris.model.projection.MonographOfPapersProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(excerptProjection = MonographOfPapersProjection.class)
public interface MonographOfPapersRepository extends PagingAndSortingRepository<MonographOfPapers, Long>{

    @RestResource(path = "count", rel = "count")
    Integer countByIdNotNull();
}
