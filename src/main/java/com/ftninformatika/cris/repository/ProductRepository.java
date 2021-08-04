package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.Product;
import com.ftninformatika.cris.model.projection.ProductProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = ProductProjection.class)
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
}
