package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.Thesis;
import com.ftninformatika.cris.model.projection.ThesisProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = ThesisProjection.class)
public interface ThesisRepository extends PagingAndSortingRepository<Thesis, Long> {
}
