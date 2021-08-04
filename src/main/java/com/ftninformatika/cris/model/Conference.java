package com.ftninformatika.cris.model;

import lombok.*;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@RepositoryEventHandler
@ToString(of = {"id", "nameSrb"})
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "conference")
public class Conference {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String nameSrb;

   private String nameEng;

   private String nameOth;

   private String place;

   private String year;

   private String period;

   private String number;

   private String state;

   private String fee;

   private String description;

   private String descriptionEng;

   private String descriptionOth;

   private String keywords;

   private String keywordsEng;

   private String keywordsOth;

   private String uri;

   private String scopusID;

   private String ecrisID;

   private String cobissID;

   private String creator;

   private String modifier;

   private LocalDateTime creationDate;

   private LocalDateTime lastModificationDate;

   private Integer recordStatus;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="language_id", referencedColumnName="id", nullable=false)
   public Language language;

   @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="conference")
   Set<Proceedings> proceedings;
   


}