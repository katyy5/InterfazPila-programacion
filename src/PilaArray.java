
	import java.util.Arrays;

	public class PilaArray<T> implements PilaInterfaz<T> {
	    private static final int CAPACIDAD_INICIAL = 10;
	    private Object[] elementos;
	    private int tope;

	    public PilaArray() {
	        this.elementos = new Object[CAPACIDAD_INICIAL];
	        this.tope = 0;
	    }

	    @Override
	    public boolean push(T valor) {
	        if (tope == elementos.length) {
	            elementos = Arrays.copyOf(elementos, elementos.length * 2);
	        }
	        elementos[tope++] = valor;
	        return true;
	    }

	    @Override
	    public T pop() {
	        if (tope == 0) return null;
	        T valor = (T) elementos[--tope];
	        elementos[tope] = null; // Evita memoria inaccesible
	        return valor;
	    }

	    @Override
	    public T peek() {
	        if (tope == 0) return null;
	        return (T) elementos[tope - 1];
	    }

	    @Override
	    public int size() {
	        return tope;
	    }

	    @Override
	    public String toString() {
	        return Arrays.toString(Arrays.copyOf(elementos, tope));
	    }
	}

	


