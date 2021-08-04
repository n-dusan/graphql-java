package com.ftninformatika.util.importer;

import com.ftninformatika.cris.model.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;

public class ScopusDocumentUtility {

    static List<Person> listaSvihAutora = new ArrayList<>();

    static List<PaperJournalAuthors> listaSvihPaperJournalAuthorEntuteta = new ArrayList<>();

    static List<PaperMonographAuthors> listaSvihPaperMonographAuthorEntuteta = new ArrayList<>();

    static List<PaperProceedingsAuthors> listaSvihPaperProceedingAuthorEntuteta = new ArrayList<>();

    static List<MonographAuthors> listaSvihMonographAuthorEntuteta = new ArrayList<>();

    /*Za ovu metodu mozemo reci da je najbitnija u nasem importeru posto najtezi deo posla, a to je
    * parsiranje json dokumenata i razvrstavanje istih obavlja ona. Prvi deo metode izvlaci potrebne
    * atribute iz json dokumenta. Problem tih json dokumenata koje dobijamo sa skopusa je to sto nisu
    * uniformni i desava se da ne samo da neki atributi ne postoje, nego se u nekim slucajevima nesto
    * dobija kao lista, nekada kao jedan entitet, nekada ne postoji.*/
    static Object obradiDokument(JSONObject jo, Map languages) throws UnsupportedScopusDocumentType {

        String type;

        try {
            type = jo.getJSONObject("abstracts-retrieval-response").getJSONObject("coredata").get("srctype").toString();
        } catch(JSONException e) {
            type = null;
        }

        if(type == null) {
            return null;
        }

        String scopusID;
        try {
            scopusID = jo.getJSONObject("abstracts-retrieval-response").getJSONObject("coredata").get("eid").toString().substring(7);
        } catch(JSONException e) {
            scopusID = null;
        }

        String language;
        try {
            language = jo.getJSONObject("abstracts-retrieval-response").getJSONObject("item").getJSONObject("bibrecord").getJSONObject("head").getJSONObject("citation-info").getJSONObject("citation-language").get("@language").toString();
        } catch (JSONException e) {
            language = null;
        }

        String xmlLang;
        try {
            xmlLang = jo.getJSONObject("abstracts-retrieval-response").getJSONObject("item").getJSONObject("bibrecord").getJSONObject("head").getJSONObject("citation-info").getJSONObject("citation-language").get("@xml:lang").toString();
        } catch (JSONException e) {
            xmlLang = null;
        }

        String title;
        try {
            title= jo.getJSONObject("abstracts-retrieval-response").getJSONObject("item").getJSONObject("bibrecord").getJSONObject("head").get("citation-title").toString();
        } catch (JSONException e) {
            title = null;
        }

        String abstracts;
        try {
            abstracts = jo.getJSONObject("abstracts-retrieval-response").getJSONObject("item").getJSONObject("bibrecord").getJSONObject("head").get("abstracts").toString();
        } catch (JSONException e) {
            abstracts = null;
        }

        String keywordsEng = "";
        try {
            JSONArray keywordsJsonArray = jo.getJSONObject("abstracts-retrieval-response").getJSONObject("item").getJSONObject("bibrecord").getJSONObject("head").getJSONObject("citation-info").getJSONObject("author-keywords").getJSONArray("author-keyword");
            for (int i = 0; i < keywordsJsonArray.length(); i++) {
                keywordsEng = keywordsEng.concat(keywordsJsonArray.getJSONObject(i).get("$").toString() + ",");
            }
        } catch (JSONException e) {
            keywordsEng = null;
        }

        String volume;
        try {
            volume = jo.getJSONObject("abstracts-retrieval-response").getJSONObject("item").getJSONObject("bibrecord").getJSONObject("head").getJSONObject("source").getJSONObject("volisspag").getJSONObject("voliss").get("@volume").toString();
        } catch (JSONException e) {
            volume = null;
        }

        String number;
        try {
            number = jo.getJSONObject("abstracts-retrieval-response").getJSONObject("item").getJSONObject("bibrecord").getJSONObject("head").getJSONObject("source").getJSONObject("volisspag").getJSONObject("voliss").get("@issue").toString();
        } catch (JSONException e) {
            number = null;
        }

        String startPage;
        try {
            startPage = jo.getJSONObject("abstracts-retrieval-response").getJSONObject("item").getJSONObject("bibrecord").getJSONObject("head").getJSONObject("source").getJSONObject("volisspag").getJSONObject("pagerange").get("@first").toString();
        } catch (JSONException e) {
            startPage = null;
        }

        String endPage;
        try {
            endPage = jo.getJSONObject("abstracts-retrieval-response").getJSONObject("item").getJSONObject("bibrecord").getJSONObject("head").getJSONObject("source").getJSONObject("volisspag").getJSONObject("pagerange").get("@last").toString();
        } catch (JSONException e) {
            endPage = null;
        }

        String year;
        try {
            year = jo.getJSONObject("abstracts-retrieval-response").getJSONObject("item").getJSONObject("bibrecord").getJSONObject("head").getJSONObject("source").getJSONObject("publicationyear").get("@first").toString();
        } catch (JSONException e) {
            year = null;
        }

        String issn;
        try {
            issn = jo.getJSONObject("abstracts-retrieval-response").getJSONObject("item").getJSONObject("bibrecord").getJSONObject("head").getJSONObject("source").get("issn").toString();
        } catch (JSONException e) {
            issn = null;
        }

        String isbn;
        try {
            isbn = jo.getJSONObject("abstracts-retrieval-response").getJSONObject("item").getJSONObject("bibrecord").getJSONObject("head").getJSONObject("source").get("isbn").toString();
        } catch (JSONException e) {
            isbn = null;
        }

        String sourceTitle;
        try {
            sourceTitle = jo.getJSONObject("abstracts-retrieval-response").getJSONObject("item").getJSONObject("bibrecord").getJSONObject("head").getJSONObject("source").get("sourcetitle").toString();
        } catch (JSONException e) {
            sourceTitle = null;
        }

        String codeTypeB;
        try {
            codeTypeB = jo.getJSONObject("abstracts-retrieval-response").getJSONObject("item").getJSONObject("bibrecord").getJSONObject("head").getJSONObject("citation-info").getJSONObject("citation-type").get("@code").toString();
        } catch (JSONException e) {
            codeTypeB = null;
        }


        /*Ukoliko je type "j" ili "d", dokument ce biti paperJournal. Pevo iz tog
        * paperJournala izvlacimo Jornal, kreiramo objekat i posle nakon kreiranja
        * paperJoutnala ga setujemo tom paperJournalu*/
        if (type.equals("j") || type.equals("d")) {

            String eissn;
            String pissn;
            Journal journal = null;
            if (issn != null) {
                try {
                    JSONArray issnJA = new JSONArray(issn);
                    eissn = issnJA.getJSONObject(0).get("$").toString();
                    pissn = issnJA.getJSONObject(1).get("$").toString();
                    journal = new Journal();
                    journal.setEissn(eissn);
                    journal.setPissn(pissn);
                    if (sourceTitle != null) {
                        journal.setNameEng(sourceTitle);
                    }
                } catch (JSONException e) {
                    JSONObject issnJO = null;
                    /*Ovaj try/catch blok mora zato sto je negde issn ipisan samo kao broj, a ne pise kog je tipa*/
//                    TODO Uzmi pa preproj koliko dokumenata ima ovakav issn, pa ako je minimalan broj zanemati to slobodno
                    try {
                        issnJO = new JSONObject(issn);      // zbog ove linije je try/catch blok

                        journal = new Journal();
                        if (issnJO.get("@type").toString().equals("electronic")) {
                            eissn = issnJO.get("$").toString();
                            journal.setEissn(eissn);
                        } else if (issnJO.get("@type").toString().equals("print")) {
                            pissn = issnJO.get("$").toString();
                            journal.setPissn(pissn);
                        }
                        if (sourceTitle != null) {
                            journal.setNameEng(sourceTitle);
                        }

                    } catch (JSONException e1) {
                        journal = null;
//                        e1.printStackTrace();
                    }


                }
            }

            PaperJournal paperJournal = new PaperJournal();
            paperJournal.setJournal(journal);
            paperJournal.setScopusID(scopusID);

            if (xmlLang != null) {
                paperJournal.setLanguage((Language)languages.get(xmlLang));
            }
            if (xmlLang == null || xmlLang.equals("eng")) {
                paperJournal.setTitleEng(title);
                paperJournal.setAbstractEng(abstracts);
            } else {
                paperJournal.setTitleOth(title);
                paperJournal.setAbstractOth(abstracts);
            }
            if (keywordsEng != null) {
                paperJournal.setKeywordsEng(keywordsEng);
            }
            if (volume != null) {
                paperJournal.setVolume(volume);
            }
            if (number != null) {
                paperJournal.setNumber(number);
            }
            if (startPage != null) {
                paperJournal.setStartPage(startPage);
            }
            if (endPage != null) {
                paperJournal.setEndPage(endPage);
            }
            if (year != null) {
                paperJournal.setYear(year);
            }

            List<Map<String, String>> listaPodatakaZaDocumentAuthors = srediAutoreIVezuIzmedjuAutoraIRadova(jo);

            for (Map<String, String> podaciZaDocumentAuthors : listaPodatakaZaDocumentAuthors) {

                String idSC = podaciZaDocumentAuthors.get("authorScopusId");
                Integer numOrder = Integer.parseInt(podaciZaDocumentAuthors.get("numOrder"));
                String firstName = podaciZaDocumentAuthors.get("firstName");
                String middleName = podaciZaDocumentAuthors.get("middleName");
                String lastName = podaciZaDocumentAuthors.get("lastName");
                String email = podaciZaDocumentAuthors.get("email");
                String affiliation = podaciZaDocumentAuthors.get("affiliation");

                PaperJournalAuthors paperJournalAuthor = new PaperJournalAuthors();
                paperJournalAuthor.setNumOrder(numOrder);
                paperJournalAuthor.setFirstName(firstName);
                paperJournalAuthor.setMiddleName(middleName);
                paperJournalAuthor.setLastName(lastName);
                paperJournalAuthor.setEmail(email);
                paperJournalAuthor.setAffiliations(affiliation);

                Person person = new Person();
                person.setScopusID(idSC);
                person.setFirstName(firstName);
                person.setMiddleName(middleName);
                person.setLastName(lastName);
                person.setEmail(email);

                paperJournalAuthor.setPerson(person);
                paperJournalAuthor.setPaperJournal(paperJournal);

                listaSvihAutora.add(person);
                listaSvihPaperJournalAuthorEntuteta.add(paperJournalAuthor);
            }

            return paperJournal;


            /*Ukoliko je type "k" ili ukoliko je type "b" i codeTypeB je "ch", onda ce biti paperMonograph.
            * Prvo iz tog paperMonogtapha izvlacimo MonographOfPapers i onda paperMonograph-u setujemo
            * taj monographOfPapers*/
        } else if(type.equals("k") || (type.equals("b") && codeTypeB != null && codeTypeB.equals("ch"))) {

            MonographOfPapers monographOfPapers = new MonographOfPapers();

            if (issn != null) {
//                monographOfPapers.setEditionISSN(issn);
            }
            if (isbn != null) {
                monographOfPapers.setIsbn(isbn);
            }
            monographOfPapers.setEditionTitle(sourceTitle);


            PaperMonograph paperMonograph = new PaperMonograph();
            paperMonograph.setMonographOfPapers(monographOfPapers);
            paperMonograph.setScopusID(scopusID);

            if (xmlLang != null) {
                paperMonograph.setLanguage((Language)languages.get(xmlLang));
            }
            if (xmlLang == null || xmlLang.equals("eng")) {
                paperMonograph.setTitleEng(title);
                paperMonograph.setAbstractEng(abstracts);
            } else {
                paperMonograph.setTitleOth(title);
                paperMonograph.setAbstractOth(abstracts);
            }
            if (keywordsEng != null) {
                paperMonograph.setKeywordsEng(keywordsEng);
            }
            if (startPage != null) {
                paperMonograph.setStartPage(startPage);
            }
            if (endPage != null) {
                paperMonograph.setEndPage(endPage);
            }

            List<Map<String, String>> listaPodatakaZaDocumentAuthors = srediAutoreIVezuIzmedjuAutoraIRadova(jo);

            for (Map<String, String> podaciZaDocumentAuthors : listaPodatakaZaDocumentAuthors) {

                String idSC = podaciZaDocumentAuthors.get("authorScopusId");
                Integer numOrder = Integer.parseInt(podaciZaDocumentAuthors.get("numOrder"));
                String firstName = podaciZaDocumentAuthors.get("firstName");
                String middleName = podaciZaDocumentAuthors.get("middleName");
                String lastName = podaciZaDocumentAuthors.get("lastName");
                String email = podaciZaDocumentAuthors.get("email");
                String affiliation = podaciZaDocumentAuthors.get("affiliation");

                PaperMonographAuthors paperMonographAuthors = new PaperMonographAuthors();
                paperMonographAuthors.setNumOrder(numOrder);
                paperMonographAuthors.setFirstName(firstName);
                paperMonographAuthors.setMiddleName(middleName);
                paperMonographAuthors.setLastName(lastName);
                paperMonographAuthors.setEmail(email);
                paperMonographAuthors.setAffiliations(affiliation);

                Person person = new Person();
                person.setScopusID(idSC);
                person.setFirstName(firstName);
                person.setMiddleName(middleName);
                person.setLastName(lastName);
                person.setEmail(email);

                paperMonographAuthors.setPerson(person);
                paperMonographAuthors.setPaperMonograph(paperMonograph);

                listaSvihAutora.add(person);
                listaSvihPaperMonographAuthorEntuteta.add(paperMonographAuthors);
            }

            return paperMonograph;


            /*Ukoliko je type jedan "p" onda ce taj dokument biti paperProceedings. Iz tog
            * dokumenta prvo izvlacimo Proceedings i posle ga setujemo paperProceedings-u.*/
        } else if(type.equals("p")) {

            Proceedings proceedings = new Proceedings();
            if (isbn != null) {
                proceedings.setIsbn(isbn);
            }
            proceedings.setEditionTitle(sourceTitle);

            PaperProceedings paperProceedings = new PaperProceedings();
            paperProceedings.setProceedings(proceedings);
            paperProceedings.setScopusID(scopusID);

            if (xmlLang != null) {
                paperProceedings.setLanguage((Language)languages.get(xmlLang));
            }
            if (xmlLang == null || xmlLang.equals("eng")) {
                paperProceedings.setTitleEng(title);
                paperProceedings.setAbstractEng(abstracts);
            } else {
                paperProceedings.setTitleOth(title);
                paperProceedings.setAbstractOth(abstracts);
            }
            if (keywordsEng != null) {
                paperProceedings.setKeywordsEng(keywordsEng);
            }
            if (startPage != null) {
                paperProceedings.setStartPage(startPage);
            }
            if (endPage != null) {
                paperProceedings.setEndPage(endPage);
            }

            List<Map<String, String>> listaPodatakaZaDocumentAuthors = srediAutoreIVezuIzmedjuAutoraIRadova(jo);

            for (Map<String, String> podaciZaDocumentAuthors : listaPodatakaZaDocumentAuthors) {

                String idSC = podaciZaDocumentAuthors.get("authorScopusId");
                Integer numOrder = Integer.parseInt(podaciZaDocumentAuthors.get("numOrder"));
                String firstName = podaciZaDocumentAuthors.get("firstName");
                String middleName = podaciZaDocumentAuthors.get("middleName");
                String lastName = podaciZaDocumentAuthors.get("lastName");
                String email = podaciZaDocumentAuthors.get("email");
                String affiliation = podaciZaDocumentAuthors.get("affiliation");

                PaperProceedingsAuthors paperProceedingsAuthors = new PaperProceedingsAuthors();
                paperProceedingsAuthors.setNumOrder(numOrder);
                paperProceedingsAuthors.setFirstName(firstName);
                paperProceedingsAuthors.setMiddleName(middleName);
                paperProceedingsAuthors.setLastName(lastName);
                paperProceedingsAuthors.setEmail(email);
                paperProceedingsAuthors.setAffiliations(affiliation);

                Person person = new Person();
                person.setScopusID(idSC);
                person.setFirstName(firstName);
                person.setMiddleName(middleName);
                person.setLastName(lastName);
                person.setEmail(email);

                paperProceedingsAuthors.setPerson(person);
                paperProceedingsAuthors.setPaperProceedings(paperProceedings);

                listaSvihAutora.add(person);
                listaSvihPaperProceedingAuthorEntuteta.add(paperProceedingsAuthors);
            }

            return paperProceedings;

            /*Ukoliko je type jednak "b", taj dokument je monografija.*/
        } else if(type.equals("b")) {

            String code = null;
            try {
                code = jo.getJSONObject("abstracts-retrieval-response").getJSONObject("item").getJSONObject("bibrecord").getJSONObject("head").getJSONObject("citation-info").getJSONObject("citation-type").get("@code").toString();

                if (code.equals("bk")) {

                    Monograph monograph = new Monograph();
                    monograph.setScopusID(scopusID);

                    if (isbn != null) {
                        monograph.setIsbn(isbn);
                    }
                    if (xmlLang != null) {
                        monograph.setLanguage((Language)languages.get(xmlLang));
                    }
                    if (xmlLang == null || xmlLang.equals("eng")) {
                        monograph.setTitleEng(title);
                        monograph.setAbstractEng(abstracts);
                    } else {
                        monograph.setTitleOth(title);
                        monograph.setAbstractOth(abstracts);
                    }
                    if (keywordsEng != null) {
                        monograph.setKeywordsEng(keywordsEng);
                    }
                    if (year != null) {
                        monograph.setYear(year);
                    }

                    List<Map<String, String>> listaPodatakaZaDocumentAuthors = srediAutoreIVezuIzmedjuAutoraIRadova(jo);

                    for (Map<String, String> podaciZaDocumentAuthors : listaPodatakaZaDocumentAuthors) {

                        String idSC = podaciZaDocumentAuthors.get("authorScopusId");
                        Integer numOrder = Integer.parseInt(podaciZaDocumentAuthors.get("numOrder"));
                        String firstName = podaciZaDocumentAuthors.get("firstName");
                        String middleName = podaciZaDocumentAuthors.get("middleName");
                        String lastName = podaciZaDocumentAuthors.get("lastName");
                        String email = podaciZaDocumentAuthors.get("email");
                        String affiliation = podaciZaDocumentAuthors.get("affiliation");

                        MonographAuthors monographAuthors = new MonographAuthors();
                        monographAuthors.setNumOrder(numOrder);
                        monographAuthors.setFirstName(firstName);
                        monographAuthors.setMiddleName(middleName);
                        monographAuthors.setLastName(lastName);
                        monographAuthors.setEmail(email);
                        monographAuthors.setAffiliations(affiliation);

                        Person person = new Person();
                        person.setScopusID(idSC);
                        person.setFirstName(firstName);
                        person.setMiddleName(middleName);
                        person.setLastName(lastName);
                        person.setEmail(email);

                        monographAuthors.setPerson(person);
                        monographAuthors.setMonograph(monograph);

                        listaSvihAutora.add(person);
                        listaSvihMonographAuthorEntuteta.add(monographAuthors);
                    }

                    return monograph;

                } else if(code.equals("ed")) {
//                    System.out.println("***********");
//                    System.out.println(jo);
//                    System.out.println("***********");
                }


            } catch (JSONException e) {
                /*Ako ne moze da pronadje ["citation-type"] onda ulazi u ovaj catch blok. Samo dva dokumenta nemaju ["citation-type"] a to su 0028562778 i 0020441374*/
//                TODO Pogledati sta sa ova dva dokumenta, tj gde ih smestiti
//                System.out.println(scopusID);
//                e.printStackTrace();
            }



            return null;

        } else {
//            throw new UnsupportedScopusDocumentType(type + " tip ne spada u tri tipa za koje je napravljeno snimanje u bazu! " +
//                    "Odraditi i obradu za tip  " + type + ". scopusId dokumenta: " + scopusID);
//            ove dve linije iznad odkomentarisati i obrisari ovaj return null ispid(sada je zakomentarisamo da me ne bombarduje svaki put)
            return null;
        }

    }

