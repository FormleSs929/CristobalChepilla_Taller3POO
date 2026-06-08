
/**
 * Representa un hechizo de tipo fuego.
 */
public class HechizoFuego extends Hechizo {

    private int duracionQuemadura;

    /**
     * Constructor.
     *
     * @param nombre nombre del hechizo
     * @param dano daño base
     * @param duracionQuemadura duración de la quemadura
     */
    public HechizoFuego(String nombre,
                        int dano,
                        int duracionQuemadura) {

        super(nombre, "Fuego", dano);

        this.duracionQuemadura = duracionQuemadura;
    }

    /**
     * Obtiene la duración de la quemadura.
     *
     * @return duración
     */
    public int getDuracionQuemadura() {
        return duracionQuemadura;
    }

    /**
     * Modifica la duración de la quemadura.
     *
     * @param duracionQuemadura nueva duración
     */
    public void setDuracionQuemadura(int duracionQuemadura) {
        this.duracionQuemadura = duracionQuemadura;
    }

    /**
     * Calcula el puntaje del hechizo.
     *
     * Fórmula:
     * daño * duraciónQuemadura
     *
     * @return puntaje calculado
     */
    @Override
    public double calcularPuntaje() {

        return getDano() * duracionQuemadura;

    }

}