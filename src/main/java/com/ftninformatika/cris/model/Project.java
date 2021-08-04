package com.ftninformatika.cris.model;

import lombok.*;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@RepositoryEventHandler
@ToString(of = {"id", "titleSrb"})
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "project")
public class Project {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   
   private String titleSrb;
   
   private String titleEng;
   
   private String titleOth;
   
   private String abstractSrb;
   
   private String abstractEng;
   
   private String abstractOth;
   
   private String keywordsSrb;
   
   private String keywordsEng;
   
   private String keywordsOth;
   
   private LocalDate startDate;
   
   private LocalDate endDate;
   
   private String acronym;
   
   private String uri;
   
   private String dspaceRecordID;
   
   private String scopusID;
   
   private String ecrisID;
   
   private String cobissID;
   
   private String mntrn;
   
   private String note;
   
   private String creator;
   
   private String modifier;
   
   private LocalDateTime creationDate;
   
   private LocalDateTime lastModificationDate;
   
   private Integer recordStatus;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="projectStatus_id", referencedColumnName="id", nullable=false)
   public ProjectStatus projectStatus;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="projectType_id", referencedColumnName="id", nullable=false)
   public ProjectType projectType;

   @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="project")
   public Set<File> file;

   @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="project")
   public Set<Partner> partner;

   @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="project")
   public Set<Participant> participant;

}