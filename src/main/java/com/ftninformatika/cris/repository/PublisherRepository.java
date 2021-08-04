package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.Publisher;
import com.ftninformatika.cris.model.projection.PublisherProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = PublisherProjection.class)
public interface PublisherRepository extends PagingAndSortingRepository<Publisher, Long> {

    @RestResource(path = "search", rel = "search")
    List<Publisher> findByNameSrbContainingAndNameEngContainingAndNameOthContainingAndAddressContainingAndUrlContainingAndCountryContainingAllIgnoreCase(
            @Param("nameSrb") String nameSrb,
            @Param("nameEng") String nameEng,
            @Param("nameOth") String nameOth,
            @Param("address") String address,
            @Param("url") String url,
            @Param("country") String country);

    @RestResource(path = "search2", rel = "search2")
    List<Publisher> findByNameSrbContainingAndNameEngContainingAndNameOthContainingAndAddressContainingAndUrlContainingAndCountryContainingAndLanguageIdAllIgnoreCase(
            @Param("nameSrb") String nameSrb,
            @Param("nameEng") String nameEng,
            @Param("nameOth") String nameOth,
            @Param("address") String address,
            @Param("url") String url,
            @Param("country") String country,
            @Param("languageId") Long languageId);

}
