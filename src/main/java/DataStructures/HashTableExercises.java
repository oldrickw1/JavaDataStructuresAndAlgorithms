package DataStructures;

import java.util.HashMap;

public class HashTableExercises {

    public static int mostFrequent(int[] arr) {
        var map = new HashMap<Integer, Integer>();
        for (int item : arr) {
            var count = map.getOrDefault(item, 0);
            map.put(item, count + 1);
        }

        int max = -1;
        int result = arr[0];
        for (var item: map.entrySet()) {
            if (item.getValue() > max) {
                max = item.getValue();
                result = item.getKey();
            }
        }
        return result;
    }
}
