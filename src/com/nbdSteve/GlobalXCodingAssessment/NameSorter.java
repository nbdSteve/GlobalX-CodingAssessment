package com.nbdSteve.GlobalXCodingAssessment;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.logging.Logger;

public class NameSorter {

    //Used to log information
    private Logger log = Logger.getLogger(NameSorter.class.getName());

    //Variables for reading from the unsorted names file
    private ArrayList<String> nameList = new ArrayList<>();
    private String fileName = "unsorted-names-list.txt";
    private String line = null;

    //Variables for writing to the sorted names file
    private String newFileName = "sorted-names-list.txt";
    private File file = new File(newFileName);

    public static void main(String[] args) {
        new NameSorter();
    }

    NameSorter() {
        //Get the names from the file
        readUnsortedNamesFile();
        //Sorting the names alphabetically
        sortNames();
        //Overwriting the existing file with the sorted list
        writeSortedNamesFile();
    }

    /**
     * Reading the names from the unsorted file, and then adding
     * them to the array list of names to be sorted.
     */
    public void readUnsortedNamesFile() {
        try {
            //Creating a new reader to read the file
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            //Iterate through the file and add the lines
            while ((line = bufferedReader.readLine()) != null) {
                //Checking that the name is valid
                if (line.contains(" ")) {
                    nameList.add(line + "\n");
                } else {
                    throw new InvalidFileInputException();
                }
            }
            log.info("All names have been successfully read from the file: " + fileName);
        } catch (InvalidFileInputException e) {
            log.severe("The line '" + line + "' is not a valid " +
                    "name entry.");
        } catch (FileNotFoundException e) {
            log.severe("The file " + fileName + " was not found.");
        } catch (IOException e) {
            log.severe("Error reading the file: " + fileName);
        }
    }

    public void sortNames(){
        //Creating a new comparator that compares the last name
        Collections.sort(nameList, new Comparator<String>() {
            @Override
            public int compare(String name1, String name2) {
                String[] parts1 = name1.split(" ");
                String[] parts2 = name2.split(" ");
                return parts1[parts1.length - 1].compareToIgnoreCase(parts2[parts2.length - 1]);
            }
        });
        log.info("All names have been successfully sorted alphabetically by last name.");
    }

    public void writeSortedNamesFile() {
        try {
            //If the file exists, wipe it so it can take new input
            if (file.exists()) {
                new PrintWriter(newFileName).close();
            }
            FileWriter fileWriter = new FileWriter(file, false);
            //Added each name to the file in order
            for (int i = 0; i < nameList.size(); i++) {
                fileWriter.write(nameList.get(i));
            }
            fileWriter.close();
            log.info("The sorted names have been successfully written to the file: " + newFileName);
        } catch (IOException e) {
            log.severe("Error writing to the file: " + newFileName);
        }
    }
}