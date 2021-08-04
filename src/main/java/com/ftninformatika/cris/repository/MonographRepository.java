package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.Monograph;
import com.ftninformatika.cris.model.projection.MonographProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Created by Alek on 7/17/2017.
 */
@RepositoryRestResource(excerptProjection = MonographProjection.class)
public interface MonographRepository extends PagingAndSortingRepository<Monograph, Long>{

    Monograph findByScopusID(@Param("scopusID") String scopusID);

    @RestResource(path = "count", rel = "count")
    Integer countByIdNotNull();
}
