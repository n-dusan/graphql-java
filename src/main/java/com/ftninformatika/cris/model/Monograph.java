package com.ftninformatika.cris.model;

import lombok.*;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@RepositoryEventHandler
@ToString(of = {"id", "titleSrb", "subtitleSrb"})
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "monograph")
public class Monograph {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500)
    private String titleSrb;

    @Column(length = 500)
    private String titleEng;

    @Column(length = 500)
    private String titleOth;

    private String subtitleSrb;

    private String subtitleEng;

    private String subtitleOth;

    private String volumeCode;

    private String volumeTitle;

    private String isbn;

    private Integer numberOfPages;

    private String editionTitle;

    private Integer editionNumber;

    private String editionEISSN;

    private String editionPISSN;

    private Boolean translated;

    private String note;

    @Column(length = 800)
    private String keywordsSrb;

    @Column(length = 800)
    private String keywordsEng;

    @Column(length = 800)
    private String keywordsOth;

    @Column(length = 4500)
    private String abstractSrb;

    @Column(length = 4500)
    private String abstractEng;

    @Column(length = 4500)
    private String abstractOth;

    private String scopusID;

    private String dspaceRecordID;

    private String cobissID;

    private String ecrisID;

    private String uri;

    private String year;

    private String creator;

    private String modifier;

    private LocalDateTime creationDate;

    private LocalDateTime lastModificationDate;

    private Integer recordStatus;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="language_id", referencedColumnName="id", nullable=false)
    public Language language;

}