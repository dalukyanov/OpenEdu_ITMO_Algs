package Algs.week_01.task_03;

import java.io.*;

public class Main {

    public static void main(String[] argv) {

        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));

            int countOfValues = Integer.parseInt(bufferedReader.readLine());

            String[] arrayString = bufferedReader.readLine().split(" ");
            int[] arr = new int[countOfValues];
            int[] position = new int[countOfValues];

            for (int i = 0; i < arrayString.length; i++) {
                arr[i] = Integer.parseInt(arrayString[i]);
                position[i] = i+1;
            }

            // 1 8 4 2 3 7 5 6 9 0
            // 1 2 2 2 3 5 5 6 9 1

            for (int i = 1; i < arr.length; i++) {
                for (int j = i; j >= 1; j--) {

                    if (arr[j] < arr[j - 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j-1];
                        arr[j-1] = temp;
                        position[i]--;

                    } else {
                        break;
                    }
                }
            }

            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output.txt")));

            for (int i = 0; i < position.length; i++) {
                bufferedWriter.append(position[i] + " ");
            }
            bufferedWriter.newLine();

            /*
            1 2 2 2 3 5 5 6 9 1
            0 1 2 3 4 5 6 7 8 9
            */

            for (int i = 0; i < arr.length; i++) {
                bufferedWriter.append(arr[i] + " ");
            }

            bufferedWriter.flush();



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