package com.ftninformatika.util.importer;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ImportUtility {

    /*Prolazimo kroz listu svih autora koji pripadaju univerzitetu u Novom Sadu
    * i izvlacimo idijeve institucija kojima oni pripadaju. To su podinstitucije
    * UNS-a i onda te id-jeve upisujemo u fajl. Set je tu da nam omoguci da nemamo
    * dva ista id-ja upisana u fajl.*/
    public static void upisiIdjeveInstitucijaUFajl() {

        Set<String> setOfAffiliationIds = new HashSet<>();
        ArrayList<String> listOfAffiliationIds = ReadWriteFile.ucitajIdjeveInstitucijaIzAuthorFajla();

        for (String id : listOfAffiliationIds) {
            setOfAffiliationIds.add(id);
        }

        for (String s : setOfAffiliationIds) {
            ReadWriteFile.snimanjeScopusIdjevaInstitucijaUFajl(s);
        }

    }

    /*Prolazimo kroz listu id-jeva institucija koje smo izvukli iz autora koje
    * smo dobili preko UNS institucije. Saljemo zahtev za svaku instituciju i
    * upisujemo njen naziv u scopus-affiliation-name fajl*/
    public static void upisiInstitucijeUFajl() {

        ArrayList<String> listaIdjevaInstitucija;
        listaIdjevaInstitucija = ReadWriteFile.ucitajScopusIdjeveInstitucijaIzFajla();

        for (String id : listaIdjevaInstitucija) {
            ScopusImportUtility.getAffiliation(id);
        }
    }

    /*Prolazimo kroz listu id-jeva autora koje smo dobili preko UNS institucije. Saljemo
    * zahtev za svakog autora i njegove podatke upisujemo u scopus-authors.csv fajl*/
    public static void upisiAutoreUFajl() {

        ArrayList<String> listaIdjevaAutora;
        listaIdjevaAutora = ReadWriteFile.ucitajScopusIdjeveAutoraIzFajla();

        for (String authorId : listaIdjevaAutora) {
            ScopusImportUtility.getAuthor(authorId);
        }
    }


    public static void povuciDokumenteSaScopusa() {
        ArrayList<String> listaIdjevaDokumentata;
        listaIdjevaDokumentata = ReadWriteFile.ucitajScopusIdjeveDokumenataIzFajla();

        for (String documentId : listaIdjevaDokumentata) {
            ScopusImportUtility.getDocument(documentId);
        }

    }

    /*Izvlacimo iz fajla ID-jeve svih scopus dokumenata i prolazimo kroz listu istih.
    * Ucitavamo svaki dokument iz foldeta 'Documents' pomocu njegovod ID-ja posto
    * naziv svakog scopus dokumenta je njegov ID. Vodimo evidenciju koliko je uspesno,
    * a koliko neuspesno ucitanih dokumenata.
    * Svaki dokument se ucitava kao niz byte-ova koji prebacujemo u String, koji
    * potom prebacujemo u JSONObject koji saljemo  metodi obradiDokument zajedno sa
    * mapom languages-a. Taj dokument cuvamo kao objekt posto ne znamo kog ce tipa
    * biti kada se vrati iz pomenute metode(moze biti paperJournal, paperMonograph
    * ili paperProceedings) */
    public static ArrayList<Object> ucitajDokumenteIzFajlova(Map languages) {
        ArrayList<Object> paperList = new ArrayList<>();
        ArrayList<String> listaIdjevaDokumentata;
        listaIdjevaDokumentata = ReadWriteFile.ucitajScopusIdjeveDokumenataIzFajla();

        int ukupno = 0;
        int uspesno = 0;
        int neuspesno = 0;

        for (String documentId : listaIdjevaDokumentata) {
            ukupno++;
            try {
                byte[] encoded = Files.readAllBytes(Paths.get("Documents/" + documentId));
                String s = new String(encoded, StandardCharsets.UTF_8);
                JSONObject jo = new JSONObject(s);
                try {
                    Object object = ScopusDocumentUtility.obradiDokument(jo, languages);
                    paperList.add(object);
                    uspesno++;
                } catch (UnsupportedScopusDocumentType unsupportedScopusDocumentType) {
                    unsupportedScopusDocumentType.printStackTrace();
                }
            } catch (IOException e) {
                neuspesno++;
                e.printStackTrace();
            }
        }
        System.out.println("Ukupno dokumenata:     " + ukupno);
        System.out.println("Uspesno pronadjeni:    " + uspesno);
        System.out.println("Neuspesno pronadjeni:  " + neuspesno);
        return paperList;
    }

    /*Prolazimo kroz sve json fajlove dokumenata i iz istih izvlacimo language. Stavljamo ih
    * u mapu tako sto je xmlLang kljuc, a Language je value. Tu mapu vracamo u kontroler gde
    * prolazimo kroz tu mapu i upisujemo te jezike u bazu. xmlLang je unique tako da ako
    * jezik koji pokusamo da upisemo vec postoji u bazi desice se exception*/
    public static Map<String, String> proveriLanguage() {
        ArrayList<String> listaIdjevaDokumentata;
        listaIdjevaDokumentata = ReadWriteFile.ucitajScopusIdjeveDokumenataIzFajla();

        Map<String, String> languageMap = new HashMap<>();
        for (String documentId : listaIdjevaDokumentata) {
            try {
                byte[] encoded = Files.readAllBytes(Paths.get("Documents/" + documentId));
                String s = new String(encoded, StandardCharsets.UTF_8);
                JSONObject jo = new JSONObject(s);

                try {
                    String xmlLang = jo.getJSONObject("abstracts-retrieval-response").getJSONObject("item").getJSONObject("bibrecord").getJSONObject("head").getJSONObject("citation-info").getJSONObject("citation-language").get("@xml:lang").toString();
                    String language = jo.getJSONObject("abstracts-retrieval-response").getJSONObject("item").getJSONObject("bibrecord").getJSONObject("head").getJSONObject("citation-info").getJSONObject("citation-language").get("@language").toString();
                    languageMap.put(xmlLang, language);
                } catch (JSONException e) {
//                    System.out.println(e);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return languageMap;
    }

}
