package com.nbdSteve.GlobalXCodingAssessment;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.logging.Logger;

public class NameSorter {

    //Used to log information
    private Logger log = Logger.getLogger(NameSorter.class.getName());

    //Variables for getting unsorted names
    private ArrayList<String> unsortedNames = new ArrayList<>();
    private String fileName = "unsorted-names-list.txt";
    private String line = null;

    //Variables for overwriting the file
    private String newFileName = "sorted-names-list.txt";
    private File file = new File(newFileName);

//    private String[] parts = "";

    //Variables for sorting the names alphabetically
    private HashMap<String, Integer> tempSorter = new HashMap<>();
    private ArrayList<String> sortedNames = new ArrayList<>();

    public static void main(String[] args) throws InvalidFileInputException {
        new NameSorter();
    }

    NameSorter() throws InvalidFileInputException {
        //Get the names from the file
        readingNamesFromFile();
        //Sorting the names alphabetically
        Collections.sort(unsortedNames);
        //Overwriting the existing file with the sorted list
        writeNamesFile();
    }

    /**
     * Reading the names from the unsorted file, and then adding
     * them to the array list of names to be sorted.
     */
    public void readingNamesFromFile() throws InvalidFileInputException {
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null){
                //Checking that the name is valid
                if (line.contains(" ")){
                    unsortedNames.add(line);
                    log.info("added line " + line);
                } else {
                    log.severe("The line '" + line + "' is not a valid " +
                            "name entry.");
                    throw new InvalidFileInputException();
                }
            }

//            Collections.sort(unsortedNames);

            log.info("Added names to the array list");
        } catch (FileNotFoundException e) {
            log.severe("The file " + fileName + " was not found.");
        } catch (IOException e) {
            log.severe("Error reading the file: " + fileName);
        }
    }

    public String getLastName(int i, ArrayList names){
        String name = unsortedNames.get(i);
        String[] parts = name.split(" ");
        return parts[parts.length];
    }

    public void sortNames(){
//        Collections.sort(unsortedNames,
    }

    public void writeNamesFile() {
        try {
            FileWriter fileWriter = new FileWriter(file, false);

            for (int i = 0; i < unsortedNames.size(); i++){
                fileWriter.write(unsortedNames.get(i));
            }

            fileWriter.close();
        } catch (FileNotFoundException e) {
            log.severe("The file " + newFileName + " was not found.");
        } catch (IOException e) {
            log.severe("Error overwriting the file: " + newFileName);
        }
//        File deleteFile = new File (fileName);
//        deleteFile.delete();
//        deleteFile.
//        File overwriteFile = new File (fileName);
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
//            log.info(String.valueOf(nameValue));
        }
    }

    public void sortingNames () {
        String[] keys = new String[tempSorter.size()];

        for(int i = 0; i < 5000; i++){

        }
    }
}