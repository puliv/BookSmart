# BOOKSMART

Este es un Sistema de Gestión de Biblioteca Digital desarrollado en Kotlin usando IntelliJ IDEA.


CONTEXTO DEL PROBLEMA

La biblioteca comunitaria **BookSmart** necesita un sistema de consola para gestionar el préstamo de libros y revistas. El sistema debe manejar un catálogo variado de recursos, aplicar reglas de préstamo y devoluciones, calcular multas y beneficios para diferentes tipos de usuarios, simular procesos asíncronos y generar reportes.

OBJETIVO PRINCIPAL

Desarrollar una aplicación de consola en **Kotlin** que permita:

*   Gestionar un catálogo de recursos (libros y revistas).

*   Procesar préstamos con fechas límite y posibles multas.

*   Aplicar beneficios y descuentos según el tipo de usuario.

*   Simular el proceso de préstamo y devolución de manera asíncrona.

*   Generar reportes de uso y estadísticas mediante operaciones funcionales.


REQUERIMIENTOS ESPECÍFICOS

1.- MODELADO DE CLASES

Cada recurso tiene atributos básicos: título, autor, precio base, categoría, año publicación.

*   **Libro**: puede ser nuevo o usado. Los libros nuevos tienen un recargo sobre el precio de referencia.

*   **Revista**: puede ser semanal o mensual, lo que influye en el precio y en el tiempo de préstamo permitido.


Se requiere **clase base** (Recurso) y **clases derivadas** (Libro, Revista) con **polimorfismo** para calcular costo o condiciones de préstamo.


2.- MANEJO DE ESTADOS ASÍNCRONOS

El préstamo pasa por distintos estados representados en una **sealed class**:

*   Pendiente →  Entregado → Error


Se debe **simular el tiempo** de búsqueda/preparación de un recurso (delay de 3 segundos).

3.- LÓGICA DE NEGOCIO Y CÁLCULOS

El sistema debe:

*   Calcular el **subtotal** del préstamo según los recursos elegidos.

*   Aplicar **descuentos** por tipo de usuario.

*   Calcular **multas** por devolución tardía.

*   Determinar el **total final a pagar**.


**Reglas mínimas:**

*   Usuarios con membresía “VIP” tienen más días de préstamo.

*   Multa de $500 por día de atraso.

*   Descuentos:

    *   Regular: 0%

    *   Estudiante: 10%

    *   VIP: 15%


4.- FUNCIONES Y COLECCIONES

Organizar el código en funciones específicas:

*   inicializarCatalogo()

*   calcularMulta(...)

*   aplicarDescuento(...)

*   procesarPrestamoAsync(...)

*   El sistema debe usar **colecciones** (List, Map, etc.) para manejar catálogo y préstamos, aplicando operaciones funcionales.


5) MANEJO DE ERRORES

El sistema debe manejar situaciones como:

*   Precios negativos o datos faltantes.

*   Intentar devolver un recurso que no fue prestado.


ESTRUCTURA TÉCNICA REQUERIDA

**Archivos a crear:**

1.  Main.kt – Punto de entrada.

2.  Recurso.kt – Clase base y derivadas.

3.  EstadoPrestamo.kt – Sealed class de estados.

4.  GestorBiblioteca.kt – Funciones de negocio.


**Flujo del programa:**

1.  Mostrar catálogo de recursos.

2.  Seleccionar recursos para préstamo.

3.  Calcular subtotal, descuentos y multas si corresponde.

4.  Procesar préstamo de forma asíncrona.


DATOS DE PRUEBA SUGERIDOS

**Catálogo inicial:**

*   **Libro**: “El Principito”, $4.990, nuevo=false

*   **Libro**: “Cien Años de Soledad”, $9.990, nuevo=true

*   **Revista**: “National Geographic”, $2.490, mensual

*   **Revista**: “Muy Interesante”, $1.490, semanal


**Tipos de usuario:**

*   Regular: 0% descuento

*   Estudiante: 10% descuento

*   VIP: 15% descuento


FUNCIONALIDADES MÍNIMAS OBLIGATORIAS

*   Herencia con clases derivadas.

*   Polimorfismo mediante sobrescritura.

*   Manejo de estados con sealed class.

*   Simulación asíncrona con corrutinas y delay.

*   Uso de colecciones y operaciones funcionales.

*   Lógica condicional para descuentos, multas y reglas.

*   Manejo de errores y validaciones.

*   Código modular y documentado.