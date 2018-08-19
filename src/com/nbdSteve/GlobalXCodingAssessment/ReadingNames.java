package com.nbdSteve.GlobalXCodingAssessment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

public class ReadingNames {

    public ReadingNames
            (String fileName, ArrayList<String> addNames, Logger log) {

        //Line to append to the array list
        String line = null;

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null){
                addNames.add(line);
                log.info("added line " + line);
            }

            log.info("Added names to the array list");
        } catch (FileNotFoundException e) {
            log.severe("The file " + fileName + " was not found.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
