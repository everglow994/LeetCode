package BitManipulation;

public class SingleNumberII {

    // bit manipulation
    //                   a  b
    // initial state     0  0
    // first state       x  0
    // second state      0  x
    // third  state      0  0

    public int singleNumberII(int[] nums) {
        int a = 0, b = 0;
        for(int num: nums) {
            a = (a ^ num) & ~b;
            b = (b ^ num) & ~a;
        }
        return a;
    }
}
