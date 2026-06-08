
import java.util.ArrayList;

/**
 * Representa un mago y los hechizos
 * que domina.
 */
public class Mago {

    private String nombre;
    private ArrayList<Hechizo> hechizos;

    /**
     * Constructor.
     *
     * @param nombre nombre del mago
     */
    public Mago(String nombre) {

        this.nombre = nombre;
        this.hechizos = new ArrayList<>();

    }

    /**
     * Obtiene el nombre del mago.
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la lista de hechizos.
     *
     * @return colección de hechizos
     */
    public ArrayList<Hechizo> getHechizos() {
        return hechizos;
    }

    /**
     * Agrega un hechizo al mago.
     *
     * @param hechizo hechizo a agregar
     */
    public void agregarHechizo(Hechizo hechizo) {

        hechizos.add(hechizo);

    }

    /**
     * Elimina un hechizo del mago.
     *
     * @param hechizo hechizo a eliminar
     */
    public void eliminarHechizo(Hechizo hechizo) {

        hechizos.remove(hechizo);

    }

    /**
     * Calcula la puntuación total del mago
     * sumando los puntajes de sus hechizos.
     *
     * @return puntaje total
     */
    public double calcularPuntaje() {

        double total = 0;

        for(Hechizo h : hechizos){

            total += h.calcularPuntaje();

        }

        return total;

    }

    /**
     * Retorna el nombre del mago.
     *
     * @return nombre
     */
    @Override
    public String toString() {

        return nombre;

    }

}