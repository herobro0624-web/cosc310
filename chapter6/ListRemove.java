package chapter6;

import java.util.ArrayList;

public class ListRemove extends Target {

    public ListRemove(int arr[], ArrayList<Integer> list, String name) {
        super(arr, list, name);
    }    

    @Override
    public int method(int[] indicesOrnums) {
        int result = 0;
        for (int i = 0; i < indicesOrnums.length; i++) {
            result += list.get(indicesOrnums[i]);
        }
        return result;
    }


    
}
