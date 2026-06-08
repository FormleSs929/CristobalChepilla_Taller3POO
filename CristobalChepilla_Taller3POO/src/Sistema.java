
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {

    private ArrayList<Mago> magos;
    private ArrayList<Hechizo> hechizos;
    private Scanner scanner;

    /**
     * Constructor del sistema.
     */
    public Sistema() {

        magos = new ArrayList<>();
        hechizos = new ArrayList<>();
        scanner = new Scanner(System.in);

    }

    /**
     * Inicia el programa.
     */
    public void iniciar() {

        cargarHechizos();
        cargarMagos();

        menuPrincipal();

    }

    /**
     * Muestra el menú principal.
     */
    public void menuPrincipal() {

        int opcion = 0;

        do {

            System.out.println("\n=== SISTEMA DE MAGOS ===");
            System.out.println("1. Administrador");
            System.out.println("2. Analista");
            System.out.println("3. Salir");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch(opcion) {

                case 1:
                    menuAdministrador();
                    break;

                case 2:
                    menuAnalista();
                    break;

                case 3:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opción inválida.");

            }

        } while(opcion != 3);

    }

    /**
     * Menú administrador.
     */
    public void menuAdministrador() {

        int opcion = 0;

        do {

            System.out.println("\n=== PANEL ADMINISTRADOR ===");

            System.out.println("1. Agregar Mago");
            System.out.println("2. Modificar Mago");
            System.out.println("3. Eliminar Mago");
            System.out.println("4. Agregar Hechizo");
            System.out.println("5. Modificar Hechizo");
            System.out.println("6. Eliminar Hechizo");
            System.out.println("7. Volver");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch(opcion) {

                case 1:
                    agregarMago();
                    break;

                case 2:
                    modificarMago();
                    break;

                case 3:
                    eliminarMago();
                    break;

                case 4:
                    agregarHechizo();
                    break;

                case 5:
                    modificarHechizo();
                    break;

                case 6:
                    eliminarHechizo();
                    break;

            }

        } while(opcion != 7);

    }

    /**
     * Menú analista.
     */
    public void menuAnalista() {

        int opcion = 0;

        do {

            System.out.println("\n=== PANEL ANALISTA ===");

            System.out.println("1. Top 10 Mejores Hechizos");
            System.out.println("2. Top 3 Mejores Magos");
            System.out.println("3. Mostrar todos los Hechizos");
            System.out.println("4. Mostrar todos los Magos");
            System.out.println("5. Mostrar Hechizos con puntuación");
            System.out.println("6. Mostrar Magos con puntuación");
            System.out.println("7. Volver");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch(opcion) {

                case 1:
                    top10Hechizos();
                    break;

                case 2:
                    top3Magos();
                    break;

                case 3:
                    mostrarHechizos();
                    break;

                case 4:
                    mostrarMagos();
                    break;

                case 5:
                    mostrarHechizosConPuntaje();
                    break;

                case 6:
                    mostrarMagosConPuntaje();
                    break;

            }

        } while(opcion != 7);

    }
    
    /**
     * Permite agregar un nuevo hechizo.
     */
    public void agregarHechizo() {

        System.out.println("Nombre del hechizo:");
        String nombre = scanner.nextLine();

        System.out.println("Tipo (Fuego/Tierra/Planta/Agua):");
        String tipo = scanner.nextLine();

        System.out.println("Daño:");
        int dano = scanner.nextInt();

        Hechizo nuevo = null;

        if(tipo.equalsIgnoreCase("Fuego")) {

            System.out.println("Duracion Quemadura:");
            int quemadura = scanner.nextInt();

            nuevo = new HechizoFuego(
                    nombre,
                    dano,
                    quemadura
            );
        }

        else if(tipo.equalsIgnoreCase("Tierra")) {

            System.out.println("Mejora Defensa:");
            int defensa = scanner.nextInt();

            nuevo = new HechizoTierra(
                    nombre,
                    dano,
                    defensa
            );
        }

        else if(tipo.equalsIgnoreCase("Planta")) {

            System.out.println("Duracion Stun:");
            int stun = scanner.nextInt();

            System.out.println("Cantidad Plantas:");
            int plantas = scanner.nextInt();

            nuevo = new HechizoPlanta(
                    nombre,
                    dano,
                    stun,
                    plantas
            );
        }

        else if(tipo.equalsIgnoreCase("Agua")) {

            System.out.println("Cantidad Heal:");
            int heal = scanner.nextInt();

            System.out.println("Presion Agua:");
            int presion = scanner.nextInt();

            nuevo = new HechizoAgua(
                    nombre,
                    dano,
                    heal,
                    presion
            );
        }

        if(nuevo != null){

            hechizos.add(nuevo);

            guardarHechizos();

            System.out.println("Hechizo agregado correctamente.");

        }

    }
    
    /**
     * Permite modificar un hechizo existente.
     */
    public void modificarHechizo() {

        mostrarHechizos();

        System.out.println("Ingrese nombre del hechizo:");

        String nombre = scanner.nextLine();

        Hechizo h = buscarHechizo(nombre);

        if(h == null){

            System.out.println("No existe.");

            return;

        }

        System.out.println("Nuevo nombre:");

        String nuevoNombre = scanner.nextLine();

        System.out.println("Nuevo daño:");

        int nuevoDano = scanner.nextInt();
        scanner.nextLine();

        h.setNombre(nuevoNombre);
        h.setDano(nuevoDano);

        guardarHechizos();

        System.out.println("Hechizo modificado.");

    }
    
    /**
     * Elimina un hechizo del sistema.
     */
    public void eliminarHechizo() {

        mostrarHechizos();

        System.out.println("Nombre del hechizo:");

        String nombre = scanner.nextLine();

        Hechizo h = buscarHechizo(nombre);

        if(h == null){

            System.out.println("No existe.");

            return;

        }

        hechizos.remove(h);

        for(Mago m : magos){

            m.getHechizos().remove(h);

        }

        guardarHechizos();
        guardarMagos();

        System.out.println("Hechizo eliminado.");

    }
    
    /**
     * Busca un hechizo por nombre.
     */
    public Hechizo buscarHechizo(String nombre){

        for(Hechizo h : hechizos){

            if(h.getNombre().equalsIgnoreCase(nombre)){

                return h;

            }

        }

        return null;

    }
    
    /**
     * Muestra todos los hechizos.
     */
    public void mostrarHechizos(){

        for(Hechizo h : hechizos){

            System.out.println(
                    h.getNombre()
                    + " | "
                    + h.getTipo()
            );

        }

    }
    
    /**
     * Muestra los hechizos junto a su puntuacion.
     */
    public void mostrarHechizosConPuntaje(){

        for(Hechizo h : hechizos){

            System.out.println(
                    h.getNombre()
                    + " -> "
                    + h.calcularPuntaje()
            );

        }

    }
    
    /**
     * Permite agregar un nuevo mago.
     */
    public void agregarMago() {

        System.out.println("Nombre del mago:");

        String nombre = scanner.nextLine();

        if(buscarMago(nombre) != null){

            System.out.println("El mago ya existe.");
            return;

        }

        Mago nuevo = new Mago(nombre);

        boolean seguir = true;

        while(seguir){

            mostrarHechizos();

            System.out.println("Nombre del hechizo a agregar:");

            String nombreHechizo = scanner.nextLine();

            Hechizo hechizo = buscarHechizo(nombreHechizo);

            if(hechizo != null){

                nuevo.agregarHechizo(hechizo);

            }else{

                System.out.println("Hechizo no encontrado.");

            }

            System.out.println("Agregar otro? (s/n)");

            String respuesta = scanner.nextLine();

            if(respuesta.equalsIgnoreCase("n")){

                seguir = false;

            }

        }

        magos.add(nuevo);

        guardarMagos();

        System.out.println("Mago agregado.");

    }
    
    /**
     * Permite modificar los hechizos de un mago.
     */
    public void modificarMago() {

        mostrarMagos();

        System.out.println("Nombre del mago:");

        String nombre = scanner.nextLine();

        Mago mago = buscarMago(nombre);

        if(mago == null){

            System.out.println("Mago no encontrado.");
            return;

        }

        System.out.println("1. Agregar hechizo");
        System.out.println("2. Eliminar hechizo");

        int opcion = scanner.nextInt();
        scanner.nextLine();

        if(opcion == 1){

            mostrarHechizos();

            System.out.println("Nombre del hechizo:");

            String nombreHechizo = scanner.nextLine();

            Hechizo hechizo = buscarHechizo(nombreHechizo);

            if(hechizo != null){

                mago.agregarHechizo(hechizo);

                System.out.println("Hechizo agregado.");

            }

        }

        else if(opcion == 2){

            for(Hechizo h : mago.getHechizos()){

                System.out.println(h.getNombre());

            }

            System.out.println("Nombre del hechizo:");

            String nombreHechizo = scanner.nextLine();

            Hechizo eliminar = null;

            for(Hechizo h : mago.getHechizos()){

                if(h.getNombre().equalsIgnoreCase(nombreHechizo)){

                    eliminar = h;

                    break;

                }

            }

            if(eliminar != null){

                mago.eliminarHechizo(eliminar);

                System.out.println("Hechizo eliminado.");

            }

        }

        guardarMagos();

    }
    
    /**
     * Elimina un mago.
     */
    public void eliminarMago() {

        mostrarMagos();

        System.out.println("Nombre del mago:");

        String nombre = scanner.nextLine();

        Mago mago = buscarMago(nombre);

        if(mago == null){

            System.out.println("No existe.");

            return;

        }

        magos.remove(mago);

        guardarMagos();

        System.out.println("Mago eliminado.");

    }
    
    /**
     * Busca un mago por nombre.
     */
    public Mago buscarMago(String nombre){

        for(Mago m : magos){

            if(m.getNombre().equalsIgnoreCase(nombre)){

                return m;

            }

        }

        return null;

    }
    
    /**
     * Muestra todos los magos.
     */
    public void mostrarMagos(){

        for(Mago m : magos){

            System.out.println(m.getNombre());

        }

    }
    
    /**
     * Muestra todos los magos junto a su puntuacion.
     */
    public void mostrarMagosConPuntaje(){

        for(Mago m : magos){

            System.out.println(
                    m.getNombre()
                    + " -> "
                    + m.calcularPuntaje()
            );

        }

    }
    
    /**
     * Muestra los 10 mejores hechizos.
     */
    public void top10Hechizos(){

        ArrayList<Hechizo> copia =
                new ArrayList<>(hechizos);

        for(int i=0;i<copia.size()-1;i++){

            for(int j=i+1;j<copia.size();j++){

                if(copia.get(j).calcularPuntaje()
                        >
                   copia.get(i).calcularPuntaje()){

                    Hechizo aux = copia.get(i);

                    copia.set(i,copia.get(j));

                    copia.set(j,aux);

                }

            }

        }

        int limite = Math.min(10,copia.size());

        for(int i=0;i<limite;i++){

            System.out.println(
                    (i+1)
                    + ". "
                    + copia.get(i).getNombre()
                    + " -> "
                    + copia.get(i).calcularPuntaje()
            );

        }

    }
    
    /**
     * Muestra los 3 mejores magos.
     */
    public void top3Magos(){

        ArrayList<Mago> copia =
                new ArrayList<>(magos);

        for(int i=0;i<copia.size()-1;i++){

            for(int j=i+1;j<copia.size();j++){

                if(copia.get(j).calcularPuntaje()
                        >
                   copia.get(i).calcularPuntaje()){

                    Mago aux = copia.get(i);

                    copia.set(i,copia.get(j));

                    copia.set(j,aux);

                }

            }

        }

        int limite = Math.min(3,copia.size());

        for(int i=0;i<limite;i++){

            System.out.println(
                    (i+1)
                    + ". "
                    + copia.get(i).getNombre()
                    + " -> "
                    + copia.get(i).calcularPuntaje()
            );

        }

    }
    
    /**
     * Carga todos los hechizos desde Hechizos.txt
     */
    public void cargarHechizos() {

        try {

            BufferedReader br =
                    new BufferedReader(
                            new FileReader("Hechizos.txt"));

            String linea;

            while((linea = br.readLine()) != null) {

                String[] datos = linea.split(";");

                String nombre = datos[0];
                String tipo = datos[1];
                int dano = Integer.parseInt(datos[2]);

                if(tipo.equalsIgnoreCase("Fuego")) {

                    int duracionQuemadura =
                            Integer.parseInt(datos[3]);

                    hechizos.add(
                            new HechizoFuego(
                                    nombre,
                                    dano,
                                    duracionQuemadura
                            )
                    );

                }

                else if(tipo.equalsIgnoreCase("Tierra")) {

                    int mejoraDefensa =
                            Integer.parseInt(datos[3]);

                    hechizos.add(
                            new HechizoTierra(
                                    nombre,
                                    dano,
                                    mejoraDefensa
                            )
                    );

                }

                else if(tipo.equalsIgnoreCase("Planta")) {

                    String[] extra =
                            datos[3].split(",");

                    int stun =
                            Integer.parseInt(extra[0]);

                    int plantas =
                            Integer.parseInt(extra[1]);

                    hechizos.add(
                            new HechizoPlanta(
                                    nombre,
                                    dano,
                                    stun,
                                    plantas
                            )
                    );

                }

                else if(tipo.equalsIgnoreCase("Agua")) {

                    String[] extra =
                            datos[3].split(",");

                    int heal =
                            Integer.parseInt(extra[0]);

                    int presion =
                            Integer.parseInt(extra[1]);

                    hechizos.add(
                            new HechizoAgua(
                                    nombre,
                                    dano,
                                    heal,
                                    presion
                            )
                    );

                }

            }

            br.close();

        }
        catch(Exception e){

            System.out.println("Error cargando hechizos.");

        }

    }
    
    /**
     * Guarda todos los hechizos.
     */
    public void guardarHechizos() {

        try {

            BufferedWriter bw =
                    new BufferedWriter(
                            new FileWriter("Hechizos.txt"));

            for(Hechizo h : hechizos){

                if(h instanceof HechizoFuego){

                    HechizoFuego f =
                            (HechizoFuego) h;

                    bw.write(
                            f.getNombre()
                            + ";Fuego;"
                            + f.getDano()
                            + ";"
                            + f.getDuracionQuemadura()
                    );

                }

                else if(h instanceof HechizoTierra){

                    HechizoTierra t =
                            (HechizoTierra) h;

                    bw.write(
                            t.getNombre()
                            + ";Tierra;"
                            + t.getDano()
                            + ";"
                            + t.getMejoraDefensa()
                    );

                }

                else if(h instanceof HechizoPlanta){

                    HechizoPlanta p =
                            (HechizoPlanta) h;

                    bw.write(
                            p.getNombre()
                            + ";Planta;"
                            + p.getDano()
                            + ";"
                            + p.getDuracionStun()
                            + ","
                            + p.getCantidadPlantas()
                    );

                }

                else if(h instanceof HechizoAgua){

                    HechizoAgua a =
                            (HechizoAgua) h;

                    bw.write(
                            a.getNombre()
                            + ";Agua;"
                            + a.getDano()
                            + ";"
                            + a.getCantidadHeal()
                            + ","
                            + a.getPresionAgua()
                    );

                }

                bw.newLine();

            }

            bw.close();

        }
        catch(Exception e){

            System.out.println("Error guardando hechizos.");

        }

    }
    
    /**
     * Carga los magos desde Magos.txt
     */
    public void cargarMagos() {

        try {

            BufferedReader br =
                    new BufferedReader(
                            new FileReader("Magos.txt"));

            String linea;

            while((linea = br.readLine()) != null){

                String[] datos =
                        linea.split(";");

                String nombreMago =
                        datos[0];

                Mago mago =
                        new Mago(nombreMago);

                if(datos.length > 1){

                    String[] nombresHechizos =
                            datos[1].split("\\|");

                    for(String nombreHechizo :
                            nombresHechizos){

                        Hechizo h =
                                buscarHechizo(
                                        nombreHechizo);

                        if(h != null){

                            mago.agregarHechizo(h);

                        }

                    }

                }

                magos.add(mago);

            }

            br.close();

        }
        catch(Exception e){

            System.out.println("Error cargando magos.");

        }

    }
    
    /**
     * Guarda todos los magos.
     */
    public void guardarMagos() {

        try {

            BufferedWriter bw =
                    new BufferedWriter(
                            new FileWriter("Magos.txt"));

            for(Mago m : magos){

                bw.write(m.getNombre() + ";");

                for(int i=0;
                    i<m.getHechizos().size();
                    i++){

                    bw.write(
                            m.getHechizos()
                             .get(i)
                             .getNombre()
                    );

                    if(i <
                       m.getHechizos().size()-1){

                        bw.write("|");

                    }

                }

                bw.newLine();

            }

            bw.close();

        }
        catch(Exception e){

            System.out.println("Error guardando magos.");

        }

    }
    
}