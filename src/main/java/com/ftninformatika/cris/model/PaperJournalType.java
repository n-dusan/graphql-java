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
@Table(name = "paperJournalType")
public class PaperJournalType {

   @Id
   @GeneratedValue
   private Long id;

   private String name;

   private String description;

   @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy = "paperJournalType")
   public Set<PaperJournal> paperJournal;

}