    private static List<Map<String, String>> srediAutoreIVezuIzmedjuAutoraIRadova(JSONObject jo) {

        List<Map<String, String>> listaPodatakaZaDocumentAuthors = new ArrayList<>();

        try {
            /*Snimamo vise afiliacija sa jednim ili vise autora*/
            listaPodatakaZaDocumentAuthors = viseAfiliacijaSaJednimIliViseAutora(jo);

        } catch (JSONException e) {

//            System.out.println(e);   //Treba uvek da ispise: "rg.json.JSONException: JSONObject["author-group"] is not a JSONArray."
            try {
                /*Snimamo jednu affiliaciju sa vise autora*/
                listaPodatakaZaDocumentAuthors = jednaAfiliacijaSaViseAutora(jo);
            } catch (JSONException ee) {

//                System.out.println(ee);   // Treba uvek da ispise: "org.json.JSONException: JSONObject["author"] is not a JSONArray."
                try {
                    /*Snimamo jednu affiliaciju sa jednim autorom*/
                    Map<String, String> podaciZaDocumentAuthors = jednaAffiliacijaIjedanAutor(jo);
                    listaPodatakaZaDocumentAuthors.add(podaciZaDocumentAuthors);
                } catch (JSONException e1) {
                    e1.printStackTrace(); //Ovo odkomentarisi kada zavrsis, to je krajnja provera i mora da prodje
                }
            }
        }
        return  listaPodatakaZaDocumentAuthors;
    }

