import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;



public class HW5 {
    public static void main(String[] args) {
         // Задание_1
         HashMap <Integer, String> map = new HashMap<>();
         // Задание_2
         map.put(1, "Yellow");
         map.put(2, "Green");
         map.put(3, "Pink");
         map.put(4, "Orange");
                  
         System.out.println(map.putIfAbsent(5, "Red"));
         System.out.println(map);

         // Задание_3
         Set<Integer> keySet = map.keySet();
         Iterator <Integer> it = keySet.iterator();
            while (it.hasNext()){
               int i = it.next();
               map.replace(i, map.get(i)+"!");
            }
         for (Integer el : keySet) {
               System.out.println(map.get(el));
         }
         // Задание_5
         Random rnd = new Random();
         String color = "Black";
         for (int index = 6; index < 10001; index++) {
            int k = rnd.nextInt(100000);
            while(map.containsKey(k)){
               k = rnd.nextInt(10000);
            }
            map.put(k, color);
         }
         System.out.println(map.size());
         // Получаем последний элемент
         System.out.println(map.get(keySet.toArray()[keySet.size()-1]));

         // Задание_4
         System.out.println("TreeMap");
         TreeMap <Integer, String> tmap = new TreeMap<>(map);
         // Получаем часть TreeMapа (от начала до 100го элемента):
         // Map <Integer, String> sliceMap = tmap.headMap(100);
         // sliceMap.forEach((k, v) -> System.out.printf("%d = %s, ", k, v));
        
         // Задание_6
         int counter = 0;
         var start1 = System.currentTimeMillis();
         for (Map.Entry <Integer, String> x : map.entrySet()) {
            counter++;
         }
         var end1 = System.currentTimeMillis();
         System.out.printf("time map = %d \n", end1-start1);
   

         counter = 0;
         var start2 = System.currentTimeMillis();
         for (Map.Entry <Integer, String> x : tmap.entrySet()) {
            counter++;
         }
         var end2 = System.currentTimeMillis();
         System.out.printf("time tmap = %d \n", end2-start2);
         
    }
    
}
