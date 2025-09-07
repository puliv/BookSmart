# BOOKSMART 📚

## Sistema de Gestión de Biblioteca Digital desarrollado en Kotlin usando IntelliJ IDEA.

********
### CONTEXTO DEL PROBLEMA
La biblioteca comunitaria **BookSmart** necesita un sistema de consola para gestionar el préstamo de libros y revistas. El sistema debe manejar un catálogo variado de recursos, aplicar reglas de préstamo y devoluciones, calcular multas y beneficios para diferentes tipos de usuarios, simular procesos asíncronos y generar reportes.

### OBJETIVO PRINCIPAL

Desarrollar una aplicación de consola en **Kotlin** que permita:

- [X] Gestionar un catálogo de recursos (libros y revistas).

- [x] Procesar préstamos con fechas límite y posibles multas.

- [x] Aplicar beneficios y descuentos según el tipo de usuario.

- [ ] Simular el proceso de préstamo y devolución de manera asíncrona.


### REQUERIMIENTOS ESPECÍFICOS

1.- MODELADO DE CLASES

Cada recurso tiene atributos básicos: título, autor, precio base, categoría, año publicación.

*   **Libro**: puede ser nuevo o usado. Los libros nuevos tienen un recargo sobre el precio de referencia.

*   **Revista**: puede ser semanal o mensual, lo que influye en el precio y en el tiempo de préstamo permitido.


Se requiere **clase base** (Recurso) y **clases derivadas** (Libro, Revista) con **polimorfismo** para calcular costo o condiciones de préstamo.


2.- MANEJO DE ESTADOS ASÍNCRONOS

El préstamo pasa por distintos estados representados en una **sealed class**:

*   Pendiente → Entregado → Error


Se debe **simular el tiempo** de búsqueda/preparación de un recurso (delay de 3 segundos).

3.- LÓGICA DE NEGOCIO Y CÁLCULOS

El sistema debe:

- [ ]   Calcular el **subtotal** del préstamo según los recursos elegidos.

- [ ]   Aplicar **descuentos** por tipo de usuario.

- [ ]   Calcular **multas** por devolución tardía.

- [ ]   Determinar el **total final a pagar**.


Reglas mínimas:

- [ ]   Usuarios con membresía “VIP” tienen más días de préstamo.

- [ ]   Multa de $500 por día de atraso.

- [ ]   Descuentos por tipo de usuario:

    *   Invitado: 0%

    *   Estudiante: 10%

    *   VIP: 15%


4.- MANEJO DE ERRORES

El sistema debe manejar situaciones como:

- [ ]   Precios negativos o datos faltantes.

- [ ]   Intentar devolver un recurso que no fue prestado.


### ESTRUCTURA TÉCNICA REQUERIDA

1.- ARCHIVOS A CREAR

- [X] Main.kt – Punto de entrada.

- [X] Recurso.kt – Clase base y derivadas.

- [ ] EstadoPrestamo.kt – Sealed class de estados.

- [X] GestorBiblioteca.kt – Funciones de negocio.

2.- FLUJO DEL PROGRAMA

- [x] Mostrar catálogo de recursos.

- [x] Seleccionar recursos para préstamo.

- [x] Calcular subtotal, descuentos y multas si corresponde.

- [ ] Procesar préstamo de forma asíncrona.


3.- FUNCIONALIDADES MINIMAS OBLIGATORIAS

- [x] Herencia con clases derivadas
- [x] Polimorfismo mediante sobrescritura
- [ ] Manejo de estados con _sealed class_
- [ ] Simulación asíncrona con corrutinas y `delay`
- [x] Uso de colecciones y operaciones funcionales
- [x] Lógica condicional para descuentos, multas y reglas
- [x] Manejo de errores y validaciones
- [ ] Código modular y documentado

4.- DATOS DE PRUEBA SUGERIDOS

Catálogo inicial:
*   **Libro**: “El Principito”, $4.990, nuevo= `false`

*   **Libro**: “Cien Años de Soledad”, $9.990, nuevo= `true`

*   **Revista**: “National Geographic”, $2.490, mensual

*   **Revista**: “Muy Interesante”, $1.490, semanal


Tipos de usuario:
*   Invitado: 0% descuento

*   Estudiante: 10% descuento

*   VIP: 15% descuento