    private static List<Map<String, String>> viseAfiliacijaSaJednimIliViseAutora(JSONObject jo) throws JSONException {
        List<Map<String, String>> listaPodatakaZaDocumentAuthors = new ArrayList<>();
        List<Map<String, String>> listaPodatakaZaDocumentAuthorsTemp1;
        List<Map<String, String>> listaPodatakaZaDocumentAuthorsTemp2;

        JSONArray affiliationGropuArray = jo.getJSONObject("abstracts-retrieval-response").getJSONObject("item").getJSONObject("bibrecord").getJSONObject("head").getJSONArray("author-group");

        for (int i = 0; i < affiliationGropuArray.length(); i++) {

            /*U samo jednom dokumentu se desilo da u nizu author-group jedan element je null,
            * i zbog toga radimo ovu proveru*/
            if (!affiliationGropuArray.get(i).toString().equals("null")) {
                JSONObject affiliationGropuObject =  affiliationGropuArray.getJSONObject(i);

            /*Desi se da u nizu objekata koji sadrze autore i institucije imamo na kraju objekat collaboration i tu nam puca program
            * Tako da ako naidjemo na collaboration treba da samo nastavimo dalje u petlji*/
                try {
                    affiliationGropuObject.get("collaboration");
                    continue;
                } catch (JSONException e) {
                    JSONObject affiliationJO = null;
                    try {
                        affiliationJO = affiliationGropuObject.getJSONObject("affiliation");
                        if (imaAffiliacijeUAuthorGroup(affiliationGropuObject, affiliationJO) != null) {
                            listaPodatakaZaDocumentAuthorsTemp1 = imaAffiliacijeUAuthorGroup(affiliationGropuObject, affiliationJO);
                            for (Map<String, String> mapa : listaPodatakaZaDocumentAuthorsTemp1) {
                                listaPodatakaZaDocumentAuthors.add(mapa);
                            }
                        }
                    } catch (JSONException ee) {
                /*U nekom author-group nema affiliacije, vec samo autora*/
                        listaPodatakaZaDocumentAuthorsTemp2 = nemaAffiliacijeUAuthorGrop(affiliationGropuObject);
                        for (Map<String, String> mapa : listaPodatakaZaDocumentAuthorsTemp2) {
                            listaPodatakaZaDocumentAuthors.add(mapa);
                        }
                    }
                }
            }
        }
        return listaPodatakaZaDocumentAuthors;
    }

