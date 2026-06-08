
/**
 * Representa un hechizo de tipo tierra.
 */
public class HechizoTierra extends Hechizo {

    private int mejoraDefensa;

    /**
     * Constructor.
     *
     * @param nombre nombre del hechizo
     * @param dano daño base
     * @param mejoraDefensa mejora de defensa
     */
    public HechizoTierra(String nombre,
                         int dano,
                         int mejoraDefensa) {

        super(nombre, "Tierra", dano);

        this.mejoraDefensa = mejoraDefensa;

    }

    /**
     * Obtiene la mejora de defensa.
     *
     * @return mejora de defensa
     */
    public int getMejoraDefensa() {
        return mejoraDefensa;
    }

    /**
     * Modifica la mejora de defensa.
     *
     * @param mejoraDefensa nuevo valor
     */
    public void setMejoraDefensa(int mejoraDefensa) {
        this.mejoraDefensa = mejoraDefensa;
    }

    /**
     * Calcula el puntaje del hechizo.
     *
     * Fórmula:
     * (daño * mejoraDefensa) / 2
     *
     * @return puntaje calculado
     */
    @Override
    public double calcularPuntaje() {

        return (getDano() * mejoraDefensa) / 2.0;

    }

}