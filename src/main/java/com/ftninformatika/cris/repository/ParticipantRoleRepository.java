package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.ParticipantRole;
import com.ftninformatika.cris.model.projection.ParticipantRoleProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = ParticipantRoleProjection.class)
public interface ParticipantRoleRepository extends PagingAndSortingRepository<ParticipantRole, Long> {

    @RestResource(path = "search", rel = "search")
    List<ParticipantRole> findByNameContainingAndDescriptionContainingAllIgnoreCase(
            @Param("name") String name,
            @Param("description") String description);

    @RestResource(path = "search2", rel = "search2")
    List<ParticipantRole> findByNameContainingAndDescriptionContainingAndParticipantIdAllIgnoreCase(
            @Param("name") String name,
            @Param("description") String description,
            @Param("participantId") Long languageId);
}