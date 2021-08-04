package com.ftninformatika.graphql.wiring;

import com.ftninformatika.cris.repository.PaperMonographRepository;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaperMonographWiring {

    private PaperMonographRepository paperMonographRepository;

    @Autowired
    public PaperMonographWiring(PaperMonographRepository paperMonographRepository) {
        this.paperMonographRepository = paperMonographRepository;
    }

    public DataFetcher findByScopusID() {
        return environment -> {
            String scopusID = environment.getArgument("scopusID");
            return paperMonographRepository.findByScopusID(scopusID);
        };
    };

    public DataFetcher countByIdNotNull() {
        return environment -> paperMonographRepository.countByIdNotNull();
    };
}