    private static List<Map<String, String>> imaAffiliacijeUAuthorGroup(JSONObject affiliationGropuObject, JSONObject affiliationJO) {
        List<Map<String, String>> listaPodatakaZaDocumentAuthors = new ArrayList<>();

        try {
            JSONArray authorsJsonArray = affiliationGropuObject.getJSONArray("author");
            List<Map<String, String>> list1 = jednaAfiliacijaIzNizaSaViseAutora(affiliationJO, authorsJsonArray);
            for (Map<String, String> mapa : list1) {
                listaPodatakaZaDocumentAuthors.add(mapa);
            }

        } catch (JSONException e) {
            /*Nekada se desi da u nizu gde su autor i afiliacija par nemamo autora vec samo afiliaciju(sto nema logike)
            * Tada cemo vratiti null*/
            if (e.toString().contains("JSONObject[\"author\"] not found")) {
                return null;
            }
//                System.out.println(e);    //Ovo odkomentarisi kada budes proveravao i onih 3000 preostalih radova. Treba uvek da ispise: "org.json.JSONException: JSONObject["author"] is not a JSONArray."
            JSONObject authorJO = affiliationGropuObject.getJSONObject("author");
            Map<String, String> mapa = jednaAffiliacijaIzNizaIjedanAutor(affiliationJO, authorJO);
            listaPodatakaZaDocumentAuthors.add(mapa);
        }
        return listaPodatakaZaDocumentAuthors;
    }

