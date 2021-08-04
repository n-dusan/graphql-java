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
@Table(name = "monographOfPapers")
public class MonographOfPapers {

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

  private String editionTitle;

  private Integer editionNumber;

  private String editionPISSN;

  private String editionEISSN;

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

  private String dspaceRecordID;

  private String uri;

  private String year;

  private String scopusID;

  private String ecrisID;

  private String cobissID;

  private String creator;

  private String modifier;

  private LocalDateTime creationDate;

  private LocalDateTime lastModificationDate;

  private Integer recordStatus;

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="monographOfPaperStatus_id", referencedColumnName="id", nullable=true)
  public MonographOfPaperStatus monographOfPaperStatus;

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="monographOfPaperType_id", referencedColumnName="id", nullable=true)
  public MonographOfPaperType monographOfPaperType;

  @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy = "monographOfPapers")
  public Set<MonographEditors> monographOfPapersEditors;

  @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy = "monographOfPapers")
  public Set<PaperMonograph> paperMonographs;

}