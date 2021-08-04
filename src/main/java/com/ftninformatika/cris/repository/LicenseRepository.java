package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.License;
import com.ftninformatika.cris.model.projection.LicenseProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * Created by Alek on 7/24/2017.
 */
@RepositoryRestResource(excerptProjection = LicenseProjection.class)
public interface LicenseRepository extends PagingAndSortingRepository<License, Long> {

    @RestResource(path = "search", rel = "search")
    List<License> findByNameContainingAndDescriptionContainingAllIgnoreCase(
            @Param("name") String name,
            @Param("description") String description);

}
