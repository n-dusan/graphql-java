package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.Activity;
import com.ftninformatika.cris.model.projection.ActivitiyProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * Created by Alek on 7/18/2017.
 */
@RepositoryRestResource(excerptProjection = ActivitiyProjection.class)
public interface ActivityRepository extends PagingAndSortingRepository<Activity, Long>{

    @RestResource(path = "search", rel = "search")
    List<Activity> findByCodeContainingAndNameContainingAndDescriptionContainingAllIgnoreCase(
            @Param("code") String code,
            @Param("name") String name,
            @Param("description") String description);

}