package com.ftninformatika.graphql.wiring;

import com.ftninformatika.cris.repository.ActivityRepository;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActivityWiring {

    private ActivityRepository activityRepository;

    @Autowired
    public ActivityWiring(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public DataFetcher findByCodeContainingAndNameContainingAndDescriptionContainingAllIgnoreCase() {
        return environment -> {
            String code = environment.getArgument("code");
            String name = environment.getArgument("name");
            String description = environment.getArgument("description");
            return activityRepository.findByCodeContainingAndNameContainingAndDescriptionContainingAllIgnoreCase(code, name, description);
        };
    };
}
