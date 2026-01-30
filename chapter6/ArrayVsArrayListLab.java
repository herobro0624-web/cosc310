package chapter6;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class ArrayVsArrayListLab {

    

    protected static int listRandomAccess(int indices[], ArrayList<Integer> list) {
        int result = 0;
        for (int i = 0; i < indices.length; i++) {
            result += list.get(indices[i]);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
       /* long start = System.nanoTime();
        System.out.println("hello, world");
        long finish = System.nanoTime();
        long elapsed = finish - start;
        System.out.println("println: " + elapsed + "ns");
        start = System.nanoTime();
        arrayTest(30_000);
        finish = System.nanoTime();
        elapsed = finish - start;
        System.out.println("arrayTest: " + elapsed + "ns"); */
        int arr[] = DataLoader.loadArray("numbers.txt");
        ArrayList<Integer> list = DataLoader.loadArrayList("numbers.txt");
        Random r = new Random();
        int indices[] = new int[100_000];
        for (int i = 0; i < indices.length; i++) {
            indices[i] = r.nextInt(arr.length);
        }

        PrintWriter fileOut = new PrintWriter(new File("results.csv"));
        Target tests[] = new Target[8];

        double testAvg[] = new double[8];

        // need to compare results of array and arraylist versions of each test 
        tests[0] = new ArrayRandom(arr, new ArrayList<>(list), "array,random_access");
        tests[1] = new ListRandom(arr, new ArrayList<>(list), "arraylist, random_access");
        tests[2] = new ArrayAppend(arr, new ArrayList<>(list), "array,append");
        tests[3] = new ListAppend(arr, new ArrayList<>(list), "arraylist,append");
        tests[4] = new ArrayInsert(arr, new ArrayList<>(list), "array,insert");
        tests[5] = new ListInsert(arr, new ArrayList<>(list), "arraylist,insert");
        tests[6] = new ArrayRemove(arr, new ArrayList<>(list), "array,remove");
        tests[7] = new ListRemove(arr, new ArrayList<>(list), "arraylist,remove");
        

        for (int i = 0; i < tests.length; i++) {
            Target target = tests[i];
            if (target != null) {
                testAvg[i] = target.runTests(indices);
                target.writeResults(fileOut);
            }
        }
        
        // Pretty-print comparison: operation name, array avg (ns), arraylist avg (ns), winner
        String ops[] = {"random_access", "append", "insert", "remove"};
        for (int j = 0; j < ops.length; j++) {
            int base = j * 2;
            double arrayNs = testAvg[base];
            double listNs  = testAvg[base + 1];
            String winner = arrayNs < listNs ? "array" : "arraylist";
            System.out.printf("Operation: %s array avg: %.2f ns arraylist avg: %.2f ns winner: %s%n",
                              ops[j], arrayNs, listNs, winner);
        }     
        fileOut.close();
        
    }
}
