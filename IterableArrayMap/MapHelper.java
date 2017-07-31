/*
* @Author: aaronlai
* @Date:   2017-07-01 16:53:55
* @Last Modified by:   aaronlai
* @Last Modified time: 2017-07-01 17:28:12
*/

import java.util.List;

public class MapHelper {

    /* make the method Generic (<K, V>) rather than make the class Generic */
    public static <K, V> V get(ArrayMap<K, V> sim, K key){
        if (sim.containsKey(key)){
            return sim.get(key);
        }
        return null;
    }

    public static <K extends Comparable<K>, V> K maxKey(ArrayMap<K, V> sim){
        List<K> keylist = sim.keys();
        K largest = keylist.get(0);
        for (K k : keylist){
            /* However, Generic type K has no "compareTo" => should extend Comparable*/
            if (k.compareTo(largest) > 0){
                largest = k;
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        ArrayMap<String, Integer> m = new ArrayMap<String, Integer>();
        m.put("aorse", 3);
        m.put("fish", 6);
        m.put("dog", 9);

        /* expect 6 */
        Integer actual = MapHelper.get(m, "fish");
        System.out.println(actual);

        /* expect "dog" */
        String act_key = MapHelper.maxKey(m);
        System.out.println(act_key);
    }
}