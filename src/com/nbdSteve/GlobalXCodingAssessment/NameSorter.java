package com.nbdSteve.GlobalXCodingAssessment;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Logger;

public class NameSorter {

    //Used to log information
    private Logger log = Logger.getLogger(NameSorter.class.getName());

    //Variables for reading from the unsorted names file
    private ArrayList<String> unsortedNames = new ArrayList<>();
    private String fileName = "unsorted-names-list.txt";
    private String line = null;

    //Variables for writing to the sorted names file
    private String newFileName = "sorted-names-list.txt";
    private File file = new File(newFileName);

    //Variables for sorting the names alphabetically
    private ArrayList<String> sortedNames = new ArrayList<>();

    public static void main(String[] args) {
        new NameSorter();
    }

    NameSorter() {
        //Get the names from the file
        readUnsortedNamesFile();
        //Sorting the names alphabetically
        Collections.sort(unsortedNames);
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
                    unsortedNames.add(line);
                    log.info("added line " + line);
                } else {
                    throw new InvalidFileInputException();
                }
            }
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
        for (int i = 0; i < unsortedNames.size(); i++){
            String name = unsortedNames.get(i);
            String[] parts = name.split(" ");
            String lastName = parts[parts.length];
        }
    }

    public void writeSortedNamesFile() {
        try {
            if (file.exists()) {
                new PrintWriter(newFileName).close();
            }
            FileWriter fileWriter = new FileWriter(file, false);

            for (int i = 0; i < sortedNames.size(); i++){
                fileWriter.write(sortedNames.get(i));
            }

            fileWriter.close();
        } catch (IOException e) {
            log.severe("Error writing to the file: " + newFileName);
        }
    }
}