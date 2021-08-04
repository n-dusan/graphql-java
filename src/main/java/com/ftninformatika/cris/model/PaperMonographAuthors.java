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
@Table(name = "paperMonographAuthors")
public class PaperMonographAuthors {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private Integer numOrder;

   @Column(length = 500)
   private String firstName;

   @Column(length = 500)
   private String lastName;

   private String middleName;

   private String email;

   @Column(length = 500)
   private String affiliations;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="person_id", referencedColumnName="id", nullable=false)
   public Person person;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "paper_monograph_id", referencedColumnName = "id", nullable = false)
   public PaperMonograph paperMonograph;

}