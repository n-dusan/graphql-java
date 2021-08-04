package com.ftninformatika.util.importer;

import com.ftninformatika.cris.model.Person;
import com.ftninformatika.cris.repository.PersonRepository;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScopusImportUtility {

    public static Map<String, String> headers = new HashMap<String, String>();

    private static boolean authenticated = false;


    public static boolean authenticate() throws JSONException {
        if (authenticated) {
            return true;
        }
        String url = "https://api.elsevier.com/authenticate?platform=SCOPUS";
        HttpResponse<JsonNode> jsonResponse = null;
        try {
            jsonResponse = Unirest.get(url)
                    .headers(headers)
                    .asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        if (jsonResponse.getStatus() == 300) {
            JSONObject jo;
            String idString = "";
            try {
                jo = new JSONObject(jsonResponse.getBody().toString());
                idString = jo.getJSONObject("authenticate-response").getJSONObject("pathChoices").getJSONArray("choice").getJSONObject(1).get("@id").toString();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            int choice = Integer.parseInt(idString);
            boolean success = getAuthtoken(choice, headers);
            if (success) {
                authenticated = true;
            }
        } else if (jsonResponse.getStatus() == 200) {
            authenticated = true;
        } else {
            System.out.println(jsonResponse.getStatus());
        }
        return authenticated;
    }



    public static boolean getAuthtoken(int choice, Map headers) throws JSONException {
        String url = "http://api.elsevier.com/authenticate?platform=SCOPUS&choice=" + choice;
        HttpResponse<JsonNode> jsonResponse = null;
        try {
            jsonResponse = Unirest.get(url)
                    .headers(headers)
                    .asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        if (jsonResponse.getStatus() == 200) {
            JSONObject jo = new JSONObject(jsonResponse.getBody().toString());
            String authtoken = jo.getJSONObject("authenticate-response").getString("authtoken");
            headers.put("X-ELS-Authtoken", authtoken);
            return true;
        } else {
            System.out.println(jsonResponse.getStatus());
        }
        return false;
    }

    public static void getAuthor(String authorID) throws JSONException {
        authenticate();
        String url = "https://api.elsevier.com/content/author/author_id/" + authorID;
        HttpResponse<JsonNode> response = null;
        try {
            response = Unirest.get(url)
                    .headers(headers)
                    .asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        if (response.getStatus() == 200) {
//            JSONObject jo = new JSONObject(response.getBody().toString());
//            String surname = jo.getJSONArray("author-retrieval-response").getJSONObject(0).getJSONObject("author-profile").getJSONObject("preferred-name").get("surname").toString();
//            String givenName = jo.getJSONArray("author-retrieval-response").getJSONObject(0).getJSONObject("author-profile").getJSONObject("preferred-name").get("given-name").toString();
//            String affiliationCurrentId = jo.getJSONArray("author-retrieval-response").getJSONObject(0).getJSONObject("affiliation-current").get("@id").toString();
//            String scopusAuthorId = jo.getJSONArray("author-retrieval-response").getJSONObject(0).getJSONObject("coredata").get("eid").toString().substring(7).toString();
//            ReadWriteFile.upisiAutoraUFajl(surname, givenName, affiliationCurrentId, scopusAuthorId);

            System.out.println(response.getBody());
        } else {
            System.out.println(response.getStatus());
        }
    }


    public static void getAffiliation(String affiliationID) throws JSONException {
        authenticate();
        String url = "https://api.elsevier.com/content/affiliation/affiliation_id/" + affiliationID;
        HttpResponse<JsonNode> response = null;
        try {
            response = Unirest.get(url)
                    .headers(headers)
                    .asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        if (response.getStatus() == 200){
//            JSONObject jo = new JSONObject(response.getBody().toString());
//            String affiliationName = jo.getJSONObject("affiliation-retrieval-response").get("affiliation-name").toString();
//            ReadWriteFile.upisiNazivInstitucijuUFajl(affiliationName);

            System.out.println(response.getBody());
        } else {
            System.out.println(response.getStatus());
        }
    }


    public static void getDocumentsByAuthor(String authorID) {
        authenticate();
        String url = "https://api.elsevier.com/content/search/scopus?query=AU-ID("+ authorID +")&field=dc:identifier&count=10";
        HttpResponse<JsonNode> response = null;
        try {
            response = Unirest.get(url)
                    .headers(headers)
                    .asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        if (response.getStatus() == 200) {
            System.out.println(response.getBody());
        } else {
            System.out.println(response.getStatus());
        }
    }


    public static void getDocument(String documentID) {
        authenticate();
        String url = "https://api.elsevier.com/content/abstract/scopus_id/" + documentID;
        HttpResponse<JsonNode> response = null;
        try {
            response = Unirest.get(url)
                    .headers(headers)
                    .asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        if (response.getStatus() == 200) {

            JSONObject jo = new JSONObject(response.getBody().toString());
            ReadWriteFile.upisiJsonDokumentUTxtFajl(jo.toString(), documentID);

//            System.out.println(response.getBody());

        } else {
            System.out.println("+++++++++++++++++++");
            System.out.println(response.getStatus());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
            System.out.println("+++++++++++++++++++");
        }

    }

//    public static void getDocumentsByAffiliation(String affiliationID) {
//        authenticate();
//        String url = "http://api.elsevier.com/content/search/scopus?query=AF-ID("+ affiliationID +")&field=dc:identifier&start=0&count=10&date=2016";
//        HttpResponse<JsonNode> response = null;
//        try {
//            response = Unirest.get(url)
//                    .headers(headers)
//                    .asJson();
//        } catch (UnirestException e) {
//            e.printStackTrace();
//        }
//        if (response.getStatus() == 200) {
//            System.out.println(response.getBody());
////            JSONObject jo = new JSONObject(response.getBody().toString());
////            for (int i= 0; i<200; i++) {
////                String SCOPUS_ID = jo.getJSONObject("search-results").getJSONArray("entry").getJSONObject(i).get("dc:identifier").toString();
////                ReadWriteFile.snimanjeScopusIdjevaRadovaUFajl(SCOPUS_ID.substring(10));
////            }
//        } else {
//            System.out.println(response.getBody());
//            System.out.println(response.getStatus());
//        }
//    }

    public static void getDocumentsByAffiliation(String affiliationID) {
        authenticate();
        int year = 2018;
        int brojDokumenataUGodini = 0;
        int ukupnoDokumenata = 0;
        while (year > 1960) {

            String url = "https://api.elsevier.com/content/search/scopus?query=AF-ID(60068801)&field=dc:identifier&start=0&count=10&date=" + year;
            HttpResponse<JsonNode> response = null;
            try {
                response = Unirest.get(url)
                        .headers(headers)
                        .asJson();
            } catch (UnirestException e) {
                e.printStackTrace();
            }
            if (response.getStatus() == 200) {
//            System.out.println(response.getBody());
                JSONObject jo = new JSONObject(response.getBody().toString());
                brojDokumenataUGodini = Integer.parseInt(jo.getJSONObject("search-results").get("opensearch:totalResults").toString());

                for (int i=0; i<brojDokumenataUGodini; i+=200) {
                    String ulrYear = "https://api.elsevier.com/content/search/scopus?query=AF-ID(60068801)&field=dc:identifier&start="+ i +"&count=200&date=" + year;
                    ScopusImportUtility.getDocumentsByAffiliationByYear(affiliationID, ulrYear);
                }


                String value = year + ": " + brojDokumenataUGodini;
                ReadWriteFile.snimanjeBrojaDokumenataPoGodiniUFajl(value);
            } else {
                System.out.println(response.getBody());
                System.out.println(response.getStatus());
            }
            ukupnoDokumenata += brojDokumenataUGodini;
            year--;
        }
        ReadWriteFile.snimanjeBrojaDokumenataPoGodiniUFajl("Ukupno dokumenata: " + ukupnoDokumenata);
    }

    public static void getDocumentsByAffiliationByYear(String affiliationID, String url) {

        HttpResponse<JsonNode> response = null;
        try {
            response = Unirest.get(url)
                    .headers(headers)
                    .asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        if (response.getStatus() == 200) {
            System.out.println(response.getBody());
            JSONObject jo = new JSONObject(response.getBody().toString());
            for (int i= 0; i<200; i++) {
                String SCOPUS_ID = null;
                try {
                    SCOPUS_ID = jo.getJSONObject("search-results").getJSONArray("entry").getJSONObject(i).get("dc:identifier").toString();
                } catch (JSONException e) {
                    break;
                }
                ReadWriteFile.snimanjeScopusIdjevaRadovaUFajl(SCOPUS_ID.substring(10));
            }
        } else {
            System.out.println(response.getBody());
            System.out.println(response.getStatus());
        }
    }




    public static void getAuthorsByAffiliation(String affiliationID) {
        authenticate();
        String url = "http://api.elsevier.com/content/search/author?query=AF-ID("+ affiliationID +")&field=dc:identifier&start=4600&count=200";
        HttpResponse<JsonNode> response = null;
        try {
            response = Unirest.get(url)
                    .headers(headers)
                    .asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        if (response.getStatus() == 200) {
            System.out.println(response.getBody());
            JSONObject jo = new JSONObject(response.getBody().toString());
            System.out.println(response.getBody());
//            for (int i= 0; i<200; i++) {
//                String SCOPUS_ID = jo.getJSONObject("search-results").getJSONArray("entry").getJSONObject(i).get("dc:identifier").toString();
//                ReadWriteFile.snimanjeScopusIdjevaAutoraUFajl(SCOPUS_ID.substring(10));
//            }
        } else {
            System.out.println(response.getBody());
            System.out.println(response.getStatus());
        }
    }

}
