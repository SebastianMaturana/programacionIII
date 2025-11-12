package Parcial3;

import java.util.Arrays;

public class SolucionParcial3 {
    public static int[] dijkstra(int[][] grafo, int origen) {
        int n = grafo.length;
        int[] distancia = new int[n];
        boolean[] visitado = new boolean[n];
        return distancia;
    }
    public static void burbuja(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = 0; j < arr.length - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }
        static int datos[] = {64, 34, 25, 12, 22, 11, 90};
        public static void main(String[] args) {
        int[][] grafo = {
            {0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 14, 10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        int[] a1 = datos.clone();
        burbuja(a1);
        System.out.println("Burbuja: " + Arrays.toString(a1));
        int[] a2 = datos.clone();
 }
}