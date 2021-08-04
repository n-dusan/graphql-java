package com.ftninformatika.util.importer;

import com.ftninformatika.cris.model.*;
import com.ftninformatika.cris.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "api/import")
public class ImportApiController {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    LanguageRepository languageRepository;

    @Autowired
    PaperJournalRepository paperJournalRepository;

    @Autowired
    PaperMonographRepository paperMonographRepository;

    @Autowired
    MonographOfPapersRepository monographOfPapersRepository;

    @Autowired
    PaperProceedingsRepository paperProceedingsRepository;

    @Autowired
    ProceedingsRepository proceedingsRepository;

    @Autowired
    JournalRepository journalRepository;

    @Autowired
    PaperJournalAuthorsRepository paperJournalAuthorsRepository;

    @Autowired
    PaperMonographAuthorsRepository paperMonographAuthorsRepository;

    @Autowired
    PaperProceedingsAuthorsRepository paperProceedingsAuthorsRepository;

    @Autowired
    MonographRepository monographRepository;

    @Autowired
    MonographAuthorsRepository monographAuthorsRepository;

    @Autowired
    InstitutionRepository institutionRepository;

    @Autowired
    PersonInstitutionRepository personInstitutionRepository;

    void poveziUNSAutoreSaUNSom() {

        Institution UNS = snimiUNSuBazu();

        ArrayList<String> listaIdjevaAutora =  ReadWriteFile.ucitajScopusIdjeveAutoraIzFajla();
        /*Ukoliko nemamo autora u bazi, sto znaci da autor nije izvucen iz radova tj da autor nema ni jedan rad,
        * onda cemo snimati UNS autora iz mape autora koju smo ranije uvukli - svi autori koji pripadaju UNS-u*/
        Map<String, Person> pomocnaMapaAutora = ReadWriteFile.ucitajAutoreIzFajla();

        for (String id : listaIdjevaAutora) {
            Person person = personRepository.findByScopusID(id);
            if (person != null) {
                PersonInstitution personInstitution = new PersonInstitution();
                personInstitution.setPerson(person);
                personInstitution.setInstitution(UNS);
                PersonInstitution dbPersonInstitution1 = personInstitutionRepository.save(personInstitution);
                System.out.println("Snimljem person_institution sa dbId-jem: " + dbPersonInstitution1.getId());
            } else {
                Person personFromMap = pomocnaMapaAutora.get(id);
                personRepository.save(personFromMap);
                System.out.println("Snimljem person sa scopusID-jem: " + personFromMap.getScopusID());
            }
        }


    }

    /*Samo snimamo instituciju UNS u bazu*/
    private Institution snimiUNSuBazu() {
        Institution UNS = new Institution();
        UNS.setNameSrb("Univerzitet u Novom Sadu");
        UNS.setAddress("Dr Zorana Djindjica 1, 21101 Novi Sad, Srbija");
        Institution dbUNS =  institutionRepository.save(UNS);
        return dbUNS;
    }

    /*Metoda koju pozivamo preko apija kada zelimo da nam svi dokumenti koji se nalaze u odvojenim
    * fajlovima parsiraju i snime u bazu. Pored toga sto se ti dokumenti snimajuu bazu iz njih se
    * izvlace i autori i ti autori se snimaju, kao i veze izmedju autora i dokumenata.*/
    @RequestMapping(value = "/documents", method = RequestMethod.GET)
    void obradiDokumenteISnimiIhUBazu() {

        snimiDokumenteUBazu();
        snimiAutoreUBazu();
        snimiVezeIzmedjuDokumenataIAutoraUBazu();
        poveziUNSAutoreSaUNSom();

    }

