package chapter6;

import java.util.ArrayList;

public class ListAppend extends Target {

    public ListAppend(int[] arr, ArrayList<Integer> list, String name) {
        super(arr, list, name);
    }

    @Override
    public int method(int indices[]) {
        // perform one trial's work (Target.runTests will time repeated trials)
        int result = 0;
        ArrayList<Integer> copy = new ArrayList<>(list);
        for (int i = 0; i < indices.length; i++) {
            int val = arr[indices[i]];
            copy.add(val);
            result += val; // return a value to avoid dead-code elimination
        }
        return result;
    }
}
