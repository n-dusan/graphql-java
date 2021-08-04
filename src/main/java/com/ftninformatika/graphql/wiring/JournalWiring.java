package com.ftninformatika.graphql.wiring;

import com.ftninformatika.cris.repository.JournalRepository;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JournalWiring {

    private JournalRepository journalRepository;

    @Autowired
    public JournalWiring(JournalRepository journalRepository) {
        this.journalRepository = journalRepository;
    }

    public DataFetcher findByPissn() {
        return environment -> {
            String pissn = environment.getArgument("pissn");
            return journalRepository.findByPissn(pissn);
        };
    };

    public DataFetcher findByEissn() {
        return environment -> {
            String eissn = environment.getArgument("eissn");
            return journalRepository.findByPissn(eissn);
        };
    };

    public DataFetcher findByEissnAndPissn() {
        return environment -> {
            String eissn = environment.getArgument("eissn");
            String pissn = environment.getArgument("pissn");
            return journalRepository.findByEissnAndPissn(eissn, pissn);
        };
    };
}