    void snimiDokumenteUBazu() {
        Map<String, Language> languages = prodjiKrozDokumenteISnimiLanguagesUBazu();

        ArrayList<Object> paperList = ImportUtility.ucitajDokumenteIzFajlova(languages);
        ArrayList<PaperJournal> paperJournals = new ArrayList<>();
        ArrayList<PaperMonograph> paperMonographs = new ArrayList<>();
        ArrayList<PaperProceedings> paperProceedings = new ArrayList<>();
        ArrayList<Monograph> monographs = new ArrayList<>();

        for (Object object : paperList) {
            if (object instanceof PaperJournal) {
                paperJournals.add((PaperJournal) object);
            } else if (object instanceof PaperMonograph) {
                paperMonographs.add((PaperMonograph) object);
            } else if (object instanceof PaperProceedings) {
                paperProceedings.add((PaperProceedings) object);
            } else if(object instanceof Monograph) {
                monographs.add((Monograph) object);
            }
        }

        snimiPaperJournaleUBazu(paperJournals);         //Prikazuje na front
        snimiPaperMonographeUBazu(paperMonographs);     //Radi paperMonograph, a ne radi monographOfPapers
        snimiPaperProceedingsUBazu(paperProceedings);   //Prikazuje na front
        snimiMonographeUBazu(monographs);               //Prikazuje na front

        System.out.println("Uspesno zavrseno snimanje dokumenata u bazu! :)");
    }

    void  snimiVezeIzmedjuDokumenataIAutoraUBazu() {
        snimiVezeIzmedjuPaperJournalaIAutora();
        snimiVezeIzmedjuPaperMonographaIAutora();
        snimiVezeIzmedjuPaperProceedingsaIAutora();
        snimiVezeIzmedjuMonographaIAutora();

    }


    void snimiVezeIzmedjuPaperJournalaIAutora() {
        int i = 1;
        for (PaperJournalAuthors paperJournalAuthor: ScopusDocumentUtility.listaSvihPaperJournalAuthorEntuteta) {
            Person person = personRepository.findByScopusID(paperJournalAuthor.getPerson().getScopusID());
            PaperJournal paperJournal = paperJournalRepository.findByScopusID(paperJournalAuthor.getPaperJournal().getScopusID());

            paperJournalAuthor.setPaperJournal(paperJournal);
            paperJournalAuthor.setPerson(person);

            paperJournalAuthorsRepository.save(paperJournalAuthor);

            System.out.println("(" + i + "/" + ScopusDocumentUtility.listaSvihPaperJournalAuthorEntuteta.size() + ") Uspesno snimljen paperJournalAuthor!");
            i++;
        }
    }

    void snimiVezeIzmedjuPaperMonographaIAutora() {

        int i = 1;
        for (PaperMonographAuthors paperMonographAuthor : ScopusDocumentUtility.listaSvihPaperMonographAuthorEntuteta) {
            Person person = personRepository.findByScopusID(paperMonographAuthor.getPerson().getScopusID());
            PaperMonograph paperMonograph = paperMonographRepository.findByScopusID(paperMonographAuthor.getPaperMonograph().getScopusID());

            paperMonographAuthor.setPaperMonograph(paperMonograph);
            paperMonographAuthor.setPerson(person);

            paperMonographAuthorsRepository.save(paperMonographAuthor);

            System.out.println("(" + i + "/" + ScopusDocumentUtility.listaSvihPaperMonographAuthorEntuteta.size() + ") Uspesno snimljen paperMonographAuthor!");

            i++;
        }
    }

    void snimiVezeIzmedjuPaperProceedingsaIAutora() {

        int i = 1;
        for (PaperProceedingsAuthors paperProceedingsAuthor: ScopusDocumentUtility.listaSvihPaperProceedingAuthorEntuteta) {
            Person person = personRepository.findByScopusID(paperProceedingsAuthor.getPerson().getScopusID());
            PaperProceedings paperProceedings= paperProceedingsRepository.findByScopusID(paperProceedingsAuthor.getPaperProceedings().getScopusID());

            paperProceedingsAuthor.setPaperProceedings(paperProceedings);
            paperProceedingsAuthor.setPerson(person);

            paperProceedingsAuthorsRepository.save(paperProceedingsAuthor);

            System.out.println("(" + i + "/" + ScopusDocumentUtility.listaSvihPaperProceedingAuthorEntuteta.size() + ") Uspesno snimljen paperProceedingsAuthor!");

            i++;
        }



    }

