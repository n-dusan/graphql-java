package com.ftninformatika.cris.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@ToString(of = {"id", "dspaceFileID", "note", "doi"})
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "file")
public class File {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String dspaceFileID;

   private String note;

   private String doi;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="license_id", referencedColumnName="id", nullable=false)
   public License license;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="institution_id", referencedColumnName="id", nullable=false)
   public Institution institution;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="paperJournal_id", referencedColumnName="id", nullable=false)
   public PaperJournal paperJournal;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="paperMonograph_id", referencedColumnName="id", nullable=false)
   public PaperMonograph paperMonograph;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="paperProceedings_id", referencedColumnName="id", nullable=false)
   public PaperProceedings paperProceedings;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name="patent_id", referencedColumnName="id", nullable=false)
   public Patent patent;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="person_id", referencedColumnName="id", nullable=false)
   public Person person;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="product_id", referencedColumnName="id", nullable=false)
   public Product product;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="project_id", referencedColumnName="id", nullable=false)
   public Project project;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="thesis_id", referencedColumnName="id", nullable=false)
   public Thesis thesis;

}