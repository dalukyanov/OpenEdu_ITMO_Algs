package Algs.week_01.task_05;

import java.io.*;

public class Main {

    public static StringBuilder stringBuilder = new StringBuilder();

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        stringBuilder.append("Swap elements at indices ");
        stringBuilder.append(j + 1);
        stringBuilder.append(" and ");
        stringBuilder.append(i + 1);
        stringBuilder.append(".\n");
    }

    public static void sort(int[] array) {
        int h = 1;
        while (h*3 < array.length)
            h = h * 3 + 1;

        while(h >= 1) {
            hSort(array, h);
            h = h/3;
        }
    }

    private static void hSort(int[] array, int h) {
        int length = array.length;
        for (int i = h; i < length; i++) {
            for (int j = i; j >= h; j = j - h) {
                if (array[j] < array[j - h])
                    swap(array, j, j - h);
                else
                    break;
            }
        }
    }

    public static void main(String[] argv) {

        long start;
        long stop;

        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {
//            start = System.nanoTime();

            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));

            int countOfValues = Integer.parseInt(bufferedReader.readLine());

            String[] arrayString = bufferedReader.readLine().split(" ");
            int[] numbers = new int[countOfValues];

            for (int i = 0; i < countOfValues; i++) {
                numbers[i] = Integer.parseInt(arrayString[i]);
            }

            sort(numbers);

            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output.txt")));
            bufferedWriter.append(stringBuilder);
            bufferedWriter.append("No more swaps needed.\n");

            for (int i = 0; i < numbers.length; i++) {
                bufferedWriter.append(numbers[i] + " ");
            }

            bufferedWriter.flush();

//            stop = System.nanoTime();
//            System.out.println("Execution time: " + (stop - start)/1000000 + " ms");

            //bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output.txt")));


/*            start = System.nanoTime();
            for(int i = 1; i < numbers.length; i++) {
                for (int j = i; j >= 1; j--) {
                    if (numbers[j - 1] > numbers[j]) {
                        int temp = numbers[j - 1];
                        numbers[j - 1] = numbers[j];
                        numbers[j] = temp;
                        stringBuilder.append("Swap elements at indices ");
                        stringBuilder.append(j);
                        stringBuilder.append(" and ");
                        stringBuilder.append((j + 1));
                        stringBuilder.append(".\n");
                    } else {
                        break;
                    }
                }
            }


            stringBuilder.append("No more swaps needed.\n");

            for (int i = 0; i < numbers.length; i++) {
                stringBuilder.append(numbers[i] + " ");
            }

            FileWriter fileWriter = new FileWriter("output.txt");
            //bufferedWriter.write(String.valueOf(stringBuilder));
            fileWriter.write(String.valueOf(stringBuilder));

            stop = System.nanoTime();

            System.out.println("Execution time: " + (stop - start)/1000000 + " ms");*/

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