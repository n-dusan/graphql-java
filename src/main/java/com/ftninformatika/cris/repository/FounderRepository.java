package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.Founder;
import com.ftninformatika.cris.model.projection.FounderProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = FounderProjection.class)
public interface FounderRepository extends PagingAndSortingRepository<Founder, Long> {

    @RestResource(path = "search", rel = "search")
    List<Founder> findByNameSrbContainingAndNameEngContainingAndNameOthContainingAndDescriptionContainingAndAddressContainingAndNoteContainingAllIgnoreCase(
            @Param("nameSrb") String nameSrb,
            @Param("nameEng") String nameEng,
            @Param("nameOth") String nameOth,
            @Param("description") String description,
            @Param("address") String address,
            @Param("note") String note);

    @RestResource(path = "search2", rel = "search2")
    List<Founder> findByNameSrbContainingAndNameEngContainingAndNameOthContainingAndDescriptionContainingAndAddressContainingAndNoteContainingAndLanguageIdAllIgnoreCase(
            @Param("nameSrb") String nameSrb,
            @Param("nameEng") String nameEng,
            @Param("nameOth") String nameOth,
            @Param("description") String description,
            @Param("address") String address,
            @Param("note") String note,
            @Param("languageId") Long languageId);

}