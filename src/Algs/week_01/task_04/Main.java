package Algs.week_01.task_04;

import java.io.*;

public class Main {

    public static void main(String[] argv) {

        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));

            int countOfValues = Integer.parseInt(bufferedReader.readLine());

            String[] arrayString = bufferedReader.readLine().split(" ");
            double[] salaries = new double[countOfValues];
            int[] position = new int[countOfValues];

            for (int i = 0; i < countOfValues; i++) {
                salaries[i] = Double.parseDouble(arrayString[i]);
                position[i] = i;

            }

            /*
            5
            10.00 8.70 0.01 5.00 3.00
            */



            for (int i = 1; i < salaries.length; i++) {
                for (int j = i; j >= 1; j--) {
                    if (salaries[j] < salaries[j - 1]) {
                        double temp = salaries[j];
                        salaries[j] = salaries[j - 1];
                        salaries[j - 1] = temp;
                        int temp2 = position[j];
                        position[j] = position[j - 1];
                        position[j - 1] = temp2;
                    } else {
                        break;
                    }
                }
            }

            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output.txt")));

            bufferedWriter.write((position[0] + 1) + " " + (position[position.length/2] + 1) + " " + (position[position.length-1] + 1));

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