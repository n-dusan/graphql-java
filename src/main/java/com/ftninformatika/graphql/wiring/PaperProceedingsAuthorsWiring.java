package com.ftninformatika.graphql.wiring;

import com.ftninformatika.cris.repository.PaperProceedingsAuthorsRepository;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaperProceedingsAuthorsWiring {

    private PaperProceedingsAuthorsRepository paperProceedingsAuthorsRepository;

    @Autowired
    public PaperProceedingsAuthorsWiring(PaperProceedingsAuthorsRepository paperProceedingsAuthorsRepository) {
        this.paperProceedingsAuthorsRepository = paperProceedingsAuthorsRepository;
    }

    public DataFetcher findByFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAllIgnoreCase() {
        return environment -> {
            String firstName = environment.getArgument("firstName");
            String lastName = environment.getArgument("lastName");
            String middleName = environment.getArgument("middleName");
            String email = environment.getArgument("email");
            String affiliations = environment.getArgument("affiliations");
            return paperProceedingsAuthorsRepository.findByFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAllIgnoreCase(firstName, lastName, middleName, email, affiliations);
        };
    };

    public DataFetcher findByNumOrderAndFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAndPersonIdAllIgnoreCase() {
        return environment -> {
            Integer numOrder = environment.getArgument("numOrder");
            String firstName = environment.getArgument("firstName");
            String lastName = environment.getArgument("lastName");
            String middleName = environment.getArgument("middleName");
            String email = environment.getArgument("email");
            String affiliations = environment.getArgument("affiliations");
            Long personId = Long.valueOf(environment.getArgument("affiliations"));
            return paperProceedingsAuthorsRepository.findByNumOrderAndFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAndPersonIdAllIgnoreCase(numOrder, firstName, lastName, middleName, email, affiliations, personId);
        };
    };

    public DataFetcher findByNumOrderAndFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAllIgnoreCase() {
        return environment -> {
            Integer numOrder = environment.getArgument("numOrder");
            String firstName = environment.getArgument("firstName");
            String lastName = environment.getArgument("lastName");
            String middleName = environment.getArgument("middleName");
            String email = environment.getArgument("email");
            String affiliations = environment.getArgument("affiliations");
            return paperProceedingsAuthorsRepository.findByNumOrderAndFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAllIgnoreCase(numOrder, firstName, lastName, middleName, email, affiliations);
        };
    };

    public DataFetcher findByFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAndPersonIdAllIgnoreCase() {
        return environment -> {
            String firstName = environment.getArgument("firstName");
            String lastName = environment.getArgument("lastName");
            String middleName = environment.getArgument("middleName");
            String email = environment.getArgument("email");
            String affiliations = environment.getArgument("affiliations");
            Long personId = Long.valueOf(environment.getArgument("affiliations"));
            return paperProceedingsAuthorsRepository.findByFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAndPersonIdAllIgnoreCase(firstName, lastName, middleName, email, affiliations, personId);
        };
    };
}
