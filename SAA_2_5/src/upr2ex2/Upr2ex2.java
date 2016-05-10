//Програма за пренареждане на нулевите елементи
//в края на едномерен масив без използването на друг масив.
package upr2ex2;

import java.util.Scanner;

public class Upr2ex2 {

    public static final int n = 6;

    public static void main(String[] args) {
        int j = 0;
        Scanner input = new Scanner(System.in);
        int[] array = new int[n];
        System.out.println("Enter numbres in the array: ");
        for (int i = 0; i < n; i++) {
            array[i] = input.nextInt();
        }
        for (int i = 0; i <= array.length-1; i++) {
            if (array[i] != 0) {
                array[j] = array[i];
                j++;
            }
        }
        for (int i = j; i <= array.length-1; i++) {
            array[i] = 0;
        }
        System.out.println(" ");
        for (int i = 0; i <= array.length-1; i++) {
            System.out.println(array[i]);
        }
    }
}
