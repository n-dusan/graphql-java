package com.ftninformatika.graphql.wiring;

import com.ftninformatika.cris.repository.MonographOfPapersRepository;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MonographOfPapersWiring {

    private MonographOfPapersRepository monographOfPapersRepository;

    @Autowired
    public MonographOfPapersWiring(MonographOfPapersRepository monographOfPapersRepository) {
        this.monographOfPapersRepository = monographOfPapersRepository;
    }

    public DataFetcher countMonographOfPapersNotNull() {
        return environment -> monographOfPapersRepository.countByIdNotNull();
    };
}
