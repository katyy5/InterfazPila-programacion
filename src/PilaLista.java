import java.util.NoSuchElementException;

public class PilaLista<T> implements PilaInterfaz<T> {
    
    private class Nodo {
        T valor;
        Nodo siguiente;

        Nodo(T dato, Nodo sig) {
            this.valor = dato;
            this.siguiente = sig;
        }
    }

    private Nodo tope;
    private int tamaño;

    public PilaLista() {
        this.tope = null;
        this.tamaño = 0;
    }

    @Override
    public boolean push(T valor) {
        tope = new Nodo(valor, tope);
        tamaño++;
        return true;
    }

    @Override
    public T pop() {
        if (tope == null) return null;
        T valor = tope.valor;
        tope = tope.siguiente;
        tamaño--;
        return valor;
    }

    @Override
    public T peek() {
        return (tope == null) ? null : tope.valor;
    }

    @Override
    public int size() {
        return tamaño;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Nodo actual = tope;
        while (actual != null) {
            sb.append(actual.valor).append(actual.siguiente != null ? ", " : "");
            actual = actual.siguiente;
        }
        return sb.append("]").toString();
    }
}
