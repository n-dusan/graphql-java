package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.PersonInstitution;
import com.ftninformatika.cris.model.projection.PersonInstitutionProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = PersonInstitutionProjection.class)
public interface PersonInstitutionRepository extends PagingAndSortingRepository<PersonInstitution, Long> {
}
