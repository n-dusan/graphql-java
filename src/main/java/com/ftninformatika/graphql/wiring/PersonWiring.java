package com.ftninformatika.graphql.wiring;

import com.ftninformatika.cris.repository.PersonRepository;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonWiring {

    private PersonRepository personRepository;

    @Autowired
    public PersonWiring(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public DataFetcher countByIdNotNull() {
        return environment -> personRepository.countByIdNotNull();
    };

    public DataFetcher findByScopusID() {
        return environment -> {
            String scopusID = environment.getArgument("scopusID");
            return personRepository.findByScopusID(scopusID);
        };
    };

}
