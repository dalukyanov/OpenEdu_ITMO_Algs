package Algs.week_03.task_01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static BufferedReader bufferedReader = null;
    public static BufferedWriter bufferedWriter = null;

    static int getMax(int A[])
    {
        int max = A[0];
        for (int i = 1; i < A.length; i++){
            if (A[i] > max)
                max = A[i];
        }
        return max;
    }

    // Main Radix Sort sort function
    static void radixSort(int A[])
    {
        int digitPlace = 1;
        int n=A.length;
        int result[]=new int[n]; // resulting array
        // Find the largest number to know number of digits
        int largestNum = getMax(A);

        int count[]=new int[10];
        //we run loop until we reach the largest digit place
        while(largestNum/digitPlace >0){


            //Initializing counting array C[] to 0
            for (int i=0; i <10; i++)
                count[i] = 0;

            //Store the count of "keys" or digits in count[]
            for (int i = 0; i < n; i++) {
                int tmpIndex = Math.abs((A[i]/digitPlace)%10);
                count[tmpIndex]++;
            }

            // Change count[i] so that count[i] now contains actual
            //  position of this digit in result[]
            //  Working similar to the counting sort algorithm
            for (int i = 1; i < 10; i++)
                count[i] += count[i - 1];

            // Build the resulting array
            for (int i = n - 1; i >= 0; i--) {
                int tmpIndex = Math.abs((A[i]/digitPlace)%10);
                result[count[tmpIndex] - 1] = A[i];
                count[tmpIndex]--;
            }

            // Now main array A[] contains sorted
            // numbers according to current digit place
            for (int i = 0; i < n; i++)
                A[i] = result[i];

            // Move to next digit place
            digitPlace *= 10;
        }
    }

    public static void countingSort(int[] input, int k) {
        // Создание массива ячеек
        int counter[] = new int[k + 1];

        // Заполнение ячеек. Индекс ячейки равен значению в исходном массиве.
        for (int i = 0; i < input.length; i++) {
            counter[input[i]]++;
        }

        // Сортировка масива
        int ndx = 0;
        for (int i = 0; i < counter.length; i++) {
            while (0 < counter[i]) {
                input[ndx++] = i;
                counter[i]--;
            }
        }
    }

    public static void mergeSort (int[] array, int left, int right) {
        int n = right - left;
        if (n == 0) {
            return;
        } else if (n == 1) {
            return;
        } else {
            int mid;
            if (n % 2 == 0) {
                mid = (n / 2);
            } else {
                mid = (n / 2)+1;
            }

            mergeSort(array, left, left+mid);
            mergeSort(array, left+mid, right);
            merge(array, left, left+mid, right);
        }
    }

    public static void merge(int arr[], int left, int mid, int right)
    {

        if (right-left < 1) {
            return;
        }

        int[] firstArr = Arrays.copyOfRange(arr, left, mid);
        int[] secondArr = Arrays.copyOfRange(arr, mid, right);
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

        int cursor = 0;
        for(int r = left; r < right; r++) {
            arr[r] = resultSet[cursor];
            cursor++;
        }
    }

    public static void bucketSort(int[] a, int maxVal) {
        int [] bucket=new int[maxVal+1];

        for (int i=0; i<bucket.length; i++) {
            bucket[i]=0;
        }

        for (int i=0; i<a.length; i++) {
            bucket[a[i]]++;
        }

        int outPos=0;
        for (int i=0; i<bucket.length; i++) {
            for (int j=0; j<bucket[i]; j++) {
                a[outPos++]=i;
            }
        }
    }

    public static int maxValue (int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void printArray (int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] argv) {

        long start = 0;
        long finish = 0;

        try {

            start = System.nanoTime();

            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output.txt")));

            // Инициализация переменных, и заполнение массивов из входных данных
            String[] inputStringArray = bufferedReader.readLine().split(" ");
            int firstArrLength = Integer.parseInt(inputStringArray[0]);
            int secondArrLength = Integer.parseInt(inputStringArray[1]);

            int[] arrayA = new int[firstArrLength];

            inputStringArray = bufferedReader.readLine().split(" ");
            for (int i = 0; i < firstArrLength; i++) {
                arrayA[i] = Integer.parseInt(inputStringArray[i]);
            }

            int[] arrayB = new int[secondArrLength];

            inputStringArray = bufferedReader.readLine().split(" ");
            for (int i = 0; i < secondArrLength; i++) {
                arrayB[i] = Integer.parseInt(inputStringArray[i]);
            }

            // Начало полезной логики программы
            // Размер результирующего массива равен декартовому произведению входящих в него массивов
            int[] arrayC = new int[firstArrLength * secondArrLength];
            int pointerInArrayC = 0;

            //Arrays.sort(arrayA);
            //Arrays.sort(arrayB);

            for (int i = 0; i < arrayB.length; i++) {
                for (int j = 0; j < arrayA.length; j++) {
                    arrayC[pointerInArrayC] = arrayA[j] * arrayB[i];
                    pointerInArrayC++;
                }
            }


            //printArray(arrayC);

            // До этого момента всё работает как надо
            // Начало сортировки алгоритмом с линейным временем выполнения (пробую сортировкой подсчётом)
            // Сортировка подсчёта не подошла, т.к. число возможных чисел (k) превышает 1.6 млрд. Переполнение памяти
            // Сортировка слиянием не укладывается во время, и отваливаетя при размерах массивов n = 6000 и m = 3000
            // Пытаюсь использовать карманную сортировку. Не работает на крайних значениях.
            // А работает ли Arrays.sort?? Не проходит по времени.
            // Пробуем цифровую сортировку типа LSD


            //Arrays.sort(arrayC); // Время выполнения: 12251 ms

            // countingSort(arrayC, 1600000001); // Переполнение памяти
            // mergeSort(arrayC, 0, arrayC.length); // Время выполнения: 21527 ms
            // bucketSort(arrayC, maxValue(arrayC)); // Переполнение памяти
            radixSort(arrayC);

            // После этого момента всё работает как надо
            //printArray(arrayC);

            // Подсчёт суммы каждых десятых членов массива, и вывод результата в файл
            long sumOfTenthElements = 0;
            for (int i = 0; i < arrayC.length; i = i+10 ) {
                sumOfTenthElements = sumOfTenthElements + arrayC[i];
            }

            bufferedWriter.write(String.valueOf(sumOfTenthElements));


            finish = System.nanoTime();
            System.out.println("Время выполнения: " + (finish - start)/1000/1000 + " ms");

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
