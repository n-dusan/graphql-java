package com.ftninformatika.graphql;

import com.ftninformatika.cris.model.PaperJournalAuthors;
import com.ftninformatika.graphql.wiring.*;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import graphql.GraphQL;
import graphql.scalars.ExtendedScalars;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

@Component
public class GraphQLProvider {

    private GraphQL graphQL;

    private PaperJournalWiring paperJournalWiring;
    private ActivityWiring activityWiring;
    private JournalWiring journalWiring;
    private LanguageWiring languageWiring;
    private MonographOfPapersWiring monographOfPapersWiring;
    private PaperJournalAuthorsWiring paperJournalAuthorsWiring;
    private PaperJournalTypeWiring paperJournalTypeWiring;
    private PaperMonographAuthorsWiring paperMonographAuthorsWiring;
    private PaperMonographWiring paperMonographWiring;
    private PaperProceedingsAuthorsWiring paperProceedingsAuthorsWiring;
    private PaperProceedingsWiring paperProceedingsWiring;
    private PersonWiring personWiring;
    private ProceedingsWiring proceedingsWiring;

    @Bean
    public GraphQL graphQL() {
        return graphQL;
    }

    @Autowired
    public GraphQLProvider(PaperJournalWiring paperJournalWiring, ActivityWiring activityWiring, JournalWiring journalWiring, LanguageWiring languageWiring, MonographOfPapersWiring monographOfPapersWiring, PaperJournalAuthorsWiring paperJournalAuthorsWiring,
                           PaperJournalTypeWiring paperJournalTypeWiring, PaperMonographAuthorsWiring paperMonographAuthorsWiring, PaperMonographWiring paperMonographWiring, PaperProceedingsAuthorsWiring paperProceedingsAuthorsWiring, PaperProceedingsWiring paperProceedingsWiring,
                           PersonWiring personWiring, ProceedingsWiring proceedingsWiring) {
        this.paperJournalWiring = paperJournalWiring;
        this.activityWiring = activityWiring;
        this.journalWiring = journalWiring;
        this.languageWiring = languageWiring;
        this.monographOfPapersWiring = monographOfPapersWiring;
        this.paperJournalAuthorsWiring = paperJournalAuthorsWiring;
        this.paperJournalTypeWiring = paperJournalTypeWiring;
        this.paperMonographAuthorsWiring = paperMonographAuthorsWiring;
        this.paperMonographWiring = paperMonographWiring;
        this.paperProceedingsAuthorsWiring = paperProceedingsAuthorsWiring;
        this.paperProceedingsWiring = paperProceedingsWiring;
        this.personWiring = personWiring;
        this.proceedingsWiring = proceedingsWiring;
    }

