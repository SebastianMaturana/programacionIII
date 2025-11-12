package Grafos;
import java.util.ArrayList;
import java.util.List;
 
public class Grafo {
 
    static class Arista {
        int destino;
        int peso;
 
        Arista(int destino, int peso) {
            this.destino = destino;
            this.peso = peso;
        }
    }
 
    private List<List<Arista>> lista;
 
    public Grafo(int numVertices) {
        lista = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            lista.add(new ArrayList<>());
        }
    }
 
    public void agregarArista(int u, int v, int peso) {
        lista.get(u).add(new Arista(v, peso));
    }
 
    public void mostrar() {
        char[] nombres = {'A', 'B', 'C', 'D', 'E', 'F'};
        for (int i = 0; i < lista.size(); i++) {
            System.out.print(nombres[i] + " -> ");
            for (Arista a : lista.get(i)) {
                System.out.print(nombres[a.destino] + "(" + a.peso + ") ");
            }
            System.out.println();
        }
    }
 
    public static void main(String[] args) {
        Grafo g = new Grafo(6);
 
        g.agregarArista(0, 1, 2);
        g.agregarArista(0, 2, 1);
        g.agregarArista(1, 2, 8);
        g.agregarArista(1, 3, 4);
        g.agregarArista(2, 4, 3);
        g.agregarArista(3, 4, 6);
        g.agregarArista(3, 5, 1);
        g.agregarArista(4, 5, 2);
 
        g.mostrar();
    }
}