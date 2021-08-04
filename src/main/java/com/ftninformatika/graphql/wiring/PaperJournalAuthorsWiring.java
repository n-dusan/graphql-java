package com.ftninformatika.graphql.wiring;

import com.ftninformatika.cris.repository.PaperJournalAuthorsRepository;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaperJournalAuthorsWiring {

    private PaperJournalAuthorsRepository paperJournalAuthorsRepository;

    @Autowired
    public PaperJournalAuthorsWiring(PaperJournalAuthorsRepository paperJournalAuthorsRepository) {
        this.paperJournalAuthorsRepository = paperJournalAuthorsRepository;
    }

    public DataFetcher findPaperJournalAuthorsByFirstNameAndLastNameAndMiddleNameAndEmailAndAffiliations() {
        return environment -> {
            String firstName = environment.getArgument("firstName");
            String lastName = environment.getArgument("lastName");
            String middleName = environment.getArgument("middleName");
            String email = environment.getArgument("email");
            String affiliations = environment.getArgument("affiliations");
            return paperJournalAuthorsRepository.findByFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAllIgnoreCase(firstName, lastName, middleName, email, affiliations);
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
            return paperJournalAuthorsRepository.findByNumOrderAndFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAndPersonIdAllIgnoreCase(numOrder, firstName, lastName, middleName, email, affiliations, personId);
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
            return paperJournalAuthorsRepository.findByNumOrderAndFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAllIgnoreCase(numOrder, firstName, lastName, middleName, email, affiliations);
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
            return paperJournalAuthorsRepository.findByFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAndPersonIdAllIgnoreCase(firstName, lastName, middleName, email, affiliations, personId);
        };
    };

}
