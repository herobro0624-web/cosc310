package chapter14;

import java.util.ArrayList;
import java.util.List;
import json.*;

public class Lab3_Actual {

    public static long firstTime(List<BikeDataRecord> records) {
        ArrayList<BikeDataRecord> copy = new ArrayList<>(records);
        copy.sort((r1, r2) -> Long.compare(r1.getTimestamp(), r2.getTimestamp()));
        return copy.get(0).getTimestamp() + 631065600;
    }

    public static long lastTime(List<BikeDataRecord> records) {
        ArrayList<BikeDataRecord> copy = new ArrayList<>(records);
        copy.sort((r1, r2) -> Long.compare(r2.getTimestamp(), r1.getTimestamp()));
        return copy.get(0).getTimestamp() + 631065600;
    }

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

        //////////////// CADENCE AND HEARTRATE WORK ////////////////
        
        
        // 0-timestamp, 1-distance, 2-heartrate, 3-speed, 4-alt, 5-lat, 6-lng, 7-pow, 8-cad, 9-degC, 10-radarArray
        BikeDataRecord.sortCriteria = 8;
        List<BikeDataRecord> sortedRecords = Sorting.mergeSort(records);

        int count = 0;
        for (BikeDataRecord bikeDataRecord : records) {
            if (bikeDataRecord.getHeartrate()>0) {
                System.out.println("Cadence: " + bikeDataRecord.getCad() + " | Heartrate: " + bikeDataRecord.getHeartrate());
                count++;
            }
            if (count>10)
                break;
        }

        // Sort descending by cadence
        records.sort((r1, r2) -> Float.compare(r2.getCad(), r1.getCad()));

        int count1 = 0;
        for (BikeDataRecord bikeDataRecord : records) {
            if (bikeDataRecord.getHeartrate()>0) {
                System.out.println("Cadence: " + bikeDataRecord.getCad() + " | Heartrate: " + bikeDataRecord.getHeartrate());
                count1++;
            }
            if (count1>10)
                break;
        }
        
        //////////////// ALTITUDE AND TIME SPENT ABOVE WORK ////////////////

        // Compute average altitude 
        float altTotal = records.stream().map(r -> r.getAlt()).reduce(0.0f, Float::sum);
        float avgAlt = altTotal / records.size();

        System.out.println("Average altitude: " + avgAlt);

        // Sort ascending by time
        records.sort((r1, r2) -> Long.compare(r1.getTimestamp(), r2.getTimestamp()));

        // Compute time spent above average altitude 
        long timeAbove = 0;

        for (int i = 0; i < records.size() - 1; i++) {
            BikeDataRecord current = records.get(i);
            BikeDataRecord next = records.get(i + 1);

            if (current.getAlt() > avgAlt) {
                timeAbove += (next.getTimestamp() - current.getTimestamp());
            }
        }

        System.out.println("Time spent above average altitude (seconds): " + timeAbove);

    }
}