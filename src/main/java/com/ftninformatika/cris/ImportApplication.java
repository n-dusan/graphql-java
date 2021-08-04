package com.ftninformatika.cris;

import com.ftninformatika.util.importer.ImportUtility;
import com.ftninformatika.util.importer.ReadWriteFile;
import com.ftninformatika.util.importer.ScopusImportUtility;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.http.HttpHost;
import org.json.JSONException;

public class ImportApplication {

    public static void main(String[] args) throws JSONException, UnirestException {

        //old API key - 	2af9ded2f6e1b20cfb33af2333cfffcd //f274b2e4833c9858fbf6e80a2ffcbdc2
        ScopusImportUtility.headers.put("X-ELS-APIKey", "2af9ded2f6e1b20cfb33af2333cfffcd");
        ScopusImportUtility.headers.put("Accept", "application/json");

        Unirest.setProxy(new HttpHost("proxy.uns.ac.rs", 8080));
        ScopusImportUtility.authenticate();

        final String BRANKO_ID = "55948342700";
        final String UNS_ID = "60068801";
//        final String PAPER_ID = "77950189277";
        final String PAPER_ID = "85028960490";

//        ScopusImportUtility.getAuthor(BRANKO_ID);
//        ScopusImportUtility.getAffiliation(UNS_ID);
//        ScopusImportUtility.getDocumentsByAuthor(BRANKO_ID);
//        ScopusImportUtility.getDocument(PAPER_ID);
//        ScopusImportUtility.getDocumentsByAffiliation(UNS_ID);
//        ScopusImportUtility.getAuthorsByAffiliation(UNS_ID);
//
//        ImportUtility.upisiAutoreUFajl();
//        ImportUtility.upisiIdjeveInstitucijaUFajl();
//        ImportUtility.upisiInstitucijeUFajl();

        ImportUtility.povuciDokumenteSaScopusa();

        ReadWriteFile.ucitajDokumentaIzFajla();


    }

}

// Videti sa Brankom za issn
