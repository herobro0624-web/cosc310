package chapter6;

import java.util.ArrayList;

public class ListAppend extends Target {

    public ListAppend(int arr[], ArrayList<Integer> list, String name) {
        super(arr, list, name);
    }    

    @Override
    public int method(int[] indicesOrnums) {
        int result = 0;
        // append all items to the list
        for (int i = 0; i < indicesOrnums.length; i++) {
            list.add(indicesOrnums[i]);
            result++;
        }
        return result;
    }


    
}
