# Taller 03 – POO

## Descripción del proyecto

Programa desarrollado en Java que permite administrar y analizar magos y hechizos mediante una aplicación por consola.

El sistema cuenta con dos paneles principales:

* Administrador: permite gestionar magos y hechizos mediante operaciones CRUD.
* Analista: permite generar reportes, rankings y estadísticas basadas en las puntuaciones de magos y hechizos.

El programa utiliza herencia, interfaces, colecciones dinámicas y persistencia de datos mediante archivos de texto.

---

## Integrantes

**Cristóbal Nicolás Chepilla Arriagada**
RUT: 21873055-8
GitHub: FormleSs929

---

## Estructura del proyecto

### Clases principales

### App.java

Clase principal del programa.

Inicializa el sistema y ejecuta el menú principal.

### SistemaMagos.java

Controla toda la lógica de negocio del sistema.

Administra menús, operaciones CRUD, reportes y persistencia de datos.

### Mago.java

Representa a un mago y almacena los hechizos que domina.

Calcula su puntuación total a partir de los hechizos asociados.

### Hechizo.java

Clase abstracta base para todos los tipos de hechizos.

Implementa la interfaz Puntuable.

### HechizoFuego.java

Representa hechizos de tipo Fuego.

Calcula su puntaje mediante:

Puntaje = Daño × Duración Quemadura

### HechizoAgua.java

Representa hechizos de tipo Agua.

Calcula su puntaje mediante:

Puntaje = (Daño + Heal + Presión de Agua) × 2

### HechizoPlanta.java

Representa hechizos de tipo Planta.

Calcula su puntaje mediante:

Puntaje = Daño + (Duración Stun × Cantidad de Plantas)

### HechizoTierra.java

Representa hechizos de tipo Tierra.

Calcula su puntaje mediante:

Puntaje = (Daño × Mejora Defensa) / 2

### Puntuable.java

Interfaz que obliga a implementar el método:

calcularPuntaje()

---

## Archivos utilizados

### Magos.txt

Almacena los magos y los hechizos que dominan.

### Hechizos.txt

Almacena todos los hechizos disponibles y sus atributos.

---

## Instrucciones de ejecución

1. Abrir el proyecto en Eclipse.
2. Verificar que los archivos Magos.txt y Hechizos.txt se encuentren en la raíz del proyecto.
3. Ejecutar la clase App.java.
4. Utilizar la consola para interactuar con el sistema.

---

## Funcionalidades implementadas

### Panel Administrador

* Agregar mago.
* Modificar mago.
* Eliminar mago.
* Agregar hechizo.
* Modificar hechizo.
* Eliminar hechizo.

### Panel Analista

* Top 10 mejores hechizos.
* Top 3 mejores magos.
* Mostrar todos los hechizos.
* Mostrar todos los magos.
* Mostrar todos los hechizos con su puntuación.
* Mostrar todos los magos con su puntuación.

### Otras funcionalidades

* Carga automática de archivos.
* Persistencia de datos.
* Herencia.
* Interfaces.
* Polimorfismo.
* Uso de ArrayList.
* Ordenamiento por puntuación.
* Arquitectura separada entre App y Sistema.
* Programación Orientada a Objetos (POO).
