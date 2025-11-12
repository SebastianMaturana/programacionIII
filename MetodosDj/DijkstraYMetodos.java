package MetodosDj;
import java.util.Arrays;

public class DijkstraYMetodos {

    // ===== ALGORITMO DE DIJKSTRA =====
    public static void dijkstra(int[][] grafo, int origen) {
        int n = grafo.length;
        int[] distancia = new int[n];
        boolean[] visitado = new boolean[n];

        Arrays.fill(distancia, 9999);
        distancia[origen] = 0;

        for (int i = 0; i < n - 1; i++) {
            int u = minimo(distancia, visitado);
            visitado[u] = true;

            for (int v = 0; v < n; v++) {
                if (!visitado[v] && grafo[u][v] != 0 &&
                    distancia[u] + grafo[u][v] < distancia[v]) {
                    distancia[v] = distancia[u] + grafo[u][v];
                }
            }
        }

        System.out.println("Distancias desde el nodo " + origen + ":");
        for (int i = 0; i < n; i++) {
            System.out.println("A " + i + " -> " + distancia[i]);
        }
    }

    // Busca el nodo con menor distancia no visitado
    public static int minimo(int[] dist, boolean[] vis) {
        int min = 9999, pos = -1;
        for (int i = 0; i < dist.length; i++) {
            if (!vis[i] && dist[i] < min) {
                min = dist[i];
                pos = i;
            }
        }
        return pos;
    }

    // ===== MÉTODOS DE ORDENAMIENTO =====

    // Método Burbuja
    public static void burbuja(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = 0; j < arr.length - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }

    // Método Inserción
    public static void insercion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int clave = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > clave) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = clave;
        }
    }

    // Método Selección
    public static void seleccion(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[min]) min = j;
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    // QuickSort
    public static void quickSort(int[] arr, int inicio, int fin) {
        if (inicio < fin) {
            int pi = particion(arr, inicio, fin);
            quickSort(arr, inicio, pi - 1);
            quickSort(arr, pi + 1, fin);
        }
    }

    public static int particion(int[] arr, int inicio, int fin) {
        int pivote = arr[fin];
        int i = inicio - 1;
        for (int j = inicio; j < fin; j++) {
            if (arr[j] < pivote) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[fin];
        arr[fin] = temp;
        return i + 1;
    }

    // MergeSort
    public static void mergeSort(int[] arr, int izq, int der) {
        if (izq < der) {
            int mid = (izq + der) / 2;
            mergeSort(arr, izq, mid);
            mergeSort(arr, mid + 1, der);
            merge(arr, izq, mid, der);
        }
    }

    public static void merge(int[] arr, int izq, int mid, int der) {
        int n1 = mid - izq + 1;
        int n2 = der - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) L[i] = arr[izq + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];
        int i = 0, j = 0, k = izq;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // ===== MAIN =====
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

        System.out.println("=== Algoritmo de Dijkstra ===");
        dijkstra(grafo, 0);

        int[] datos = {64, 25, 12, 22, 11};
        System.out.println("\nArreglo original: " + Arrays.toString(datos));

        int[] a1 = datos.clone();
        burbuja(a1);
        System.out.println("Burbuja: " + Arrays.toString(a1));

        int[] a2 = datos.clone();
        insercion(a2);
        System.out.println("Inserción: " + Arrays.toString(a2));

        int[] a3 = datos.clone();
        seleccion(a3);
        System.out.println("Selección: " + Arrays.toString(a3));

        int[] a4 = datos.clone();
        quickSort(a4, 0, a4.length - 1);
        System.out.println("Quick Sort: " + Arrays.toString(a4));

        int[] a5 = datos.clone();
        mergeSort(a5, 0, a5.length - 1);
        System.out.println("Merge Sort: " + Arrays.toString(a5));
    }
}
