
public class HW2 {
    // функция проверки и подсчёта количества вхождений подстроки в строку
    public static int getRepeatCount(String text, String myStr) {
        int n = 0; // количество вхождений
        int idx = 0; // индекс первого вхождения
        while (true) {
            idx = text.indexOf(myStr, idx);
            int x = myStr.length();
            if(idx !=-1){
                n++;
                idx += x;
            }
            else{
                break;
            }
        }
        return n;
    }

    // функция проверки строк на зеркальность
    public static boolean isSwing(String first, String second) {
        int len1 = first.length();
        int len2 = second.length();
        if (len1 == len2){
            for (int i = 0; i < len1; i++) {
                if(first.charAt(i) != second.charAt(len1-1-i)){
                    return false;
                }
            }
            return true;
        }
        else return false;

    }
    // функция переворота строки
    public static String reverseStr(String myStr) {
        StringBuilder sb = new StringBuilder();
        // реверс через цикл
        /* for (int i = 1; i <= myStr.length(); i++) {
        //     sb.append(myStr.charAt(myStr.length() - i));
         }
         */
        // реверс через рекурсию
        sb = func(sb, myStr);
        String revStr = sb.toString();
        return revStr;
    }
    // рекурсивная функция для переворота строки
    public static StringBuilder func(StringBuilder sb, String str) {
        if (sb.length()==str.length()){
            return sb;
        }
        return func(sb.append(str.charAt(str.length()-sb.length()-1)), str);
    }
    // функция замены подстроки в строке средствами StringBuilder
    public static void replaceInText(StringBuilder sb, String find, String replace) {
        int index = sb.indexOf(find);
        while (index != -1) {
            sb.replace(index, index + find.length(), replace);
            index += replace.length(); // Move to the end of the replacement
            index = sb.indexOf(find, index);
        }
    }
    
    public static void main(String[] args) {
        
        // задание_1
        String a = "Привет супер, супер мир";
        String b = "супер";
        String c = "репус";
        int d = getRepeatCount(a, b);
        System.out.println(d);
        
        // задание_2
        if (isSwing(c, c)){
            System.out.println("Yes!");
        }
        else{
            System.out.println("No!");
        }
        
        // задание_3
        String revString = reverseStr(b);
        System.out.println(revString);

        int num1 = 3;
        int num2 = 56;

        // задание_4 (создание строк с помощью StringBuilder)
        StringBuilder sb1 = new StringBuilder().append(num1)
                                                .append(" + ")
                                                .append(num2)
                                                .append(" = ")
                                                .append(num1 + num2);
        StringBuilder sb2 = new StringBuilder().append(num1)
                                                .append(" - ")
                                                .append(num2)
                                                .append(" = ")
                                                .append(num1 - num2);
        StringBuilder sb3 = new StringBuilder().append(num1)
                                                .append(" * ")
                                                .append(num2)
                                                .append(" = ")
                                                .append(num1 * num2);
        // задание_5 (замена “=” на слово “равно” с помощью StringBuilder.insert(),StringBuilder.deleteCharAt()).
        System.out.println(sb1);
        int indx = sb1.indexOf("=");
        sb1.deleteCharAt(indx)
            .insert(indx, "равно");
        System.out.println(sb1);
        System.out.println(sb2);
        indx = sb2.indexOf("=");
        sb2.deleteCharAt(indx)
            .insert(indx, "равно");
        System.out.println(sb2);
        System.out.println(sb3);
        indx = sb3.indexOf("=");
        sb3.deleteCharAt(indx)
            .insert(indx, "равно");
        System.out.println(sb3);

        // задание_6 (обратная замена с помощью StringBuilder.replace()).
        String findStr = "равно";
        String replaceStr = "=";
        int index1 = sb3.indexOf(findStr);
        int index2 = index1 + findStr.length();
        sb3.replace(index1, index2, replaceStr);
        System.out.println(sb3);

        // задание_7
        StringBuilder sb = new StringBuilder();
        for (int index = 0; index < 10000; index++) {
            sb.append("=");
        }
        String text = sb.toString();

        var start1 = System.currentTimeMillis();
        text.replaceAll("=", "равно");
        System.out.println("Время выполнения string = " + (System.currentTimeMillis() - start1));
        
        var start2 = System.currentTimeMillis();
        replaceInText(sb, "=", "равно");
        System.out.println("Время выполнения stringBuilder = " + (System.currentTimeMillis() - start2));

        
      
        
    }
    
}
