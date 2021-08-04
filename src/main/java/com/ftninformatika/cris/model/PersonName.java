package com.ftninformatika.cris.model;

import lombok.*;

import javax.persistence.*;

@ToString(of = {"id", "firstName", "middleName", "lastName"})
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "personName")
public class PersonName {

   @Id
   @GeneratedValue
   private Long id;

   private String firstName;

   private String lastName;

   private String middleName;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="person_id", referencedColumnName="id", nullable=false)
   public Person person;

}