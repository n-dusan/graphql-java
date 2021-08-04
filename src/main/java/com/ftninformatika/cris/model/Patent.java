package com.ftninformatika.cris.model;

import lombok.*;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import javax.persistence.*;
import java.awt.datatransfer.FlavorEvent;
import java.time.LocalDateTime;
import java.util.Set;

@RepositoryEventHandler
@ToString(of = {"id", "titleSrb"})
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patent")
public class Patent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titleSrb;

    private String titleEng;

    private String titleOth;

    private String number;

    private String keywordsSrb;

    private String keywordsEng;

    private String keywordsOth;

    private String abstractSrb;

    private String abstractEng;

    private String abstractOth;

    private String uri;

    private String dspaceRecordID;

    private String year;

    private String scopusID;

    private String cobissID;

    private String ecrisID;

    private String creator;

    private String modifier;

    private LocalDateTime creationDate;

    private LocalDateTime lastModificationDate;

    private Integer recordStatus;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="language_id", referencedColumnName="id", nullable=false)
    public Language language;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="patentStatus_id", referencedColumnName="id", nullable=false)
    public PatentStatus patentStatus;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="patentType_id", referencedColumnName="id", nullable=false)
    public PatentType patentType;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="publisher_id", referencedColumnName="id", nullable=false)
    public Publisher publisher;

    @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="patent")
    public Set<File> file;

    @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="patent")
    public Set<Acknowledgement> acknowledgement;

}