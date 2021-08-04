package com.ftninformatika.graphql.wiring;

import com.ftninformatika.cris.repository.LanguageRepository;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LanguageWiring {

    private LanguageRepository languageRepository;

    @Autowired
    public LanguageWiring(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public DataFetcher findByCodeContainingAndNameContainingAllIgnoreCase() {
        return environment -> {
            String code = environment.getArgument("code");
            String name = environment.getArgument("name");
            return languageRepository.findByCodeContainingAndNameContainingAllIgnoreCase(code, name);
        };
    };

    public DataFetcher countByIdNotNull() {
        return environment -> languageRepository.countByIdNotNull();
    }
}
