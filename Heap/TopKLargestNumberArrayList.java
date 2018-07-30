package Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TopKLargestNumberArrayList {


    // this question is similar to kth largest number, except we need to output all top k elements
    // note that we need to implement a data structure, provide two interfaces:

    // 1. add(number). Add a new number in the data structure.
    // 2. topk(). Return the top k largest numbers in this data structure. k is given when we create the data structure.



    // 1. method 1, maintain a arraylist as data structure
    // time:   - add O(1) - topk O(NlogN)
    // space:  O(N)


    // when n is very large, memory limit exceeded

    List<Integer> list;
    int k;
    public TopKLargestNumberArrayList(int k) {
        list = new ArrayList<>();
        this.k = k;
    }

    public void add(int number) {
        list.add(number);    // O(1)
    }

    public List<Integer> topk() {
        Collections.sort(list);   // O(NlogN)
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < Math.min(k, list.size()); i++) {
            res.add(list.get(list.size() - 1 - i));
        }
        return res;
    }

}
