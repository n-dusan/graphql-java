package com.ftninformatika.graphql.wiring;

import com.ftninformatika.cris.repository.ProceedingsRepository;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProceedingsWiring {

    private ProceedingsRepository proceedingsRepository;

    @Autowired
    public ProceedingsWiring(ProceedingsRepository proceedingsRepository) {
        this.proceedingsRepository = proceedingsRepository;
    }

    public DataFetcher countProceedingsNotNull() {
        return environment -> proceedingsRepository.countByIdNotNull();
    };
}
