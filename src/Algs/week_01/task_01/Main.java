package Algs.week_01.task_01;

import java.io.*;
import java.nio.charset.Charset;

public class Main {

    public static void main (String[] argv) throws IOException {
        BufferedReader reader = null;

        int A;
        int B;

        try {
            reader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("input.txt"), Charset.forName("UTF-8")));
            String line;
            while ((line = reader.readLine()) != null) {

                String[] values = line.split(" ");

                A = Integer.parseInt(values[0]);
                B = Integer.parseInt(values[1]);
                Integer C = A + B;

                FileOutputStream fileOutputStream = new FileOutputStream("output.txt");
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, "UTF-8"));
                try {
                    bufferedWriter.append(C.toString());
                    bufferedWriter.flush();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } finally {
                    try {
                        bufferedWriter.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        fileOutputStream.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }


            }




        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}