package com.ftninformatika.util.importer;

import com.ftninformatika.cris.model.Person;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ReadWriteFile {

    public static void upisiAutoraUFajl(String surname, String givenName, String AffiliationCurrentId, String scopusAuthorId) {
        try {
            Files.write(Paths.get("scopus-authors.csv"), (surname + "|" + givenName + "|" + AffiliationCurrentId + "|" + scopusAuthorId + "\n").getBytes(), StandardOpenOption.APPEND);

        }catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void upisiJsonDokumentUTxtFajl(String json, String documentID) {
        try {
            Files.write(Paths.get("Documents/" + documentID), (json).getBytes());

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void upisiNazivInstitucijuUFajl(String affiliationName) {
        try {
            Files.write(Paths.get("scopus-affiliation-name.csv"), (affiliationName + "\n").getBytes(), StandardOpenOption.APPEND);

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void snimanjeScopusIdjevaRadovaUFajl(String SCOPUS_ID) {
        try {
            Files.write(Paths.get("scopus-id-radova.csv"), (SCOPUS_ID + "\n").getBytes(), StandardOpenOption.APPEND);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void snimanjeScopusIdjevaAutoraUFajl(String SCOPUS_ID) {
        try {
            Files.write(Paths.get("scopus-id-autora.csv"), (SCOPUS_ID + "\n").getBytes(), StandardOpenOption.APPEND);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void snimanjeScopusIdjevaInstitucijaUFajl(String SCOPUS_ID) {
        try {
            Files.write(Paths.get("scopus-id-institucija.csv"), (SCOPUS_ID + "\n").getBytes(), StandardOpenOption.APPEND);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void snimanjeBrojaDokumenataPoGodiniUFajl(String value) {
        try {
            Files.write(Paths.get("broj-dokumenata-po-godini.txt"), (value + "\n").getBytes(), StandardOpenOption.APPEND);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static ArrayList<String> ucitajScopusIdjeveAutoraIzFajla() {

        ArrayList<String> listaIdjeva = new ArrayList<>();

        // The name of the file to open.
        String fileName = "scopus-id-autora.csv";

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
//                System.out.println(line.toString());
                listaIdjeva.add(line.toString());
            }

            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
        return listaIdjeva;
    }

    public static ArrayList<String> ucitajScopusIdjeveInstitucijaIzFajla() {

        ArrayList<String> listaIdjeva = new ArrayList<>();

        // The name of the file to open.
        String fileName = "scopus-id-institucija.csv";

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
//                System.out.println(line.toString());
                listaIdjeva.add(line.toString());
            }

            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
        return listaIdjeva;
    }

    /*Prolazimo kroz dokument gde se nalaze svi ID-jevi scopus dokumenata i
    * vracamo te ID-jeve kao listu stringova*/
    public static ArrayList<String> ucitajScopusIdjeveDokumenataIzFajla() {

        ArrayList<String> listaIdjeva = new ArrayList<>();

        // The name of the file to open.
        String fileName = "scopus-id-radova.csv";

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
//                System.out.println(line.toString());
                listaIdjeva.add(line.toString());
            }

            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
        return listaIdjeva;
    }

    public static Map<String, Person> ucitajAutoreIzFajla() {

        Map<String, Person> listOfAuthors = new HashMap<>();

        // The name of the file to open.
        String fileName = "scopus-authors.csv";

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                String lastname = line.split("\\|")[0];
                String firstname = line.split("\\|")[1];
                String AffiliationCurrentId = line.split("\\|")[2];
                String scopusAuthorId  = line.split("\\|")[3];

                Person author = new Person();
                author.setFirstName(firstname);
                author.setLastName(lastname);
                author.setScopusID(scopusAuthorId);

                listOfAuthors.put(scopusAuthorId, author);
            }


            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
        return listOfAuthors;
    }

    public static ArrayList<String> ucitajIdjeveInstitucijaIzAuthorFajla() {

        ArrayList<String> listOfIds = new ArrayList<>();

        // The name of the file to open.
        String fileName = "scopus-authors.csv";

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                String affiliationCurrentId = line.split("\\|")[2];

                listOfIds.add(affiliationCurrentId);
            }


            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
        return listOfIds;
    }

    public static void ucitajDokumentaIzFajla() {

        // The name of the file to open.
        String fileName = "scopus-documents.csv";

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line.split("\\|")[11]);
            }


            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }

}
