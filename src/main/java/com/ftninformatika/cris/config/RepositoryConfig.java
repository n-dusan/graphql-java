package com.ftninformatika.cris.config;

import com.ftninformatika.cris.model.*;
import com.ftninformatika.cris.model.event.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class RepositoryConfig extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(
                Acknowledgement.class,
                Activity.class,
                Advisor.class,
                Category.class,
                Commission.class,
                Conference.class,
                File.class,
                Founder.class,
                Institution.class,
                InstitutionActivity.class,
                InstitutionFounder.class,
                InstitutionResearchArea.class,
                InstitutionStatus.class,
                InstitutionType.class,
                Journal.class,
                JournalEditors.class,
                JournalGuestEditors.class,
                JournalStatus.class,
                Language.class,
                License.class,
                Monograph.class,
                MonographAuthors.class,
                MonographEditors.class,
                MonographOfPapers.class,
                MonographOfPaperStatus.class,
                MonographOfPaperType.class,
                PaperJournal.class,
                PaperJournalAuthors.class,
                PaperJournalStatus.class,
                PaperJournalType.class,
                PaperMonograph.class,
                PaperMonographAuthors.class,
                PaperMonographStatus.class,
                PaperMonographType.class,
                PaperProceedings.class,
                PaperProceedingsAuthors.class,
                PaperProceedingsStatus.class,
                PaperProceedingsType.class,
                Participant.class,
                ParticipantRole.class,
                Partner.class,
                PartnerRole.class,
                Patent.class,
                PatentAuthors.class,
                PatentStatus.class,
                PatentType.class,
                Person.class,
                PersonCategory.class,
                PersonInstitution.class,
                PersonInstitutionFunction.class,
                PersonInstitutionPosition.class,
                PersonInstitutionStatus.class,
                PersonName.class,
                PersonType.class,
                Proceedings.class,
                ProceedingsEditors.class,
                Product.class,
                ProductAuthors.class,
                ProductStatus.class,
                ProductType.class,
                Project.class,
                ProjectStatus.class,
                ProjectType.class,
                Publisher.class,
                ResearchArea.class,
                Thesis.class,
                ThesisStatus.class,
                ThesisType.class,
                TitleInstitution.class);
    }

    @Bean
    ProjectEventHandler projectEventHandler() {
        return new ProjectEventHandler();
    }

    @Bean
    ConferenceEventHandler conferenceEventHandler() {
        return new ConferenceEventHandler();
    }

    @Bean
    PersonEventHandler personEventHandler() {
        return new PersonEventHandler();
    }

    @Bean
    MonographEventHandler monographEventHandler() {
        return new MonographEventHandler();
    }

    @Bean
    InstitutionEventHandler institutionEventHandler() {
        return new InstitutionEventHandler();
    }

    @Bean
    MonographOfPapersEventHandler monographOfPapersEventHandler() {
        return new MonographOfPapersEventHandler();
    }

    @Bean
    JournalEventHandler journalEventHandler() {
        return new JournalEventHandler();
    }

    @Bean
    PaperMonographEventHandler paperMonographEventHandler() {
        return new PaperMonographEventHandler();
    }

    @Bean
    ProceedingsEventHandler proceedingsEventHandler() {
        return new ProceedingsEventHandler();
    }

    @Bean
    ThesisEventHandler thesisEventHandler() {
        return new ThesisEventHandler();
    }

    @Bean
    ProductEventHandler productEventHandler() {
        return new ProductEventHandler();
    }

    @Bean
    PatentEventHandler patentEventHandler() { return new PatentEventHandler(); }

    @Bean
    PaperProceedingsEventHandler paperProceedingsEventHandler() {
        return new PaperProceedingsEventHandler();
    }

    @Bean
    PaperJournalEventHandler paperJournalEventHandler() {
        return new PaperJournalEventHandler();
    }

}
