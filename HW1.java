import java.util.Random;

/**
 * HW1
 */
public class HW1 {
    public static void main(String[] args) {
        Random rnd = new Random();
        int i = rnd.nextInt(2000);
        String str = Integer.toBinaryString(i);
        String[] bits = str.split("");
        int n = bits.length;
        System.out.println("Random number (i) = " + i + "\nRandom number (in bits) = " + str 
                            + "\nMain range (n) = " + n + "\nMax = " + Short.MAX_VALUE + 
                            "\nMin = " + Short.MIN_VALUE);
        
    // вычисляем размер массива кратных n от i до Short.MAX_VALUE
        int multi_count = 0; 
        for (int idx = i; idx < Short.MAX_VALUE; idx++) {
            if (idx % n == 0) {
                multi_count++;
            }
        }
    // Создаём массив кратных n от i до Short.MAX_VALUE
        int[] m1 = new int[multi_count];
        int first_multi = i;
        while(first_multi % n != 0){
            first_multi++;
        }
        m1[0] = first_multi;
        for (int j = 1; j < multi_count; j++) {
            m1[j] = m1[j-1] + n;
        }
        System.out.println("first_multi = " + first_multi);
        System.out.println("last_multi = " + m1[multi_count-1]);
        System.out.println("Length of m1 = " + m1.length);

    // создаём массив некратных n от Short.MIN_VALUE до i
        
        int[] m2 = new int [1];
        int first_non_multi = Short.MIN_VALUE;
        while(first_non_multi % n == 0){
            first_non_multi++;
        }
        m2[0] = first_non_multi;
        for (int idx = first_non_multi+1; idx < i; idx++) {
            if (idx % n != 0) {
                int[]temp = new int[m2.length + 1];
                temp[temp.length-1] = idx;
                for (int j = 0; j < temp.length-1; j++) {
                    temp[j] = m2[j];
                }
                m2 = temp;
            }
        }
        System.out.println("first_non_multi = " + m2[0]);
        System.out.println("last_non_multi = " + m2[m2.length-1]);
        System.out.println("Length of m2 = " + m2.length);
    }
    
}
