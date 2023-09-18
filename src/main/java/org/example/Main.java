package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(new File("input.txt"));
        PrintWriter out = new PrintWriter("output.txt");
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] input = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                input[i][j] = in.nextInt();
            }
        }

        in.close();

        int[][] output = new int[n][m];
        output[0][0] = input[0][0];
        out.print(output[0][0] + " ");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0) {
                    if (j == 0) continue;
                    output[i][j] = input[i][j] + output[i][j-1];
                    out.print(output[i][j] + " ");
                } else {
                    if (j == 0){
                        output[i][j] = input[i][j] + output[i-1][j];
                        out.print(output[i][j] + " ");
                    } else {
                        output[i][j] = input[i][j] + output[i][j-1];
                        int tmp = i-1;
                        while (tmp >= 0){
                            output[i][j] += input[tmp][j];
                            --tmp;
                        }
                        out.print(output[i][j] + " ");
                    }
                }
            }
            out.print("\n");
        }

        out.close();

    }

}