package com.ftninformatika.cris.model.event;

import com.ftninformatika.cris.model.Institution;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import java.time.LocalDateTime;

@RepositoryEventHandler(Institution.class)
public class InstitutionEventHandler {

    /*Posto nama ne radi PUT metoda, nego sve saljemo preko POST metode, onda ne mozemo da
    * za izmenu primenimo @HandleBeforeSave nego i dodavanje nove institucije i izmena ide
    * preko @HandleBeforeCreate. Ali sa frontenda kada kreiramo instituciju saljemo i creation
    * Date(cija vrednost nam ne treba, nego nam treba samo da ne bude null) i na osnovu
    * postojanja creation date znamo da li se dodaje nova ili menja postojeca institucija*/
    @HandleBeforeCreate
    public void handleInstitutionCreate(Institution institution) {
        if (institution.getCreationDate() == null) {
            institution.setCreationDate(LocalDateTime.now());
            institution.setRecordStatus(1);
        } else {
            institution.setLastModificationDate(LocalDateTime.now());
        }
    }

}
