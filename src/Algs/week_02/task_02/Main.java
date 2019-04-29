package Algs.week_02.task_02;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static BufferedReader bufferedReader = null;
    public static BufferedWriter bufferedWriter = null;
    public static long inversions = 0;

    /*
     * Метод, сливающий два отсортированных массива в один
     * */

    public static void merge(int arr[], int left, int mid, int right)
    {

        if (right-left < 1) {
            return;
        }

        int[] firstArr = Arrays.copyOfRange(arr, left, mid);
        //System.out.println(firstArr.length);
        int[] secondArr = Arrays.copyOfRange(arr, mid, right);
        //System.out.println(secondArr.length);
        int[] resultSet = new int[firstArr.length+secondArr.length];

        // Итераторы для двух подмассивов
        int i = 0;
        int j = 0;
        // Итератор для суммарного массива
        int pointer = 0;

        while(i < firstArr.length && j < secondArr.length)
        {
            boolean checked = false;

            if(firstArr[i] <= secondArr[j])
            {
                resultSet[pointer] = firstArr[i];
                i++;
            }
            else
            {
                resultSet[pointer] = secondArr[j];
                j++;
                if (checked == false) {
                    inversions = inversions + (firstArr.length -  i);
                }
            }
            pointer++;
        }
        // Сбор оставшихся элементов
        while(i < firstArr.length)
        {
            resultSet[pointer] = firstArr[i];
            i++;
            pointer++;
        }
        while(j < secondArr.length)
        {
            resultSet[pointer] = secondArr[j];
            j++;
            pointer++;
        }

        int cursor = 0;
        for(int r = left; r < right; r++) {
            arr[r] = resultSet[cursor];
            cursor++;
        }
    }

    public static void mergeSort (int[] array, int left, int right) {
        int n = right - left;
        if (n == 0) {
            //System.out.println("Массив нулевой длины");
            return;
        } else if (n == 1) {
            //System.out.println("Массив единичной длины");
            return;
        } else {
            int mid;
            if (n % 2 == 0) {
                mid = (n / 2);
            } else {
                mid = (n / 2)+1;
            }

            //System.out.println("mid=" + mid);
            mergeSort(array, left, left+mid);
            mergeSort(array, left+mid, right);

         /* 1 8 2 1 4 7 3 2 3 6
            1 2 1 8
            3 4 1 2
            1 4 1 8
            5 6 4 7
            1 6 1 8
            7 8 2 3
            9 10 3 6
            7 10 2 6
            1 10 1 8
            1 1 2 2 3 3 4 6 7 8  */

            merge(array, left, left+mid, right);
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

/*            start = System.nanoTime();*/
            int countOfValues = Integer.parseInt(bufferedReader.readLine());
            String[] arrayString = bufferedReader.readLine().split(" ");

            int[] array = new int[countOfValues];
            for (int i = 0; i < countOfValues; i++) {
                array[i] = Integer.parseInt(arrayString[i]);
            }

            /*
             * Сортировка слиянием
             * */

            mergeSort(array,0, array.length);

            //System.out.println(inversions);
            bufferedWriter.write(String.valueOf(inversions));

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