import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;



public class HW6 {
    
    public static void main(String[] args) {
        ArrayList <Integer> myList = new ArrayList<>();
        Random rnd = new Random();
         for (int index = 1; index < 100; index++) {
            int k = rnd.nextInt(1000);
            myList.add(k);
         }
         System.out.println(myList.size());

         MySet set = new MySet();
         for (Integer iterable_element : myList) {
            set.add(iterable_element);
         }
         System.out.println(set.toString());
         for (int i = 0; i < set.size(); i=i+2) {
            System.out.println(set.getEl(i)); 
         }


    }
    
}
/**
 * InnerHW6
 */
class MySet {
    public HashMap <Integer, Object> sMap = new HashMap<>();
    private final Object OBJ = new Object();
    
    public boolean add(Integer a) {
        sMap.put(a, OBJ);
        return true;
     }
     @Override
     public String toString(){
        return sMap.keySet().toString();
    }
    public Integer size(){
        return sMap.size();
    }
    public Integer getEl(Integer idx){
        return (Integer)sMap.keySet().toArray()[idx];
    }
    
}
