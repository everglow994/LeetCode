package Debugging;

public class PrintPattern {


    // print result
    // a
    // ab
    // abc





    public static void print(int row) {
        for(int i = 1; i <= row; i++) {
            char ch = 'a';
            char print = ch;
            for(int j = 0; j <= i; j++) {
                System.out.print((ch++));
            }
            System.out.println();
        }
    }


    public static void printD(int row) {
        for(int i = 1; i <= row; i++) {
            char ch = 'a';
            char print = ch;
            for(int j = 0; j <= i; j++) {
                System.out.print((print++)); // this line
            }
            System.out.println();
        }
    }
}