    void snimiVezeIzmedjuMonographaIAutora() {

        int i = 1;
        for (MonographAuthors monographAuthors: ScopusDocumentUtility.listaSvihMonographAuthorEntuteta) {
            Person person = personRepository.findByScopusID(monographAuthors.getPerson().getScopusID());
            Monograph monograph= monographRepository.findByScopusID(monographAuthors.getMonograph().getScopusID());

            monographAuthors.setMonograph(monograph);
            monographAuthors.setPerson(person);

            monographAuthorsRepository.save(monographAuthors);

            System.out.println("(" + i + "/" + ScopusDocumentUtility.listaSvihMonographAuthorEntuteta.size() + ") Uspesno snimljen monographAuthor!");

            i++;
        }
    }

    void snimiAutoreUBazu() {
        int i = 1;
        for (Person person : ScopusDocumentUtility.listaSvihAutora) {
            Person dbPerson = personRepository.findByScopusID(person.getScopusID());
            if (dbPerson == null) {
                personRepository.save(person);
                System.out.println("(" + i + "/" + ScopusDocumentUtility.listaSvihAutora.size() + ") Snimljen autor sa scopusID-jem: " + person.getScopusID());
            } else {
                System.out.println("Person " + dbPerson.getFirstName() + " " + dbPerson.getLastName() + " sa ScopusId-jem: " + dbPerson.getScopusID() + " vec postoji u bazi!");
            }
            i++;
        }
    }


    /*Prolazimo kroz sve dokumente i izvlacimo Language iz istih, potom te jezike snimamo u
    * bazu podataka potom ih izvlacimo iz baze i stavljamo u mapu languages koja ce nam
    * trebati za dokumente posto ce oni u sebi sadrzati language*/
    private Map<String, Language> prodjiKrozDokumenteISnimiLanguagesUBazu(){
        System.out.println("Prolazak kroz dokumente i snimanje Languages-a u bazu podataka");
        Map<String, String> languageMap = ImportUtility.proveriLanguage();
        for (Map.Entry<String, String> entry : languageMap.entrySet()) {
            Language language = new Language();
            language.setCode(entry.getKey());
            language.setName(entry.getValue());
            try {
                languageRepository.save(language);
            } catch (Exception e) {
                System.out.println(language.getName() + " language already exist in database!");
            }
        }
        System.out.println("Zavrseno snimanje Languages-a u bazu podataka");

        Map<String, Language> languages = new HashMap<>();
        for (Language language : languageRepository.findAll()) {
            languages.put(language.getCode(), language);
        }

        return languages;
    }


