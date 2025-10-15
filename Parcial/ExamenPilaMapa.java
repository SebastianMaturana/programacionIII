import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExamenPilaMapa {

    static class PilaEnteros {
        private int[] datos;
        private int tope; // -1 si está vacía

        public PilaEnteros(int capacidad) {
            datos = new int[capacidad];
            tope = -1;
        }

        public boolean estaVacia() { return tope == -1; }
        public boolean estaLlena() { return tope + 1 == datos.length; }

        public void apilar(int x) {
            if (estaLlena()) throw new IllegalStateException("Pila llena");
            tope++;
            datos[tope] = x;
        }

        public int desapilar() {
            if (estaVacia()) throw new IllegalStateException("Pila vaca");
            int v = datos[tope];
            tope--;
            return v;
        }
    }

    // (50 pts) Verifica si los paréntesis están balanceados.
    public static boolean esBalanceado(String s) {
        // Usamos PilaEnteros: apilamos 1 por cada '(' y desapilamos cuando aparece ')'.
        if (s == null) return true; // consideramos nulo como balanceado
        PilaEnteros pila = new PilaEnteros(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                // apilamos un marcador (valor arbitrario)
                pila.apilar(1);
            } else if (c == ')') {
                // si no hay '(' disponible, no está balanceado
                if (pila.estaVacia()) return false;
                pila.desapilar();
            }
            // otros caracteres se ignoran
        }
        // balanceado si al final la pila está vacía
        return pila.estaVacia();
    }

    // (50 pts) Actualiza la calificación si existe el id y está en rango 0..100.
    public static boolean actualizarCalificacion(Map<Integer,Integer> califPorId, int id, int nuevo) {
        // validar rango 0..100
        if (nuevo < 0 || nuevo > 100) return false;
        // validar existencia usando containsKey
        if (!califPorId.containsKey(id)) return false;
        // actualizar con put
        califPorId.put(id, nuevo);
        return true;
    }

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        String cadena = sc.nextLine();
        System.out.println("Balanceado: " + esBalanceado(cadena));

        Map<Integer,Integer> mapa = new HashMap<Integer,Integer>();
        mapa.put(101, 70);
        System.out.println("Actualizado: " + actualizarCalificacion(mapa, 0, 150));

        sc.close();
    }
}
