
/**
 * Representa un hechizo de tipo planta.
 */
public class HechizoPlanta extends Hechizo {

    private int duracionStun;
    private int cantidadPlantas;

    /**
     * Constructor.
     *
     * @param nombre nombre del hechizo
     * @param dano daño base
     * @param duracionStun duración del aturdimiento
     * @param cantidadPlantas cantidad de plantas invocadas
     */
    public HechizoPlanta(String nombre,
                         int dano,
                         int duracionStun,
                         int cantidadPlantas) {

        super(nombre, "Planta", dano);

        this.duracionStun = duracionStun;
        this.cantidadPlantas = cantidadPlantas;

    }

    /**
     * Obtiene la duración del stun.
     *
     * @return duración
     */
    public int getDuracionStun() {
        return duracionStun;
    }

    /**
     * Obtiene la cantidad de plantas.
     *
     * @return cantidad de plantas
     */
    public int getCantidadPlantas() {
        return cantidadPlantas;
    }

    /**
     * Calcula el puntaje del hechizo.
     *
     * Fórmula:
     * daño + (duraciónStun * cantidadPlantas)
     *
     * @return puntaje calculado
     */
    @Override
    public double calcularPuntaje() {

        return getDano()
                + (duracionStun * cantidadPlantas);

    }

}