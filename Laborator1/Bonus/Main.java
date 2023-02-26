package Bonus;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Bonus
 *
 * @author Popa Liliana
 */
public class Main {
    public static void main(String[] args) {
        // nr de noduri ale grafului ciclu
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti numarul de noduri ale grafului ciclu: ");
        int n = scanner.nextInt();

        // creeare matrice de adiacenta
        int[][] matrix = new int[n][n];
        Main main = new Main();
        matrix = main.createMatrix(matrix, n);
        main.powerMatrix(matrix, n);

    }
    public int[][] createMatrix(int[][] matrix, int n)
    {
     for (int i=0; i<n; i++){
         // conectez fiecare nod cu urmatorul
         matrix[i][(i+1)%n] = 1; // %n pentru a nu depasi dimensiunea matricei si pentru a conecta ultimul nod cu primul
         // conectez fiecare nod cu precedentul
         matrix[(i+1)%n][i] = 1;

     }
     // afișarea matricei de adiacenta
        System.out.println("Matricea de adiacenta este: ");
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        return matrix;
    }
    //calcularea matricei la puterea k
    public static void powerMatrix(int[][] adiacencyMatrix, int n ){

        int [][] powerMatrix = Arrays.copyOf(adiacencyMatrix, n);
        for (int power=2; power<=n; power++){
            int [][] auxMatrix = new int[n][n];
            for (int i=0; i<n; i++){
                for (int j=0; j<n; j++){
                    for (int k=0; k<n; k++){
                        auxMatrix[i][j] += powerMatrix[i][k] * adiacencyMatrix[k][j];
                    }
                }
            }
            //afișarea matricei la puterea curentă
            System.out.println("Matricea la puterea " + power + " este: ");
            for (int i=0; i<n; i++){
                for (int j=0; j<n; j++){
                    System.out.print(auxMatrix[i][j] + " ");
                }
                System.out.println();
            }
            powerMatrix = Arrays.copyOf(auxMatrix, n);
        }

    }
}
