package com.ftninformatika.cris.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@ToString(of = {"id", "person", "category"})
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "personCategory")
public class PersonCategory {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private LocalDate startDate;

   private LocalDate endDate;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="category_id", referencedColumnName="id", nullable=false)
   public Category category;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="person_id", referencedColumnName="id", nullable=false)
   public Person person;

}