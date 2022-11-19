package DataStructures;

import java.util.*;

public class HashTableExercises {

//    public static int mostFrequent(int[] arr) {
//        var map = new HashMap<Integer, Integer>();
//        for (int item : arr) {
//            var count = map.getOrDefault(item, 0);
//            map.put(item, count + 1);
//        }
//
//        int max = -1;
//        int result = arr[0];
//        for (var item: map.entrySet()) {
//            if (item.getValue() > max) {
//                max = item.getValue();
//                result = item.getKey();
//            }
//        }
//        return result;
//    }

    public static int countPairsWithDiff(Integer[] numbers, int difference) {
        Set<Integer> uniqueNumbers = new HashSet<>(Arrays.asList(numbers));
        var count = 0;

        for (int number : numbers) {
            if (uniqueNumbers.contains(number + difference))
                count++;
            if (uniqueNumbers.contains(number - difference))
                count++;
            uniqueNumbers.remove(number);
        }

        return count;
    }


}
