package TwoPointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Two Sum III - data structure design
 */
public class TwoSumIII {

//    private HashMap<Integer, Integer> map;
//    /** Initialize your data structure here. */
//    public TwoSumIII() {
//        map = new HashMap<>();
//    }
//
//    /** Add the number to an internal data structure.. */
//    public void add(int number) {
//        map.put(map.size(), number);
//    }
//
//    /** Find if there exists any pair of numbers which sum is equal to the value. */
//    public boolean find(int value) {
//        int N = map.size();
//        HashMap<Integer, Integer> pointer =  new HashMap<>();
//        for(int i = 0; i < N; i++) {
//            int num = map.get(i);
//            int res = value - num;
//            if(pointer.containsKey(res)) return true;
//            pointer.put(num, i);
//        }
//        return false;
//    }

    private HashMap<Integer, Integer> map;
    private List<Integer> list;

    /** Initialize your data structure here. */
    public TwoSumIII() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if(map.containsKey(number)) {
            map.put(number, map.get(number) + 1);
        } else {
            map.put(number, 1);
            list.add(number);
        }
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        int N = list.size();
        for(int i = 0; i < N; i++) {
           int num = list.get(i);
           int res = value - num;
           if(num == res && map.get(num) > 1 ||
                   num != res && map.containsKey(res)) {
               return true;
           }
        }
        return false;
    }


}