    private static List<Map<String, String>> nemaAffiliacijeUAuthorGrop(JSONObject affiliationGropuObject){
        List<Map<String, String>> listaPodatakaZaDocumentAuthors = new ArrayList<>();

        try {
            JSONArray authorsJsonArray = affiliationGropuObject.getJSONArray("author");
            List<Map<String, String>> list1 = jednaAfiliacijaIzNizaJeNullSaViseAutora(authorsJsonArray);
            for (Map<String, String> mapa : list1) {
                listaPodatakaZaDocumentAuthors.add(mapa);
            }

        } catch (JSONException e) {
//                System.out.println(e);    //Ovo odkomentarisi kada budes proveravao i onih 3000 preostalih radova. Treba uvek da ispise: "org.json.JSONException: JSONObject["author"] is not a JSONArray."
            JSONObject authorJO = affiliationGropuObject.getJSONObject("author");
            Map<String, String> mapa = jednaAffiliacijaIzNizaJeNullIjedanAutor(authorJO);
            listaPodatakaZaDocumentAuthors.add(mapa);
        }
        return listaPodatakaZaDocumentAuthors;
    }

    private static Map<String, String> jednaAffiliacijaIzNizaJeNullIjedanAutor(JSONObject authorJO) throws  JSONException{
        return dobaviPotrebnePodatkeZaVeznuTabeluIzmedjuAutoraIRadaGdeJeAffNull(authorJO);
    }

