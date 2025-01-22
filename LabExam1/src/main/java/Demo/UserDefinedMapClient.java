package Demo;

import java.util.*;

public class UserDefinedMapClient {
    public static void main(String[] args) {
        Map<UserDefinedMap, Integer> map=new HashMap<>();
        map.put(new UserDefinedMap(109, "raj", 95), 95);
        map.put(new UserDefinedMap(61, "keta", 78), 78);
        map.put(new UserDefinedMap(11, "gunika", 98), 98);
        map.put(new UserDefinedMap(19, "keshav", 97), 97);

        System.out.println(" Printing all records as per name of the student");
        Map<UserDefinedMap, Integer> sortedByName = new TreeMap<>(( s1, s2) -> s1.getName().compareTo(s2.getName()));
        sortedByName.putAll(map);
        for (Map.Entry<UserDefinedMap, Integer> entry : sortedByName.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println();
        System.out.println(" Printing all records as per id of the student");
        Map<UserDefinedMap, Integer> sortedById = new TreeMap<>((s1, s2) -> Integer.compare(s1.getId(), s2.getId()));
        sortedById.putAll(map);
        for (Map.Entry<UserDefinedMap, Integer> entry : sortedById.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }
}
