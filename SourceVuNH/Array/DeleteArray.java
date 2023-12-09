/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.util.Scanner;

/**
 *
 * @author d
 */
public class DeleteArray {

    private static Scanner sc = new Scanner(System.in);

    public static void deleteElement(int[] a, int value) {
        int n = a.length;
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] != value) {
                a[k] = a[i];
                k++;
            }
        }
        for (int i = 0; i < k; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
//        for (int i = 0; i < a.length; i++) {
//            if (a[i] != value) {
//                System.out.print(a[i] + " ");
//            }
//        }
//        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        System.out.print("Enter valude want delete: ");
        int value = Integer.parseInt(sc.nextLine());
        deleteElement(nums, value);
    }
}