    private static List<Map<String, String>> jednaAfiliacijaIzNizaJeNullSaViseAutora(JSONArray authorsJsonArray) throws  JSONException{
        List<Map<String, String>> listaPodatakaZaDocumentAuthors = new ArrayList<>();

        for (int i = 0; i < authorsJsonArray.length(); i++) {
            listaPodatakaZaDocumentAuthors.add(dobaviPotrebnePodatkeZaVeznuTabeluIzmedjuAutoraIRadaGdeJeAffNull(authorsJsonArray.getJSONObject(i)));
        }

        return listaPodatakaZaDocumentAuthors;
    }

    private static HashMap<String, String> dobaviPotrebnePodatkeZaVeznuTabeluIzmedjuAutoraIRadaGdeJeAffNull(JSONObject authorJO){
        HashMap<String, String> mapaPodataka = new HashMap<>();

        String authorScopusId = authorJO.get("@auid").toString();
        mapaPodataka.put("authorScopusId", authorScopusId);

        String numOrder = authorJO.get("@seq").toString();
        mapaPodataka.put("numOrder", numOrder);

        String firstName;
        try {
            firstName = authorJO.get("ce:given-name").toString();
        } catch (JSONException e1) {
            firstName = authorJO.getJSONObject("preferred-name").get("ce:given-name").toString();
        }
        mapaPodataka.put("firstName", firstName);

        String middleName;
        try {
            middleName = authorJO.get("ce:initials").toString();
        } catch (JSONException e) {
            middleName = authorJO.getJSONObject("preferred-name").get("ce:initials").toString();
        }
        mapaPodataka.put("middleName", middleName);

        String lastName;
        try {
            lastName = authorJO.get("ce:surname").toString();
        } catch (JSONException e) {
            lastName = authorJO.getJSONObject("preferred-name").get("ce:surname").toString();
        }
        mapaPodataka.put("lastName", lastName);

        String email;
        try {
            email = authorJO.getJSONObject("ce:e-address").get("$").toString();
        } catch (JSONException e1) {
            email = null;
        }
        mapaPodataka.put("email", email);

        /*Posto nemamo affiliaciju stavicemo samo prazan string*/
        mapaPodataka.put("affiliation", "");

        return mapaPodataka;
    }








