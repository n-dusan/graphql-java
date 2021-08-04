package com.ftninformatika.cris.model;

import lombok.*;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Set;

@RepositoryEventHandler
@ToString(of = {"id", "titleSrb", "subtitleSrb"})
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "paperProceedings")
public class PaperProceedings {

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

    private String startPage;

    private String endPage;

    private Integer numberOfPages;

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

    private String uri;

    @Column(unique = true)
    private String dspaceRecordID;

    @Column(unique = true)
    private String scopusID;

    @Column(unique = true)
    private String ecrisID;

    @Column(unique = true)
    private String cobissID;

    private String creator;

    private String modifier;

    private LocalDateTime creationDate;

    private LocalDateTime lastModificationDate;

    private Integer recordStatus;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="language_id", referencedColumnName="id", nullable=true)
    public Language language;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="paperProceedingsType_id", referencedColumnName="id", nullable=true)
    public PaperProceedingsType paperProceedingsType;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="paperProceedingsStatus_id", referencedColumnName="id", nullable=true)
    public PaperProceedingsStatus paperProceedingsStatus;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="proceedings_id", referencedColumnName="id", nullable=true)
    public Proceedings proceedings;

    @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy = "paperProceedings")
    public Set<File> file;

    @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy = "paperProceedings")
    public Set<Acknowledgement> acknowledgement;

    @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="person")
    public Set<PaperProceedingsAuthors> paperProceedingsAuthors;

}