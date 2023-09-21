package org.example;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("input.txt"));
        PrintWriter out = new PrintWriter("output.txt");

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] input = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < m; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] output = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int sum = input[i][j];
                if (i > 0) {
                    sum += output[i - 1][j];
                }
                if (j > 0) {
                    sum += output[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    sum -= output[i - 1][j - 1];
                }
                output[i][j] = sum;
                out.print(sum + " ");
            }
            out.println();
        }

        in.close();
        out.close();
    }
}