    private void snimiPaperJournaleUBazu(ArrayList<PaperJournal> paperJournals) {
        int i = 1;
        for (PaperJournal paperJournal : paperJournals) {

            Journal journal = paperJournal.getJournal();
            Journal dataBaseJournal = null;

            /*Ukoliko u bazi imamo journal koji sadrzi eissn ili pissn kao journal koji trenutno obradjujemo,
            * onda izvlacimo taj journal iz baze(da li preko eissn-a ili pissn-a) i njega modifikujemo. Ukoliko
            * journal koji obradjujemo nema ni eissn ni pissn postavljamo ga na null posto takav journal ne vredi
            * da cuvamo u bazi podataka*/
            if (journal != null && journal.getPissn() != null && journal.getPissn() != null) {
                dataBaseJournal = journalRepository.findByEissnAndPissn(journal.getEissn(), journal.getPissn());
            }

            if (journal != null && dataBaseJournal == null && journal.getEissn() != null) {
                dataBaseJournal = journalRepository.findByEissn(journal.getEissn());
            }

            if (journal != null && dataBaseJournal == null && journal.getPissn() != null) {
                dataBaseJournal = journalRepository.findByPissn(journal.getPissn());
            } else if (journal != null) {
                System.out.println(journal.getNameEng() + " journal nema ni eissn ni pissn. ScopusId: " + journal.getScopusID());
            }


            /*Ukoliko journal sadrzi ili eissn ili pissn onda on nece biti postavljen na null i uci cemo u ovu if petlju.
            * Ukoliko je dataBaseJournal null to znaci da nismo pronasli u bazi journal koji ima eissn ili pissn kao nas
            * journal i tada snimamo novi journal u bazu. A ukoliko dataBaseJournal nije null to znaci da smo pronasli
            * journal u bazi i njemu setujemo eissn i pissn(u slucaju da je journal u bazi imao samo jedan od ta dva)
            * i snimamo ga*/
            if (journal != null) {
                if (dataBaseJournal == null) {
                    try {
                        journal = journalRepository.save(journal);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Name: " + journal.getNameEng());
                        System.out.println("ScopusID paper journal-a u kome se nalaze podaci za zadati journal: " + paperJournal.getScopusID());
                        System.exit(1);
                    }
                } else if(dataBaseJournal != null) {
                    /*Bio je jedan slucaj da su isto eissn i pissn pa je to pravilo problem, tako da ako su isti necemo nista setovati za sada*/
                    if (journal.getEissn() != null && journal.getPissn() != null && !journal.getEissn().equals(journal.getPissn())) {
                        dataBaseJournal.setEissn(journal.getEissn());
                        dataBaseJournal.setPissn(journal.getPissn());
                    }
                    try {
                        journal = journalRepository.save(dataBaseJournal);
                    } catch (Exception e) {
                        /*Ovde hvatamo exceptione koji se dese kao greska unosa pissn-a i eissn-a. Recimo unosimo journal,
                        * koji ima svoj eissn i pissn, a vec postoje u bazi dva joirnala jedan koji ima taj eissn i drugi
                        * koji ima taj pissn sto ne bi smelo da se dogodi, ali eto gresi covek*/
//                        TODO Ovi paperJournali nece biti povezani sa Journalom jer se desilo exception sa issn-om. Treba to raspetljati posle i povezati
                        e.printStackTrace();
                        System.out.println("ScopusID paperJournala:     "  + paperJournal.getScopusID());
                        System.out.println("Journal eissn:              "  + journal.getEissn());
                        System.out.println("Journal pissn:              "  + journal.getPissn());
                        System.out.println("dataBase Journal:           "  + dataBaseJournal);
                        System.out.println("dataBase Journal eissn:     "  + dataBaseJournal.getEissn());
                        System.out.println("dataBase Journal pissn:     "  + dataBaseJournal.getPissn());
                        System.out.println("dataBase Journal scopusID:  "  + dataBaseJournal.getScopusID());
                        System.out.println("dataBase Journal id:        "  + dataBaseJournal.getId());
                        System.out.println("Journal name:               "  + journal.getNameEng());
                        journal = null; // postavimo journal na null da bi mogli da ga snimimo
                    }
                }
            }

            /*setujemo journal(koji u sebi sadrzi id koji je dobio nakon snimanja u bazu) paperJournal-u*/
            paperJournal.setJournal(journal);


            /*Prilikom snimanja paper journala prvo proveravamo da li je taj paper journal vec snimljen
            * u bazu i to proveravamo preko scopusId-ja. Ako vec postoji u bazi onda preskacemo proces
            * snimanja. Moze se desiti exception ako je broj karaktera presao maximalno dozvoljeni broj
            * karaktera naveden u @Column(lenght = xxxx)*/
            PaperJournal dbPaperJournal = paperJournalRepository.findByScopusID(paperJournal.getScopusID());

            if (dbPaperJournal != null) {
                System.out.println("Paper Journal sa ID-jem: " + paperJournal.getScopusID() + " vec postoji u bazi!");
            }
            else if (dbPaperJournal == null) {
                try {
                    paperJournalRepository.save(paperJournal);
                    System.out.println("(" + i + "/" + paperJournals.size() + ") Paper Journal sa scopusID-jem: " + paperJournal.getScopusID() + " uspesno snimljen u bazu!");

                } catch (Exception e) {
                    e.printStackTrace();

                    System.out.println("Ako je neka od duzina presla maksimalnu duzinu onda se tu desio exception," +
                            "ako nije onda je nesto drugo u pitanju");
                    System.out.println("Maksimalna duzina za title je 500");
                    System.out.println("Maksimalna duzina za abstracts je 4500");
                    System.out.println("Maksimalna duzina za keywords je 800");
                    System.out.println("ScopusID: " + paperJournal.getScopusID());
                    if (paperJournal.getTitleEng() != null) {
                        System.out.println("Title eng length: " + paperJournal.getTitleEng().length());
                    }
                    if (paperJournal.getTitleOth() != null) {
                        System.out.println("Title oth length: " + paperJournal.getTitleOth().length());
                    }
                    if (paperJournal.getAbstractEng() != null) {
                        System.out.println("Abstracts eng length: " + paperJournal.getAbstractEng().length());
                    }
                    if (paperJournal.getAbstractOth() != null) {
                        System.out.println("Abstracts oth length: " + paperJournal.getAbstractOth().length());
                    }
                    if (paperJournal.getKeywordsEng() != null) {
                        System.out.println("Keywords eng length: " + paperJournal.getKeywordsEng().length());
                    }
                    if (paperJournal.getKeywordsOth() != null) {
                        System.out.println("Keywords oth length: " + paperJournal.getKeywordsOth().length());
                    }
                    System.exit(-1);
                }
            }
            i++;
        }
    }


