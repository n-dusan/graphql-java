package com.ftninformatika.cris.model;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@ToString(of = {"id", "numOrder"})
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "advisor")
public class Advisor {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private Integer numOrder;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="person_id", referencedColumnName="id", nullable=false)
   public Person person;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="thesis_id", referencedColumnName="id", nullable=false)
   public Thesis thesis;

}