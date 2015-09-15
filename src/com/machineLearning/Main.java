package com.machineLearning;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("ID3 algo starts");
        List<List<String>> testSet = new Main().readInput("test_set");
        System.out.println(testSet.toString());
        List<List<String>> trainingSet = new Main().readInput("training_set");
        System.out.println(trainingSet.toString());
        List<List<String>> validationSet = new Main().readInput("validation_set");
        System.out.println(validationSet.toString());
    }

    private List<List<String>> readInput(String fileName) {
        String csvFile = "resources/data_sets1/" + fileName + ".csv";
        List<List<String>> dataSet = new ArrayList<List<String>>();
        List<String> records = new ArrayList<String>();

        try {
            records = Files.readAllLines(Paths.get(csvFile), StandardCharsets.UTF_8);
            for (String record : records) {
                String[] splitData = record.split(",");
                List<String> singleRecord = Arrays.asList(splitData);
                dataSet.add(singleRecord);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(dataSet.size());
        return dataSet;
    }
}