    private void snimiPaperMonographeUBazu(ArrayList<PaperMonograph> paperMonographs) {
        int i = 1;
        for (PaperMonograph paperMonograph : paperMonographs) {

            MonographOfPapers monographOfPapers = paperMonograph.getMonographOfPapers();
            PaperMonograph dbPaperMonograph = paperMonographRepository.findByScopusID(paperMonograph.getScopusID());

            if (dbPaperMonograph != null) {
                System.out.println("Paper Monograph sa ID-jem: " + dbPaperMonograph.getScopusID() + " vec postoji u bazi!");
            }

//            TODO Za sada on snima za svaki paperMonograph po jedan MonographOfPapers, a kada se razjasni oko issn i isbn za monographOfPapers onda ce biti slicno kao za journal sa proverama
            MonographOfPapers dbMonographOfPapers =  monographOfPapersRepository.save(monographOfPapers);
            paperMonograph.setMonographOfPapers(dbMonographOfPapers);

            if (dbPaperMonograph == null) {
                try {
                    paperMonographRepository.save(paperMonograph);
                    System.out.println("(" + i + "/" + paperMonographs.size() + ") Paper Monograph sa scopusID-jem: " + paperMonograph.getScopusID() + " uspesno snimljen u bazu!");
                } catch (Exception e) {
                    e.printStackTrace();

                    System.out.println("Ako je neka od duzina presla maksimalnu duzinu onda se tu desio exception," +
                            "ako nije onda je nesto drugo u pitanju");
                    System.out.println("Maksimalna duzina za title je 500");
                    System.out.println("Maksimalna duzina za abstracts je 4500");
                    System.out.println("Maksimalna duzina za keywords je 800");
                    System.out.println("ScopusID: " + paperMonograph.getScopusID());
                    if (paperMonograph.getTitleEng() != null) {
                        System.out.println("Title eng length: " + paperMonograph.getTitleEng().length());
                    }
                    if (paperMonograph.getTitleOth() != null) {
                        System.out.println("Title oth length: " + paperMonograph.getTitleOth().length());
                    }
                    if (paperMonograph.getAbstractEng() != null) {
                        System.out.println("Abstracts eng length: " + paperMonograph.getAbstractEng().length());
                    }
                    if (paperMonograph.getAbstractOth() != null) {
                        System.out.println("Abstracts oth length: " + paperMonograph.getAbstractOth().length());
                    }
                    if (paperMonograph.getKeywordsEng() != null) {
                        System.out.println("Keywords eng length: " + paperMonograph.getKeywordsEng().length());
                    }
                    if (paperMonograph.getKeywordsOth() != null) {
                        System.out.println("Keywords oth length: " + paperMonograph.getKeywordsOth().length());
                    }
                    System.exit(-1);
                }
            }
            i++;
        }
    }

