package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.PartnerRole;
import com.ftninformatika.cris.model.projection.PartnerRoleProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = PartnerRoleProjection.class)
public interface PartnerRoleRepository extends PagingAndSortingRepository<PartnerRole, Long>{

    @RestResource(path = "search", rel = "search")
    List<PartnerRole> findByNameContainingAndDescriptionContainingAllIgnoreCase(
            @Param("name") String name,
            @Param("description") String description);

    @RestResource(path = "search1", rel = "search1")
    List<PartnerRole> findByNameContainingAndDescriptionContainingAndPartnerIdAllIgnoreCase(
            @Param("name") String name,
            @Param("description") String description,
            @Param("partnerId") Long partnerId);
}
