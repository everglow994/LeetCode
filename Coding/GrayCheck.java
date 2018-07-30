package Coding;


/**
 * given two bytes as input, your task is to check if they can be replaced successively
 * in a gray code sequence(two successive values differ in only one bit)
 */
public class GrayCheck {
    public static int grayCheck(byte term1, byte term2) {
        int xor = term1 ^ term2;
        // calculating xor bit of 1; only can be 1;
        int count = 0;
        for(int i = 0; i < 8; i++) {
            int x = xor >> 1;
            if(x == 1) {
                count++;
            }
        }
        return count == 1 ? 1 : 0;
    }


    public static int grayCheckII(byte term1, byte term2) {
        byte x = (byte)(term1 ^ term2);
        int count = 0;
        while(x != 0) {
            x = (byte) (x & (x - 1));
            count++;
        }
        return count == 1 ? 1 : 0;

    }



    public static void main(String[] args) {
        int out;
        out = grayCheckII((byte)0x0a, (byte)0x80);
        System.out.print(out);
    }
}
