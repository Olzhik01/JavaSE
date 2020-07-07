import java.util.*;

public class CTask5 {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Toyota");
        list.add("BMW");
        list.add("Mers");
        list.add("Nissan");
        list.add("Ford");

        Collections.sort(list,Collections.reverseOrder());
        System.out.println(list);

        /** task 6,7 */
        list.add(0,"Lada");
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
        /** task 8 */
        LinkedList<String> linkedList = new LinkedList<>(list);
        ArrayList<String> arrayList = new ArrayList<>(linkedList);
        System.out.println(arrayList);

        /** task 9 */
        HashSet<String> hashSet = new HashSet<>(linkedList);
        System.out.println(hashSet);
        Object[] arr = hashSet.toArray();


        /** task 10 */
        Collections.reverse(arrayList);
        System.out.println(arrayList);


        /** task 11 */
        TreeMap<String,Integer> treeMap = new TreeMap<>();
        treeMap.put("Toyota",5000000);
        treeMap.put("BMW",6000000);
        treeMap.put("Mers",5500000);
        treeMap.put("Nissan",2000000);
        treeMap.put("Ford",1500000);
        for(Map.Entry<String,Integer> m:treeMap.entrySet()){
            System.out.println(m.getKey() + " " + m.getValue());
        }



    }
}
