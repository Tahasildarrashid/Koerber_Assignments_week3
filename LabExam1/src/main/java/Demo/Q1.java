package Demo;

import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Map<String, Integer> map=new HashMap<String, Integer>();
        map.put("raj", 95);
        map.put("ekta", 75);
        map.put("rajiv", 85);
        map.put("sunita", 66);
        map.put("gunika", 99);

//        1
//        System.out.println("------printing map------");
//        map.forEach((k, v) -> System.out.println(k + " " + v));

//        2
//        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            if(entry.getKey().equalsIgnoreCase("raj"))
//                System.out.println(entry.getKey() + " " + entry.getValue());
//        }

//        3
//        Map<String, Integer> sortedMap=new TreeMap<>(map);
//        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }

//        4
//        List<Map.Entry<String, Integer>> mp = new ArrayList<>(map.entrySet());
//        Collections.sort(mp, (e1, e2) -> e2.getValue().compareTo(e1.getValue()));
//        for (Map.Entry<String, Integer> entry : mp) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }

//        5
        Map<String, Integer> mp = new TreeMap<>(Collections.reverseOrder());
        mp.putAll(map);
        for (Map.Entry<String, Integer> entry : mp.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }
}
