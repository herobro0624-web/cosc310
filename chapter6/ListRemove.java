package chapter6;

import java.util.ArrayList;

public class ListRemove extends Target {

    public ListRemove(int arr[], ArrayList<Integer> list, String name) {
        super(arr, list, name);
    }    

    @Override
    public int method(int[] indicesOrnums) {
        int result = 0;
        
        // remove first 20,000 items from the list
        for (int i = 0; i < 20_000; i++) {
            list.remove(0);
            result++;
        }

        return result;
    }


    
}