    @PostConstruct
    public void init() throws IOException {
        URL url = Resources.getResource("schema.graphqls");
        String sdl = Resources.toString(url, Charsets.UTF_8);
        GraphQLSchema graphQLSchema = buildSchema(sdl);
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    private GraphQLSchema buildSchema(String sdl) {
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(sdl);
        RuntimeWiring runtimeWiring = buildWiring();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
    }

    private RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .scalar(ExtendedScalars.DateTime)
                .type(newTypeWiring("Query")
                        .dataFetcher("paperJournalByScopusID", paperJournalWiring.getJournalDataFetcher())
                .dataFetcher("findActivityByCodeAndNameAndDescription", activityWiring.findByCodeContainingAndNameContainingAndDescriptionContainingAllIgnoreCase())
                .dataFetcher("findJournalByPissn", journalWiring.findByPissn())
                .dataFetcher("findJournalByEissn", journalWiring.findByEissn())
                .dataFetcher("findJournalByEissnAndPissn", journalWiring.findByEissnAndPissn())
                .dataFetcher("findLanguageByCodeAndName", languageWiring.findByCodeContainingAndNameContainingAllIgnoreCase())
                .dataFetcher("countLanguageNotNull", languageWiring.countByIdNotNull())
                .dataFetcher("countMonographOfPapersNotNull", monographOfPapersWiring.countMonographOfPapersNotNull())
                .dataFetcher("findPaperJournalAuthorsByFirstNameAndLastNameAndMiddleNameAndEmailAndAffiliations", paperJournalAuthorsWiring.findPaperJournalAuthorsByFirstNameAndLastNameAndMiddleNameAndEmailAndAffiliations())
                .dataFetcher("findPaperJournalAuthorsByNumOrderAndFirstNameAndLastNameAndMiddleNameAndEmailAndAffiliationsAndPersonId", paperJournalAuthorsWiring.findByNumOrderAndFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAndPersonIdAllIgnoreCase())
                .dataFetcher("findPaperJournalAuthorsByNumOrderAndFirstNameAndLastNameAndMiddleNameAndEmailAndAffiliations", paperJournalAuthorsWiring.findByNumOrderAndFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAllIgnoreCase())
                .dataFetcher("findPaperJournalAuthorsByFirstNameAndLastNameAndMiddleNameAndEmailAndAffiliationsAndPersonId", paperJournalAuthorsWiring.findByFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAndPersonIdAllIgnoreCase())
                .dataFetcher("findPaperJournalTypeByNameAndDescription", paperJournalTypeWiring.findByNameContainingAndDescriptionContainingAllIgnoreCase())
                .dataFetcher("findPaperMonographByScopusID", paperMonographWiring.findByScopusID())
                .dataFetcher("countPaperMonographs", paperMonographWiring.countByIdNotNull())
                .dataFetcher("findPaperMonographAuthorsByFirstNameAndLastNameAndMiddleNameAndEmailAndAffiliations", paperMonographAuthorsWiring.findByFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAllIgnoreCase())
                .dataFetcher("findPaperMonographAuthorsByNumOrderAndFirstNameAndLastNameAndMiddleNameAndEmailAndAffiliationsAndPersonId", paperMonographAuthorsWiring.findByNumOrderAndFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAndPersonIdAllIgnoreCase())
                .dataFetcher("findPaperMonographAuthorsByNumOrderAndFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAllIgnoreCase", paperMonographAuthorsWiring.findByNumOrderAndFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAllIgnoreCase())
                .dataFetcher("findPaperMonographAuthorsByFirstNameAndLastNameAndMiddleNameAndEmailAndAffiliationsAndPersonId", paperMonographAuthorsWiring.findByFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAndPersonIdAllIgnoreCase())
                .dataFetcher("findPaperProceedingsByScopusID", paperProceedingsWiring.findByScopusID())
                .dataFetcher("countPaperProceedingsNotNull", paperProceedingsWiring.countByIdNotNull())
                .dataFetcher("findPaperProceedingsAuthorsByFirstNameAndLastNameAndMiddleNameAndEmailAndAffiliations", paperProceedingsAuthorsWiring.findByFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAllIgnoreCase())
                .dataFetcher("findPaperProceedingsAuthorsByNumOrderAndFirstNameAndLastNameAndMiddleNameAndEmailAndAffiliationsAndPersonId", paperProceedingsAuthorsWiring.findByNumOrderAndFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAndPersonIdAllIgnoreCase())
                .dataFetcher("findPaperProceedingsAuthorsByNumOrderAndFirstNameAndLastNameAndMiddleNameAndEmailAndAffiliations", paperProceedingsAuthorsWiring.findByNumOrderAndFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAllIgnoreCase())
                .dataFetcher("findPaperProceedingsAuthorsByFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAndPersonIdAllIgnoreCase", paperProceedingsAuthorsWiring.findByFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAndPersonIdAllIgnoreCase())
                .dataFetcher("findPersonByScopusID", personWiring.findByScopusID())
                .dataFetcher("countPersonNotNull", personWiring.countByIdNotNull())
                .dataFetcher("countProceedingsNotNull", proceedingsWiring.countProceedingsNotNull()))
//                .type(newTypeWiring("Book")
//                        .dataFetcher("author", graphQLDataFetchers.getAuthorDataFetcher()))
                .build();
    }
}