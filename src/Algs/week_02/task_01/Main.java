package Algs.week_02.task_01;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static BufferedReader bufferedReader = null;
    public static BufferedWriter bufferedWriter = null;

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
            if(firstArr[i] <= secondArr[j])
            {
                resultSet[pointer] = firstArr[i];
                i++;
            }
            else
            {
                resultSet[pointer] = secondArr[j];
                j++;
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

        /*for (int g = 0; g < resultSet.length; g++) {
            System.out.print(resultSet[g] + " ");
        }
        System.out.println();*/

        int cursor = 0;
        for(int r = left; r < right; r++) {
            arr[r] = resultSet[cursor];
            cursor++;
        }

        //System.out.println(">> " + (left) + " " + (right-1) + " " + arr[left] + " " + (arr[right]-1));
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
            try {
                bufferedWriter.append((left+1) + " " + right + " " + array[left] + " " + (array[right-1]));
                bufferedWriter.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //System.out.println((left+1) + " " + right + " " + array[left] + " " + (array[right-1]));
        }

        //System.out.println("Длина переданного массива: " + n);
        //System.out.println("Содержание переданного массива. left=" + left + ", right=" + right);
/*        for (int i = left; i < right; i++) {
            System.out.print("array[" + i + "]=" + array[i] + " ");
        }
        System.out.println();
        System.out.println("================================");*/
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

            //start = System.nanoTime();
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

            for (int i = 0; i < array.length; i++) {
                //System.out.print(array[i] + " ");
                bufferedWriter.append(array[i] + " ");
            }
            bufferedWriter.newLine();
            bufferedWriter.flush();

            //stop = System.nanoTime();
            //System.out.println();
            //System.out.println("Execution time: " + (stop - start)/1000 + " mks");

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