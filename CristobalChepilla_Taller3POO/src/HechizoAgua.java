
/**
 * Representa un hechizo de tipo agua.
 */
public class HechizoAgua extends Hechizo {

    private int cantidadHeal;
    private int presionAgua;

    /**
     * Constructor.
     *
     * @param nombre nombre del hechizo
     * @param dano daño base
     * @param cantidadHeal curación
     * @param presionAgua presión del agua
     */
    public HechizoAgua(String nombre,
                       int dano,
                       int cantidadHeal,
                       int presionAgua) {

        super(nombre, "Agua", dano);

        this.cantidadHeal = cantidadHeal;
        this.presionAgua = presionAgua;

    }

    /**
     * Obtiene la cantidad de curación.
     *
     * @return curación
     */
    public int getCantidadHeal() {
        return cantidadHeal;
    }

    /**
     * Obtiene la presión del agua.
     *
     * @return presión
     */
    public int getPresionAgua() {
        return presionAgua;
    }

    /**
     * Calcula el puntaje del hechizo.
     *
     * Fórmula:
     * (daño + heal + presión) * 2
     *
     * @return puntaje calculado
     */
    @Override
    public double calcularPuntaje() {

        return (getDano()
                + cantidadHeal
                + presionAgua) * 2;

    }

}