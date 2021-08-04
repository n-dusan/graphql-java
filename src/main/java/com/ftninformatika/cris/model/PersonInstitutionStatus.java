package com.ftninformatika.cris.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@ToString(of = {"id", "name", "description"})
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "personInstitutionStatus")
public class PersonInstitutionStatus {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String name;

   private String description;

   @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="personInstitutionStatus")
   public Set<PersonInstitution> person;

}