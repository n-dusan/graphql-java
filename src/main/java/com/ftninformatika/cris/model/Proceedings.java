package com.ftninformatika.cris.model;

import lombok.*;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@RepositoryEventHandler
@ToString(of = {"id", "titleSrb", "subtitleSrb"})
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "proceedings")
public class Proceedings {

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

    private String isbn;

    private Integer numberOfPages;

    private String dimension;

    @Column(length = 500)
    private String editionTitle;

    private Integer editionNumber;

    private String nameAbbreviationSrb;

    private String nameAbbreviationEng;

    private String nameAbbreviationOth;

    private String keywordsSrb;

    private String keywordsEng;

    private String keywordsOth;

    private String note;

    private String uri;

    private String scopusID;

    private String ecrisID;

    private String cobissID;

    private String year;

    private String creator;

    private String modifier;

    private LocalDateTime creationDate;

    private LocalDateTime lastModificationDate;

    private Integer recordStatus;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="conference_id", referencedColumnName="id", nullable=true)
    private Conference conference;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="language_id", referencedColumnName="id", nullable=true)
    public Language language;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="publisher_id", referencedColumnName="id", nullable=true)
    public Publisher publisher;

    @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="proceedings")
    public Set<PaperProceedings> paperProceedings;

    @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="proceedings")
    public Set<ProceedingsEditors> proceedingsEditors;

}