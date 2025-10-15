import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExamenColaMapa {

    static class ColaCircularEnteros {
        private int[] datos;
        private int cabeza;
        private int cola;
        private int tam;

        public ColaCircularEnteros(int capacidad) {
            datos = new int[capacidad];
            cabeza = 0;
            cola = 0;
            tam = 0;
        }

        public boolean estaVacia() { return tam == 0; }
        public boolean estaLlena() { return tam == datos.length; }

        public void encolar(int x) {
            if (estaLlena()) throw new IllegalStateException("Cola llena");
            datos[cola] = x;
            cola = (cola + 1) % datos.length;
            tam++;
        }

        public int desencolar() {
            if (estaVacia()) throw new IllegalStateException("Cola vacía");
            int v = datos[cabeza];
            cabeza = (cabeza + 1) % datos.length;
            tam--;
            return v;
        }
    }

    // (50 pts) Calcula el balance de paréntesis encolando +1 y -1.
    public static int balanceConCola(String s) {
        ColaCircularEnteros cola = new ColaCircularEnteros(s.length());
        // Recorre la cadena y encola valores según el tipo de paréntesis
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                cola.encolar(+1);  // +1 por cada '('
            } else if (c == ')') {
                cola.encolar(-1);  // -1 por cada ')'
            }
        }
        // Desencola y suma todos los valores para obtener el balance total
        int suma = 0;
        while (!cola.estaVacia()) {
            suma += cola.desencolar();
        }
        return suma;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cadena = sc.nextLine();
        System.out.println("Balance cola: " + balanceConCola(cadena));
        sc.close();
    }
}