package com.ftninformatika.graphql.wiring;

import com.ftninformatika.cris.repository.PaperJournalRepository;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaperJournalWiring {

    private PaperJournalRepository paperJournalRepository;

    @Autowired
    public PaperJournalWiring(PaperJournalRepository paperJournalRepository) {
        this.paperJournalRepository = paperJournalRepository;
    }

    public DataFetcher getJournalDataFetcher() {
        return environment -> {
            String id = environment.getArgument("scopusID");
            return paperJournalRepository.findByScopusID(id);
        };
    };

    public PaperJournalRepository getPaperJournalRepository() {
        return paperJournalRepository;
    }
}
