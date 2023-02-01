import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.Iterator;


public class HW3 {
    public static String findEl(List<String> my_List, String element) {
        if (my_List.contains(element)){
            int  idx = my_List.indexOf(element);
            return my_List.get(idx);
        }
        else{
            return "not in list";
        }
    }
    public static String findElforStr(List<String> my_List, String find) {
        for (String iter : my_List) {
            if(iter.indexOf(find)!=-1){
                return my_List.get(my_List.indexOf(iter));
            }
        }
        return "not find";
    }
    public static void addSome(List<String> my_List, List <String> listEl, int start, int end ) {
        for (int i = start; i < end; i++) {
            my_List.add(listEl.get(i));
        }
    }
    public static void main(String[] args) {
        // задание_1
        ArrayList <String> people = new ArrayList<>(10);
        people.add("Vasy");
        people.add("Nick");
        people.add("Serg");
        people.add("Leo");
        System.out.println(people);
        // задание_2
        ArrayList <String> colors = new ArrayList<>(10);
        String [] col = new String[] {"yellow", "red", "blue", "violet", "braun", "gray"};
        Collections.addAll(colors, col);
        for (String str_ : colors) {
            System.out.printf("%s!\n", str_);
        }
        // задание_3
        people.add(0, "Lex");
        System.out.println(people);
        // задание_4
        String student1 = people.get(0);
        System.out.println(student1);
        // задание_5
        people.set(1, "Vlad");
        System.out.println(people);
        // задание_6
        people.remove(2);
        System.out.println(people);
        // задание_7
        System.out.println(findElforStr(people, "L"));
        // задание_8
        addSome(people, colors, 2, 4);
        System.out.println(people);
        ArrayList ls = new ArrayList<>(colors.subList(2, 4));
        System.out.println(ls);
        // задание_9
        people.retainAll(colors);
        System.out.println(people);
        // задание_10
        ArrayList<String> second = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < 6; i++) {
            second.add(Integer.toString(rnd.nextInt(10)));
        }
        System.out.println(second);
        Collections.sort(second);
        System.out.println(second);
        Collections.sort(people);
        System.out.println(people);


        // работа с итератором и циклом foreach
        Iterator <String> itr = people.iterator();
        while (itr.hasNext()) {
            String str_ = itr.next();
            System.out.println(str_);
        }
        ListIterator <String> listItr = people.listIterator(people.size()/2);
        while (listItr.hasPrevious()) {
            String str_ = listItr.previous();
            System.out.print(str_);
        }
        people.forEach((k) -> System.out.printf("\n %s!", k) );

        
        
        

        

        
        

        
    }
}
