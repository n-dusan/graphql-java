package com.ftninformatika.cris.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@ToString(of = {"id", "firstName", "middleName", "lastName"})
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "monographAuthors")
public class MonographAuthors {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private Integer numOrder;

   private String firstName;

   private String lastName;

   private String middleName;

   private String email;

   private String affiliations;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="person_id", referencedColumnName="id", nullable=false)
   public Person person;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="monograph_id", referencedColumnName="id", nullable=false)
   public Monograph monograph;

}