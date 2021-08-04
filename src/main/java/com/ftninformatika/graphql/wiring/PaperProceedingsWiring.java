package com.ftninformatika.graphql.wiring;

import com.ftninformatika.cris.repository.PaperProceedingsRepository;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaperProceedingsWiring {

    private PaperProceedingsRepository paperProceedingsRepository;

    @Autowired
    public PaperProceedingsWiring(PaperProceedingsRepository paperProceedingsRepository) {
        this.paperProceedingsRepository = paperProceedingsRepository;
    }

    public DataFetcher findByScopusID() {
        return environment -> {
            String scopusID = environment.getArgument("scopusID");
            return paperProceedingsRepository.findByScopusID(scopusID);
        };
    }

    public DataFetcher countByIdNotNull() {
        return environment -> paperProceedingsRepository.countByIdNotNull();
    }

}
