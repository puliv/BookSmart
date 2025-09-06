package org.example.service
import org.example.model.Libro
import org.example.model.Recurso
import org.example.model.Revista

class GestorBiblioteca {
    //Objetivo 1: Gestionar un catálogo de recursos (libros y revistas)
    fun cargarCatalogo(listaRecursos: MutableList<Recurso>) {
        val recurso1 = Libro();
        recurso1.titulo = "El Principito";
        recurso1.autor = "Antoine...";
        recurso1.precioBase = 4990;
        recurso1.categoria = "Literatura Infantil";
        recurso1.anioPublicacion = 1943;
        recurso1.estadoLibro = false;

        val recurso2 = Libro();
        recurso2.titulo = "Cien Anios de Soledad";
        recurso2.autor = "Gabriel Garcia Marquez";
        recurso2.precioBase = 9990;
        recurso2.categoria = "Novela";
        recurso2.anioPublicacion = 1967;
        recurso2.estadoLibro = true;

        val recurso3 = Revista();
        recurso3.titulo = "National Geographic";
        recurso3.autor = "Editorial NG"
        recurso3.precioBase = 2490;
        recurso3.frecuencia = "Mensual";
        recurso3.anioPublicacion = 2025;

        val recurso4 = Revista();
        recurso4.titulo = "Muy Interesante";
        recurso4.autor = "Editorial MY"
        recurso4.precioBase = 1490;
        recurso4.frecuencia = "Semanal";
        recurso4.anioPublicacion = 2025;

        listaRecursos.add(recurso1);
        listaRecursos.add(recurso2);
        listaRecursos.add(recurso3);
        listaRecursos.add(recurso4);
    }

    //Mostrar catalogo
    fun mostrarCatalogo(listaRecursos: MutableList<Recurso>) {
        println("-------------------------------------")
        println("---------Catalogo de Recursos--------")
        println("-------------------------------------")
        listaRecursos.withIndex().forEach { (idx, recurso) ->
            val index = idx + 1
            println("--------Recurso $index--------")
            recurso.mostrarInfo()
        }
    }

    //Objetivo 2: Procesar préstamos con fechas límite y posibles multas.
    fun procesarPrestamo(listaSeleccion: MutableList<Int>) {
        println("---------Selecciona recursos---------")
        val seleccionRecurso = readln()
        val arregloSeleccion = seleccionRecurso.split(",")

        arregloSeleccion.forEach { s -> listaSeleccion.add(s.toInt()) }
    }

    //Objetivo 3: Aplicar beneficios y descuentos según el tipo de usuario.
    fun obtenerTipoUsuario(): Int? {
        println("---------Selecciona tipo de usuario---------")
        println("1.- INVITADO")
        println("2.- ESTUDIANTE")
        println("3.- VIP")

        var tipoUsuario: Int? = null

        while (tipoUsuario !in 1..3) {
            tipoUsuario = readln().toIntOrNull()

            if (tipoUsuario !in 1..3) {
                println("Opcion invalida, intenta de nuevo.")
            }
        }

        println("---------Usuario ingresado con exito---------")
        return tipoUsuario
    }

    fun obtenerSubTotalPrestamo(listaSeleccion: MutableList<Int>, listaRecursos: MutableList<Recurso>): Int {
        var subtotal = 0
        println("---------Total prestamo---------")
        println(listaSeleccion)

        val cantidadSeleccion = listaRecursos.size
        listaRecursos.withIndex().forEach { (index, item) ->
            val idx = index + 1
            listaSeleccion.forEach { i ->
                if (idx == i) {
                    subtotal += item.precioBase
                }
            }
        }
//        println("total $total")
        return subtotal
    }

    fun aplicarDescuentos(tipoUsuario: Int?): Int {
        var descuento : Int = 0
        when (tipoUsuario) {
            1 -> descuento =  0
            2 -> descuento =  10
            3 -> descuento =  15
        }
        return descuento
    }

    //Objetivo 4: Simular el proceso de préstamo y devolución de manera asíncrona.
    //Objetivo 5: Generar reportes de uso y estadísticas mediante operaciones funcionales.

}


//cargo catalogo, lo muestro, usuario selecciona, especifico usuario,
//cargo total seleecion, aplico descuentos y multas