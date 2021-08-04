package com.ftninformatika.cris.model;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@ToString(of = {"id", "name", "description"})
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "researchArea")
public class ResearchArea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="language_id", referencedColumnName="id", nullable=false)
    public Language language;

    @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="researchArea")
    public Set<InstitutionResearchArea> institutionResearchAreas;

}