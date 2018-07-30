package Debugging;

public class CountDigit {
    public int find(int num) {
        int count = 0;
        while(num != 0) {
            num = num / 10;
            count++;
        }
        return num % count;
    }

    public int findD(int num) {
        int count = 0;
        int temp = num;  // this line
        while(num != 0) {
            num = num / 10;
            count++;
        }
        return temp % count; // this line
    }
}
