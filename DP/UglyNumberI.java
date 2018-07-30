package DP;


/**
 * Write a program to check whether a given number is an ugly number.
 *
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 */

public class UglyNumberI {
    public boolean validate(int n) {
        while(true) {
            if(n % 2 == 0) {
                n /= 2;
            } else if(n % 3 == 0) {
                n /= 3;
            } else if(n % 5 == 0) {
                n /= 5;
            } else {
                break;
            }
        }
        return n == 1;
    }
}