    private static Map<String, String> jednaAffiliacijaIzNizaIjedanAutor(JSONObject affiliationJO, JSONObject authorJO) throws  JSONException{
        return dobaviPotrebnePodatkeZaVeznuTabeluIzmedjuAutoraIRada(authorJO, affiliationJO);
    }

    private static List<Map<String, String>> jednaAfiliacijaIzNizaSaViseAutora(JSONObject affiliationJO, JSONArray authorsJsonArray) throws  JSONException{
        List<Map<String, String>> listaPodatakaZaDocumentAuthors = new ArrayList<>();

        for (int i = 0; i < authorsJsonArray.length(); i++) {
            listaPodatakaZaDocumentAuthors.add(dobaviPotrebnePodatkeZaVeznuTabeluIzmedjuAutoraIRada(authorsJsonArray.getJSONObject(i), affiliationJO));
        }

        return listaPodatakaZaDocumentAuthors;
    }

    private static List<Map<String, String>> jednaAfiliacijaSaViseAutora(JSONObject jo) throws  JSONException{
        List<Map<String, String>> listaPodatakaZaDocumentAuthors = new ArrayList<>();

        JSONArray authorsJsonArray = jo.getJSONObject("abstracts-retrieval-response").getJSONObject("item").getJSONObject("bibrecord").getJSONObject("head").getJSONObject("author-group").getJSONArray("author");
        JSONObject affiliationJO =  jo.getJSONObject("abstracts-retrieval-response").getJSONObject("item").getJSONObject("bibrecord").getJSONObject("head").getJSONObject("author-group").getJSONObject("affiliation");

        for (int i = 0; i < authorsJsonArray.length(); i++) {
            listaPodatakaZaDocumentAuthors.add(dobaviPotrebnePodatkeZaVeznuTabeluIzmedjuAutoraIRada(authorsJsonArray.getJSONObject(i), affiliationJO));
        }

        return listaPodatakaZaDocumentAuthors;
    }

