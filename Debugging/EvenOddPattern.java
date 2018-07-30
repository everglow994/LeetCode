package Debugging;

public class EvenOddPattern {
    public static void printPattern(int num) {
        int i, print = 0;
        if (num % 2 == 0) {
            print = 0;
            for (i = 0; i < num; i++)
                System.out.print(print + " ");
            print += 2;

        } else {
            print = 1;
            for (i = 0; i < num; i++)
                System.out.print(print + " ");
            print += 2;
        }
    }

    public static void printPatternD(int num) {
        int i, print = 0;
        if (num % 2 == 0) {
            print = 0;
            for (i = 0; i < num; i++) { // curly bracket
                System.out.print(print + " ");
                print += 2;
            }
        } else {
            print = 1;
            for (i = 0; i < num; i++) { // curly bracket
                System.out.print(print + " ");
                print += 2;
            }
        }

    }
}

