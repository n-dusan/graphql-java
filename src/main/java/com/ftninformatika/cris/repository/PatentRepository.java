package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.Patent;
import com.ftninformatika.cris.model.projection.PatentProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = PatentProjection.class)
public interface PatentRepository extends PagingAndSortingRepository<Patent, Long> {
}
