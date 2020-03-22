import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> a1 = new ArrayList<>();
        ArrayList<Integer> a2 = new ArrayList<>();
        ArrayList<String> str1= new ArrayList<>();
        a1.add(10);
        a1.add(20);
        a1.add(30);
        a2.add(5);
        a2.add(13);
        a2.add(0);
        str1.add("aewrerere");
        str1.add("erer");
        int max = 0;
        for (Integer integer : a1) {
            if (integer > max) max = integer;
        }
        Integer max1 = a1.stream().max((a, b) -> {
            if( a > b ) return 1;
            if (a < b) return -1;
            return 0;
        }).get();
        System.out.println(max1);
        Long count = a2.stream().filter((a) -> a > max1).count();
        System.out.println(count);
        // Д.з 7.6
        String str = "aeuioy";
        Long col = str1.stream().filter((a) -> {
            int cnt = 0;
            for(int i = 0; i < a.length(); i++) {
                char ch = a.charAt(i);
                if(ch == 'e' || ch == 'u' || ch =='i' || ch == 'o'|| ch=='a' || ch =='y') {
                    cnt++;

                }

            }
            if(cnt <= 3) return false;
            return true;
        }).count();
        System.out.println(col);

        // Д.з 7.8

        int sum = str1.stream().map(String::length).filter((lng) -> lng > 5).reduce((a, b) -> a + b).get();
        System.out.println(sum);

        // Д.з 7.7
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('a', 1);
        map.put('s', 1);
        map.put('d', 1);
        map.put('f', 1);
        map.put('g', 1);
        System.out.println(KeyConcatenate.concatenate(map));


    }
}
