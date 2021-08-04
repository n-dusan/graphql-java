package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.Category;
import com.ftninformatika.cris.model.projection.CategoryProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * Created by Alek on 7/21/2017.
 */
@RepositoryRestResource(excerptProjection = CategoryProjection.class)
public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {

    @RestResource(path = "search", rel = "search")
    List<Category> findByNameContainingAndDescriptionContainingAllIgnoreCase(
            @Param("name") String name,
            @Param("description") String description);

}