    /*Jedan autor i jedna afiliacija. Trebalo bi da je ovo zavrseno*/
    private static Map<String, String> jednaAffiliacijaIjedanAutor(JSONObject jo) throws  JSONException{

        JSONObject authorJO = jo.getJSONObject("abstracts-retrieval-response").getJSONObject("item").getJSONObject("bibrecord").getJSONObject("head").getJSONObject("author-group").getJSONObject("author");
        JSONObject affiliationJO =  jo.getJSONObject("abstracts-retrieval-response").getJSONObject("item").getJSONObject("bibrecord").getJSONObject("head").getJSONObject("author-group").getJSONObject("affiliation");

        return dobaviPotrebnePodatkeZaVeznuTabeluIzmedjuAutoraIRada(authorJO, affiliationJO);
    }

    private static HashMap<String, String> dobaviPotrebnePodatkeZaVeznuTabeluIzmedjuAutoraIRada(JSONObject authorJO, JSONObject affiliationJO){
        HashMap<String, String> mapaPodataka = new HashMap<>();

        String authorScopusId = authorJO.get("@auid").toString();
        mapaPodataka.put("authorScopusId", authorScopusId);

        String numOrder = authorJO.get("@seq").toString();
        mapaPodataka.put("numOrder", numOrder);

        String firstName;
        try {
            firstName = authorJO.get("ce:given-name").toString();
        } catch (JSONException e1) {
            firstName = authorJO.getJSONObject("preferred-name").get("ce:given-name").toString();
        }
        mapaPodataka.put("firstName", firstName);

        String middleName;
        try {
            middleName = authorJO.get("ce:initials").toString();
        } catch (JSONException e) {
            middleName = authorJO.getJSONObject("preferred-name").get("ce:initials").toString();
        }
        mapaPodataka.put("middleName", middleName);

        String lastName;
        try {
            lastName = authorJO.get("ce:surname").toString();
        } catch (JSONException e) {
            lastName = authorJO.getJSONObject("preferred-name").get("ce:surname").toString();
        }
        mapaPodataka.put("lastName", lastName);

        String email;
        try {
            email = authorJO.getJSONObject("ce:e-address").get("$").toString();
        } catch (JSONException e1) {
            email = null;
        }
        mapaPodataka.put("email", email);

        String affiliation = srediAffiliaciju(affiliationJO);
        mapaPodataka.put("affiliation", affiliation);

        return mapaPodataka;
    }


    private static String srediAffiliaciju(JSONObject affJO){
        String affiliation = "";
        try {
            affiliation = affJO.get("ce:text").toString();
        } catch (JSONException e1) {
            try {
                JSONArray organization = affJO.getJSONArray("organization");
                for (int i = 0; i < organization.length(); i++) {
                    affiliation = affiliation.concat(organization.getJSONObject(i).get("$").toString() + ", ");
                }
                affiliation = izvuciPodatkeZaAffiliaciju(affJO, affiliation);
            } catch (JSONException e2) {
                try {
                    affiliation = affiliation.concat(affJO.get("organization").toString() + ", ");
                } catch (JSONException e) {
                    affiliation = affiliation.concat(" ");
                }
                affiliation = izvuciPodatkeZaAffiliaciju(affJO, affiliation);
            }
        }
        return affiliation;
    }

    private static String izvuciPodatkeZaAffiliaciju(JSONObject affJO, String affiliation) {
        try {
            String adresa = affJO.get("address-part").toString();
            affiliation = affiliation.concat(adresa + ", ");

        } catch (JSONException e2) {
//                                e2.printStackTrace();
        }
        try {
            String zipCode = affJO.get("postal-code").toString();
            affiliation = affiliation.concat(zipCode + ", ");
        } catch (JSONException e2) {
//                                e2.printStackTrace();
        }
        try {
            String grad = affJO.get("city").toString();
            affiliation = affiliation.concat(grad + ", ");
        } catch (JSONException e2) {
//                                e2.printStackTrace();
        }
        try {
            String gradAndZipCode = affJO.get("city-group").toString();
            affiliation = affiliation.concat(gradAndZipCode + ", ");
        } catch (JSONException e2) {
//                                e2.printStackTrace();
        }
        try {
            String drzava = affJO.get("country").toString();
            affiliation = affiliation.concat(drzava);
        } catch (JSONException e2) {
//                                e2.printStackTrace();
        }
        return affiliation;
    }

}
