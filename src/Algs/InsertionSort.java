package Algs;

public class InsertionSort {
    public static void main(String[] argv) {

        //int[] arr = {5, 2, 4, 6, 1, 3};
        int[] arr = {5, 2, 4};

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j >= 1; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
