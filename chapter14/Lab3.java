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


        // sort by temp 
        records.sort((r1, r2)->Float.compare(r2.getDegC(),r1.getDegC()));
        List<BikeDataRecord> highTemp = records.stream().filter((r)->r.getDegC()>29.0f).toList();
        int bpmTotal = highTemp.stream().map((r)->r.getHeartrate()).reduce(0,Integer::sum);
        System.out.println(highTemp.size());
        System.out.println(bpmTotal/highTemp.size());

        // sort by speed ... new, easier way to sort ... but note that it is mutative (i.e., it modifies the original list)
        records.sort((r1, r2)->Float.compare(r2.getSpeed(),r1.getSpeed()));
        List<BikeDataRecord> highspeedsonly = records.stream().filter((r)->r.getSpeed()>16.0f).toList();
        int hrtotal1 = highspeedsonly.stream().map((r)->r.getHeartrate()).reduce(0,Integer::sum);
        System.out.println(highspeedsonly.size());
        System.out.println(hrtotal1/highspeedsonly.size());

        // filter by range (look at the filter function that uses a min timestamp and a max timestamp) 
        List<BikeDataRecord> susphrdata = records.stream().filter((r)->r.getTimestamp()>=1142088651&&r.getTimestamp()<=1142088671).toList();
        ArrayList<BikeDataRecord> newlist = new ArrayList<>(susphrdata);
        // now that we have only the matching records, we can sort them by timestamp using the new, easier way to sort
        newlist.sort((r1,r2)->Long.compare(r1.getTimestamp(),r2.getTimestamp()));
        for (BikeDataRecord bikeDataRecord : newlist) {
            System.out.println(bikeDataRecord);
        }
        
        // old way of sorting using our own merge sort implementation and the sortCriteria static variable
        // 0-timestamp, 1-distance, 2-heartrate, 3-speed, 4-alt, 5-lat, 6-lng, 7-pow, 8-cad, 9-degC, 10-radarArray
        BikeDataRecord.sortCriteria = 9;
        List<BikeDataRecord> sortedRecords = Sorting.mergeSort(records);
        int count = 0;
        for (BikeDataRecord bikeDataRecord : sortedRecords) {
            if (bikeDataRecord.getHeartrate()>0) {
                System.out.println(bikeDataRecord);
                count++;
            }
            if (count>10)
                break;
        }

        // using map to extract single piece of data from each record and then reduce to combine it into a single value (i.e., the total)
        ArrayList<BikeDataRecord> lunchday1  = Searching.binarySearch((ArrayList<BikeDataRecord>)sortedRecords, 1141920754L, 1141923454L);
        System.out.println(lunchday1.size());
        int hrtotal = lunchday1.stream().map(BikeDataRecord::getHeartrate).reduce(0, Integer::sum);
        int hravg = hrtotal/lunchday1.size();
        System.out.println(hravg);

        // using map to extract single piece of data from each record and then reduce to combine it into a single value (i.e., the total)
        ArrayList<BikeDataRecord> lunchday3  = Searching.binarySearch((ArrayList<BikeDataRecord>)sortedRecords, 1141920754L+72800, 1141923454L+72800);
        System.out.println(lunchday3.size());
        int hrtotal3 = lunchday3.stream().map(r -> r.getHeartrate()).reduce(0, Integer::sum);
        int hravg3 = hrtotal3/lunchday3.size();
        System.out.println(hravg3);
        int[][] radarArrayTest = new int[][] { new int[] {10, 3}, new int[] {20, 6, 7, 8, 9}, new int[] { 50, 10} };
        System.out.println(radarArrayTest[1].length);

    }
}