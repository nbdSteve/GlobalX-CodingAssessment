package com.nbdSteve.GlobalXCodingAssessment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

public class NameSorter {

    //Used to log information
    private Logger log = Logger.getLogger(NameSorter.class.getName());

    //Variables for getting unsorted names
    private ArrayList<String> unsortedNames = new ArrayList<>();
    private String fileName = "unsorted-names-list.txt";
    private String line = null;

    //Variables for sorting the names alphabetically
    private HashMap<String, Integer> tempSorter = new HashMap<>();
    private ArrayList<String> sortedNames = new ArrayList<>();

    public static void main(String[] args) {
        new NameSorter();
    }

    NameSorter() {
        //Get the names from the file
        readingNamesFromFile();


    }

    /**
     * Reading the names from the unsorted file, and then adding
     * them to the array list of names to be sorted.
     */
    public void readingNamesFromFile(){
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null){
                unsortedNames.add(line);
                log.info("added line " + line);
            }

            log.info("Added names to the array list");
        } catch (FileNotFoundException e) {
            log.severe("The file " + fileName + " was not found.");
        } catch (IOException e) {
            log.severe("Error reading the file: " + fileName);
        }
    }

    public void tempSortingNames () {

        for (int i = 0; i < unsortedNames.size(); i++){

            String name = unsortedNames.get(i);
            int nameValue = 0;

            for (int j = 0; j < name.length(); j++){
                 int c = name.charAt(j);
                 nameValue += c;
            }

            tempSorter.put(name, nameValue);
        }
    }

    public void sortingNames () {

    }
}
