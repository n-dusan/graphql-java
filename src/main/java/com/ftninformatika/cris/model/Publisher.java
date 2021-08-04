package com.ftninformatika.cris.model;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@ToString(of = {"id", "nameSrb"})
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "publisher")
public class Publisher {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String nameSrb;

   private String nameEng;

   private String nameOth;

   private String address;

   private String url;

   private String country;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="language_id", referencedColumnName="id", nullable=false)
   public Language language;

   @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="publisher")
   public Set<Thesis> studyFinalDocument;

   @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="publisher")
   public Set<Patent> patent;

   @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="publisher")
   public Set<Product> product;

   @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="publisher")
   public Set<Journal> journal;

   @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="publisher")
   public Set<Proceedings> proceedings;

}