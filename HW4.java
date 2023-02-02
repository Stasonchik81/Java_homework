import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;


public class HW4 {
    public static void sortAgeToMax(LinkedList<Integer> idx, ArrayList <Integer> age) {
        for (int i = 0; i < idx.size(); i++) {
            int max = 0;
            int idxMax = 0;
            for (int j = 0; j < idx.size()-i; j++) {
                int tempIdx = idx.get(j);
                if(age.get(tempIdx)>max){
                    max = age.get(tempIdx);
                    idxMax = tempIdx;
                }
            }
            int temp = idx.remove(idxMax);
            idx.add(temp);
        }
    }
    public static void sortAgeFromMax(LinkedList<Integer> idx, ArrayList <Integer> age) {
        for (int i = 0; i < idx.size(); i++) {
            int max = age.get(i);
            int idxMax = i;
            for (int j = i; j < idx.size(); j++) {
                int tempIdx = idx.get(j);
                if(age.get(tempIdx)<max){
                    max = age.get(tempIdx);
                    idxMax = tempIdx;
                }
            }
            int temp = idx.remove(idxMax);
            idx.addFirst(temp);
        }
    }
    public static void main(String[] args) {
        // try {
        //     FileWriter fileWr = new FileWriter("db.csv");
        //     fileWr.append("Иванов Иван Иванович\t35\tмуж\n");
        //     fileWr.append("Петров Сергей Петрович\t41\tмуж\n");
        //     fileWr.append("Сидорова Анжела Степановна\t27\tжен\n");
        //     fileWr.append("Владимирова Светлана Анатольевна\t29\tжен\n");
        //     fileWr.append("Корнев Андрей Викторович\t51\tмуж\n");
        //     fileWr.flush();
        // } catch (IOException e) {
        //     System.out.println(e.getMessage());
        //     e.printStackTrace();
        // }
        FileReader fr;
        String text = "";
        try {
            fr = new FileReader("db.csv");
            while (fr.ready()){
                text +=(char)fr.read(); 
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        // Массив строк с данными человека
        var x = text.split("\n", 0);
        // Создаём списки по элементам данных и ссылочный список для хранения индексов
        ArrayList <String>firstN = new ArrayList<>();
        ArrayList <String>lastN = new ArrayList<>();
        ArrayList <String>secondN = new ArrayList<>();
        ArrayList <Integer>age = new ArrayList<>();
        ArrayList <Boolean>male = new ArrayList<>();
        LinkedList <Integer> idx = new LinkedList<>();
        // Наполняем наши списки данными из массива строк
        for (int i = 0; i < x.length; i++) {
            idx.add(i);
            var person = x[i].split("\t");
            var FIO = person[0].split(" ");
            firstN.add(i, FIO[0]);
            lastN.add(i, FIO[1]);
            secondN.add(i, FIO[2]);
            age.add(i, Integer.parseInt(person[1]));
            male.add(i, person[2].equals("муж")?true:false);
        }
        // Вывод в консоль в формате
        int size = firstN.size();
        for (int index = 0; index < size; index++) {
            System.out.printf("%s %s.%s. %d лет %s\n", firstN.get(index), 
                                    lastN.get(index).split("")[0],
                                    secondN.get(index).charAt(0),
                                    age.get(index),
                                    male.get(index)?"мужчина":"женщина");
        }
        // Сортировка по возрасту и вывод в консоль в формате
        // sortAgeFromMax(idx, age);
        sortAgeToMax(idx, age);
        System.out.println("sorted for min age: ");
        for (int index = 0; index < idx.size(); index++) {
            int tempIdx = idx.get(index);
            System.out.printf("%s %s.%s. %d лет %s\n", firstN.get(tempIdx), 
                                    lastN.get(tempIdx).split("")[0],
                                    secondN.get(tempIdx).charAt(0),
                                    age.get(tempIdx),
                                    male.get(tempIdx)?"мужчина":"женщина");
        }
        
        
        
    }
}
