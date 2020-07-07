import java.util.*;

public class CTask1 {
    public static void main(String[] args) {
        HashMap<String,Integer> hashMap = new HashMap<>();

        hashMap.put("Toyota",5000000);
        hashMap.put("BMW",6000000);
        hashMap.put("Mers",5500000);
        hashMap.put("Nissan",2000000);
        hashMap.put("Ford",1500000);

        System.out.println("Sorted By Values:");
        Map<String, Integer> hashMapSorted = sortByHMByValue(hashMap);
        for (Map.Entry<String, Integer> hm : hashMapSorted.entrySet()) {
            System.out.println(hm.getKey() +" "+hm.getValue());
        }


        System.out.println("Sorted By Keys:");
        Map<String,Integer> mapSortedByKeys = sortByHMByKeys(hashMap);
        for (Map.Entry<String, Integer> hm : mapSortedByKeys.entrySet()) {
            System.out.println(hm.getKey() +" "+hm.getValue());
        }


    }

    public static HashMap<String,Integer> sortByHMByValue(HashMap<String,Integer> hashMap){
        List<Map.Entry<String,Integer>> list = new ArrayList<>(hashMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });


        HashMap<String,Integer> tempHM = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> l : list) {
            tempHM.put(l.getKey(), l.getValue());
        }

        return tempHM;
    }

    public static Map<String,Integer> sortByHMByKeys(HashMap<String,Integer> hashMap){
        TreeMap<String,Integer> treeMap = new TreeMap<>(hashMap);

        return treeMap;

    }
}
