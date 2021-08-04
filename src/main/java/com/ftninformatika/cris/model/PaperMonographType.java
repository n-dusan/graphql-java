package com.ftninformatika.cris.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@ToString(of = {"id", "name", "description"})
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "paperMonographType")
public class PaperMonographType {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String name;

   private String description;

   @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy = "paperMonographType")
   public Set<PaperMonograph> paperMonograph;

}