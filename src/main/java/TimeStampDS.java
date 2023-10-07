import org.antlr.v4.runtime.tree.Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class TimeStampDS {

    Map<Integer, TreeMap<Integer, Integer>> dataStore = new HashMap<>();

    public void put(int key, int value, int timestamp) {

        if (dataStore.containsKey(key)) {
            dataStore.get(key).put(timestamp, value);
        } else {
            TreeMap<Integer, Integer> incomingData = new TreeMap<>();
            incomingData.put(timestamp, value);
            dataStore.put(key, incomingData);
        }
    }

    public Integer get(int key, int timestamp) {

        if (dataStore.containsKey(key)) {
            TreeMap<Integer, Integer> data = dataStore.get(key);
            if (data.containsKey(timestamp)) {
                return data.get(timestamp);
            } else {
                Map.Entry<Integer, Integer> floorData = data.floorEntry(timestamp);
                return floorData == null ? null : floorData.getValue();
            }
        }
        return null;

    }

    /**
     * key -> value timestamp -> increasing number
     * <p>
     * put (key, value -> timestamp)
     * get (key, timestamp)
     * <p>
     * key -> val -> timestamp
     * 0 -> 20 -> 1
     * 0 -> 20 -> 2
     * 0 -> 30 -> 5
     * 0 -> 40 -> 6
     * 0 -> 50 -> 7
     * <p>
     * Map<Integer,Map<Integer, Integer></></Integer,Map>>
     */

    public static void main(String[] args) {
        TimeStampDS timeStampDS = new TimeStampDS();
        System.out.println(timeStampDS.dataStore);

//        timeStampDS.put(0, 10, 1);
//        timeStampDS.put(0, 20, 2);
        timeStampDS.put(0, 50, 5);
        timeStampDS.put(0, 60, 6);
        timeStampDS.put(0, 70, 7);

        System.out.println(timeStampDS.get(0, 4));


    }


}
