package BitManipulation;

public class SingleNumberIII {

    public int[] singleNumberIII(int[] nums) {

        int a  = 0;

        // get XOR of two number;
        for(int num: nums) {
            a = a ^ num;
        }

        // get arbitrary set bit, here the last one
        a = a & -a;
        int[] res = {0 , 0};

        for(int num: nums) {
            if((num & a) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }

        return res;
    }
}
