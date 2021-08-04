package com.ftninformatika.graphql.wiring;

import com.ftninformatika.cris.repository.PaperJournalTypeRepository;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaperJournalTypeWiring {

    private PaperJournalTypeRepository paperJournalTypeRepository;

    @Autowired
    public PaperJournalTypeWiring(PaperJournalTypeRepository paperJournalTypeRepository) {
        this.paperJournalTypeRepository = paperJournalTypeRepository;
    }

    public DataFetcher findByNameContainingAndDescriptionContainingAllIgnoreCase() {
        return environment -> {
            String name = environment.getArgument("name");
            String description = environment.getArgument("description");
            return paperJournalTypeRepository.findByNameContainingAndDescriptionContainingAllIgnoreCase(name, description);
        };
    };

}