    private void snimiPaperProceedingsUBazu(ArrayList<PaperProceedings> paperProceedings) {
        int i = 1;
        for (PaperProceedings paperProceeding : paperProceedings) {

            Proceedings proceedings = paperProceeding.getProceedings();
            PaperProceedings dbPaperProceeding = paperProceedingsRepository.findByScopusID(paperProceeding.getScopusID());

            if (dbPaperProceeding != null) {
                System.out.println("Paper Proceeding sa ID-jem: " + dbPaperProceeding.getScopusID() + " vec postoji u bazi!");
            }
//TODO Za sada on snima za svaki paperProceeding po jedan Proceeding, a kada se razjasni oko issn i isbn za Proceedings onda ce biti slicno kao za journal sa proverama
            Proceedings dbProceedings = new Proceedings();
            try {
                dbProceedings = proceedingsRepository.save(proceedings);
            } catch(Exception e) {
                //duzina field-a varchar(255) nije dovoljna, zaobiđi paper.
                System.out.println("Duzina field-a varchar(255) nije dovoljna, preskacem paper.");
                System.out.println("ScopusID: " + paperProceeding.getScopusID());
            }
            paperProceeding.setProceedings(dbProceedings);

            if(dbPaperProceeding == null) {
                try {
                    paperProceedingsRepository.save(paperProceeding);
                    System.out.println("(" + i + "/" + paperProceedings.size() + ") Paper Proceeding sa scopusID-jem: " + paperProceeding.getScopusID() + " uspesno snimljen u bazu!");
                } catch (Exception e) {
                    e.printStackTrace();

                    System.out.println("Ako je neka od duzina presla maksimalnu duzinu onda se tu desio exception," +
                            "ako nije onda je nesto drugo u pitanju");
                    System.out.println("Maksimalna duzina za title je 500");
                    System.out.println("Maksimalna duzina za abstracts je 4500");
                    System.out.println("Maksimalna duzina za keywords je 800");
                    System.out.println("ScopusID: " + paperProceeding.getScopusID());
                    if (paperProceeding.getTitleEng() != null) {
                        System.out.println("Title eng length: " + paperProceeding.getTitleEng().length());
                    }
                    if (paperProceeding.getTitleOth() != null) {
                        System.out.println("Title oth length: " + paperProceeding.getTitleOth().length());
                    }
                    if (paperProceeding.getAbstractEng() != null) {
                        System.out.println("Abstracts eng length: " + paperProceeding.getAbstractEng().length());
                    }
                    if (paperProceeding.getAbstractOth() != null) {
                        System.out.println("Abstracts oth length: " + paperProceeding.getAbstractOth().length());
                    }
                    if (paperProceeding.getKeywordsEng() != null) {
                        System.out.println("Keywords eng length: " + paperProceeding.getKeywordsEng().length());
                    }
                    if (paperProceeding.getKeywordsOth() != null) {
                        System.out.println("Keywords oth length: " + paperProceeding.getKeywordsOth().length());
                    }
                    System.exit(-1);
                }
            }
            i++;
        }
    }

    private void snimiMonographeUBazu(ArrayList<Monograph> monographs) {
        int i = 1;
        for (Monograph monograph : monographs) {

            Monograph dbMonograph = monographRepository.findByScopusID(monograph.getScopusID());

            if (dbMonograph != null) {
                System.out.println("Monograph sa ID-jem: " + dbMonograph.getScopusID() + " vec postoji u bazi!");
            }

            if (dbMonograph == null) {
                try {
                    monographRepository.save(monograph);
                    System.out.println("(" + i + "/" + monographs.size() + ") Monograph sa scopusID-jem: " + monograph.getScopusID() + " uspesno snimljen u bazu!");
                } catch (Exception e) {
                    e.printStackTrace();

                    System.out.println("Ako je neka od duzina presla maksimalnu duzinu onda se tu desio exception," +
                            "ako nije onda je nesto drugo u pitanju");
                    System.out.println("Maksimalna duzina za title je 500");
                    System.out.println("Maksimalna duzina za abstracts je 4500");
                    System.out.println("Maksimalna duzina za keywords je 800");
                    System.out.println("ScopusID: " + monograph.getScopusID());
                    if (monograph.getTitleEng() != null) {
                        System.out.println("Title eng length: " + monograph.getTitleEng().length());
                    }
                    if (monograph.getTitleOth() != null) {
                        System.out.println("Title oth length: " + monograph.getTitleOth().length());
                    }
                    if (monograph.getAbstractEng() != null) {
                        System.out.println("Abstracts eng length: " + monograph.getAbstractEng().length());
                    }
                    if (monograph.getAbstractOth() != null) {
                        System.out.println("Abstracts oth length: " + monograph.getAbstractOth().length());
                    }
                    if (monograph.getKeywordsEng() != null) {
                        System.out.println("Keywords eng length: " + monograph.getKeywordsEng().length());
                    }
                    if (monograph.getKeywordsOth() != null) {
                        System.out.println("Keywords oth length: " + monograph.getKeywordsOth().length());
                    }
                    System.exit(-1);
                }
            }
            i++;
        }
    }

}
