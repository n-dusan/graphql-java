package com.ftninformatika.cris.model;

import lombok.*;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@RepositoryEventHandler
@ToString(of = {"id", "nameSrb", "descriptionSrb"})
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class Product {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String nameSrb;

   private String nameEng;

   private String nameOth;

   private String internalNumber;

   private String keywordsSrb;

   private String keywordsEng;

   private String keywordsOth;

   private String descriptionSrb;

   private String desriptionEng;

   private String descriptionOth;

   private String uri;

   private String dspaceRecordID;

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
   @JoinColumn(name="language_id", referencedColumnName="id", nullable=false)
   public Language language;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="productStatus_id", referencedColumnName="id", nullable=false)
   public ProductStatus productStatus;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="productType_id", referencedColumnName="id", nullable=false)
   public ProductType productType;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="publisher_id", referencedColumnName="id", nullable=false)
   public Publisher publisher;

   @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="product")
   public Set<File> file;

   @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="product")
   public Set<Acknowledgement> acknowledgement;
   

}