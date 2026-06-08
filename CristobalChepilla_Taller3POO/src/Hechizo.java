
/**
 * Clase abstracta que representa
 * un hechizo genérico.
 */
public abstract class Hechizo implements Puntuable {

    private String nombre;
    private String tipo;
    private int dano;

    /**
     * Constructor de la clase Hechizo.
     *
     * @param nombre nombre del hechizo
     * @param tipo tipo elemental
     * @param dano daño base
     */
    public Hechizo(String nombre, String tipo, int dano) {

        this.nombre = nombre;
        this.tipo = tipo;
        this.dano = dano;

    }

    /**
     * Obtiene el nombre del hechizo.
     *
     * @return nombre del hechizo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el tipo elemental.
     *
     * @return tipo del hechizo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Obtiene el daño base.
     *
     * @return daño del hechizo
     */
    public int getDano() {
        return dano;
    }

    /**
     * Modifica el nombre del hechizo.
     *
     * @param nombre nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Modifica el daño del hechizo.
     *
     * @param dano nuevo daño
     */
    public void setDano(int dano) {
        this.dano = dano;
    }

    /**
     * Retorna información resumida.
     *
     * @return texto descriptivo
     */
    @Override
    public String toString() {

        return nombre + " | " + tipo + " | Daño: " + dano;

    }

}