package chapter14;

import java.util.ArrayList;

public class Sorting {

    private static void swap(ArrayList<Comparable> list, int i, int j) {
        Comparable temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    // Comparable
    // obj1.compareTo(obj2) ... returns -1 if obj1 is "less than" obj2
    // obj1.compareTo(obj2) ... returns 0 if obj1 is "equal to" obj2
    // obj1.compareTo(obj2) ... returns 1 if obj1 is "greater than" obj2
    // this is a destructive method, i.e. it modifies the original list
    public static void selectionSort(ArrayList<Comparable> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            Comparable smallest = list.get(i + 1);
            int smallesti = i;
            for (int j = i + 1; j < list.size(); j++) {
                Comparable c = list.get(j);
                if (c.compareTo(smallest) < 0){
                    smallest = c;
                    smallesti = j;
                }
            }
            swap(list, i, smallesti);
        }

        
    }
    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<>();
        test.add(null);
    }
    
}
