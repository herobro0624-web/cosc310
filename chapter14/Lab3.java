package chapter14;

import java.util.ArrayList;
import java.util.List;

import json.*;

public class Lab3 {
    public static void main(String[] args) throws Exception {
        // This collects all the records into variables
        ArrayList<BikeDataRecord> records = new ArrayList<>();
        ArrayList<BikeDataRecord> records1 = BikeDataReader.parse("json/day1.json");
        ArrayList<BikeDataRecord> records2 = BikeDataReader.parse("json/day2.json");
        ArrayList<BikeDataRecord> records3 = BikeDataReader.parse("json/day3.json");
        ArrayList<BikeDataRecord> records4 = BikeDataReader.parse("json/day4.json");

        // And this combines the records into a single variable "records"
        records.addAll(records1);
        records.addAll(records2);
        records.addAll(records3);
        records.addAll(records4);
        
        System.out.println(records.size());
        System.out.println(records.get(0));
        List<BikeDataRecord> sortedRecords = Sorting.mergeSort(records);
        System.out.println(records.get(0));


    }
}
