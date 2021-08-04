package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.Acknowledgement;
import com.ftninformatika.cris.model.projection.AcknowledgementProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = AcknowledgementProjection.class)
public interface AcknowledgementRepository extends PagingAndSortingRepository<Acknowledgement, Long> {
}
