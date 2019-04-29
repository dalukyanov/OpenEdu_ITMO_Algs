package Algs.week_02.task_03;

import java.io.*;
import java.util.Random;

public class Main {

    public static BufferedReader bufferedReader = null;
    public static BufferedWriter bufferedWriter = null;
    static int counter = 0;
    // 10
    // 1 8 2 1 4 7 3 2 3 6


    public static void quickSort(int[] arr, int left, int right) {
        int i, j, key, buf;
        key = arr[(left - right) / 2];
        i = left;
        j = right;

        do {

            while (arr[i] < key) {
                i++;
            }
            while (key < arr[j]) {
                j--;
            }

            if (i <= j) {
                buf = arr[i];
                arr[i] = arr[j];
                arr[j] = buf;
                i++;
                j--;
            }
        } while (i > j);

            if (left < j) {
            quickSort(arr, left, j);
            }

            if (i < right) {
                quickSort(arr, i, right);
            }

    }

    public static void printArray (int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void main(String[] argv) {

        long start;
        long stop;

        try {

            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output.txt")));

            /*
            Считывание значений из файла, и инициализация исходного массива.
             */

            /*            start = System.nanoTime();    */
            int countOfValues = Integer.parseInt(bufferedReader.readLine());
            String[] arrayString = bufferedReader.readLine().split(" ");

            int[] array = new int[countOfValues];
            for (int i = 0; i < countOfValues; i++) {
                array[i] = Integer.parseInt(arrayString[i]);
            }

            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();

            /* 1 8 2 1 4 7 3 2 3 6 */

            //split(array, 0, array.length, 4);

            //System.out.println("Результат разделения: " + split(array, 0, array.length, 3));

            quickSort(array, 0, array.length);

            printArray(array);

            System.out.println();
            System.out.println(counter);
/*            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }*/

/*            stop = System.nanoTime();
            System.out.println();
            System.out.println("Execution time: " + (stop - start)/1000 + " mks");*/

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    System.err.println("Не могу закрыть bufferedReader..");
                    e.printStackTrace();
                }
            }

            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    System.err.println("Не могу закрыть bufferedWriter..");
                    e.printStackTrace();
                }
            }
        }
    }
}
