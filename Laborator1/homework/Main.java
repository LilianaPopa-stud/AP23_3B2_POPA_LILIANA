package homework;

import java.util.Arrays;

/**
 * Homework
 *
 * @author Popa Liliana
 */
public class Main {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        if (args.length != 1) {
            System.err.println("Nu a fost dat niciun parametru la linia de comanda");
            System.exit(-1);
        } else {
            Main app = new Main();
            int n = Integer.parseInt(args[0]);
            int[] symbols = new int[n];
            for (int i = 0; i < n; i++)
                symbols[i] = i + 1;
            int[][] matrix = app.createLatinMatrix(n, symbols);
            if (n>30_000)
            {
                long endTime = System.nanoTime();
                long timeDifference = endTime - startTime;
                System.out.println(timeDifference);

            }
            else
                app.display(matrix,n);
        }
    }

    public int[][] createLatinMatrix(int n, int[] symbols) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i] = Arrays.copyOf(symbols, n);
            //shift symbols
            int aux = symbols[n - 1];
            for (int s = n - 2; s >= 0; s--) {
                symbols[s + 1] = symbols[s];
            }
            symbols[0] = aux;
        }
        return matrix;
    }

    public void display(int[][] matrix, int n)
    {
        for (int i = 0; i<n; i++)
        {
            StringBuilder concatenation = new StringBuilder();
            for (int j=0; j<n; j++)
                concatenation.append(matrix[i][j]);
            System.out.println(concatenation);
        }
        for (int i = 0; i<n; i++)
        {
            StringBuilder concatenation = new StringBuilder();
            for (int j=0; j<n; j++)
                concatenation.append(matrix[j][i]);
            System.out.println(concatenation);
        }
    }
}
