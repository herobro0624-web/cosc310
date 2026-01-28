package chapter6;

import java.util.ArrayList;

public class ListInsert extends Target {

    public ListInsert(int arr[], ArrayList<Integer> list, String name) {
        super(arr, list, name);
    }

    // insert new items at beginning of arr
    @Override
    public int method(int[] indicesOrnums) {
        int sum = 0;
        for (int i = 0; i < indicesOrnums.length; i++) {
            list.add(0, indicesOrnums[i]);
            sum += indicesOrnums[i];
        }
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

}
