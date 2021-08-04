package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.File;
import com.ftninformatika.cris.model.projection.FileProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = FileProjection.class)
public interface FileRepository extends PagingAndSortingRepository<File, Long> {
}
