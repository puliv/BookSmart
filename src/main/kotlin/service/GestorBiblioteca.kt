package org.example.service

import org.example.model.Libro
import org.example.model.Recurso
import org.example.model.Revista
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.time.temporal.ChronoUnit

class GestorBiblioteca {
    //Objetivo 1: Gestionar un catálogo de recursos (libros y revistas)
    fun cargarCatalogo(listaRecursos: MutableList<Recurso>) {
        val recurso1 = Libro()
        recurso1.titulo = "El Principito"
        recurso1.autor = "Antoine..."
        recurso1.precioBase = 4990
        recurso1.categoria = "Literatura Infantil"
        recurso1.anioPublicacion = 1943
        recurso1.estadoLibro = false

        val recurso2 = Libro()
        recurso2.titulo = "Cien Anios de Soledad"
        recurso2.autor = "Gabriel Garcia Marquez"
        recurso2.precioBase = 9990
        recurso2.categoria = "Novela"
        recurso2.anioPublicacion = 1967
        recurso2.estadoLibro = true

        val recurso3 = Revista()
        recurso3.titulo = "National Geographic"
        recurso3.autor = "Editorial NG"
        recurso3.precioBase = 2490
        recurso3.frecuencia = "Mensual"
        recurso3.anioPublicacion = 2025

        val recurso4 = Revista()
        recurso4.titulo = "Muy Interesante"
        recurso4.autor = "Editorial MY"
        recurso4.precioBase = 1490
        recurso4.frecuencia = "Semanal"
        recurso4.anioPublicacion = 2025

        listaRecursos.add(recurso1)
        listaRecursos.add(recurso2)
        listaRecursos.add(recurso3)
        listaRecursos.add(recurso4)
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
    fun seleccionRecursos(listaSeleccion: MutableList<Int>) {
        println("---------Selecciona recursos---------")
        val seleccionRecurso = readln()
        val arregloSeleccion = seleccionRecurso.split(",")

        arregloSeleccion.forEach { s -> listaSeleccion.add(s.toInt()) }
    }

    //Validar formato de fecha
    fun esFechaValida(fecha: String, formato: String = "dd-MM-yyyy"): Boolean {
        return try {
            val formatter = DateTimeFormatter.ofPattern(formato)
            LocalDate.parse(fecha, formatter)
            true
        } catch (e: DateTimeParseException) {
            false
        }
    }

    //Funcion que permite obtener los dias de retraso en la entrega para calcular multa
    fun fechaLimiteYMulta(): Int {
        println("---------Ingresa fecha de devolucion---------")
        val formato = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        var fecha: LocalDate? = null
        val hoy: LocalDate = LocalDate.now()
        var multa = 0

        while (fecha == null) {
            println("formato: (dd-mm-aaaa)")
            val input = readln()

            if (esFechaValida(input)) {
                val fechaIngresada = LocalDate.parse(input, formato)
                fecha = fechaIngresada
                val fechaDespuesDeHoy = fechaIngresada.isAfter(LocalDate.now())
                val fechaEsHoy = fechaIngresada.isEqual(LocalDate.now())

                if (fechaEsHoy || fechaDespuesDeHoy) {
                    println("Lo devolviste a tiempo, no tienes multas")
                } else {
                    //diferencia al ser una fecha se considera de tipo Long
                    val diferencia = ChronoUnit.DAYS.between( fechaIngresada, hoy).toInt()
                    multa = diferencia * 500
                    println("Hubo un retraso de $diferencia dias, lo que significa un recargo de: $multa pesos")
                }
            }
        }
        return multa
    }

    //Objetivo 3: Aplicar beneficios y descuentos según el tipo de usuario.
    fun obtenerTipoUsuario(): Int {
        println("---------Selecciona tipo de usuario---------")
        println("1.- INVITADO")
        println("2.- ESTUDIANTE")
        println("3.- VIP")

        var tipoUsuario = 0

        while (tipoUsuario !in 1..3) {
            tipoUsuario = readln().toInt()

            if (tipoUsuario !in 1..3) {
                println("Opcion invalida, intenta de nuevo.")
            }
        }

        println("---------Usuario ingresado con exito---------")
        return tipoUsuario
    }

    fun obtenerSubTotalPrestamo(listaSeleccion: MutableList<Int>, listaRecursos: MutableList<Recurso>): Int {
        var subtotal = 0

        listaRecursos.withIndex().forEach { (index, item) ->
            val idx = index + 1
            listaSeleccion.forEach { i ->
                if (idx == i) {
                    subtotal += item.precioBase
                }
            }
        }
        return subtotal
    }

    fun obtenerDescuento(tipoUsuario: Int?, subtotal: Int): Int {
        var descuento = 0
        when (tipoUsuario) {
            1 -> descuento = 0
            2 -> descuento = subtotal * 10 / 100
            3 -> descuento = subtotal * 15 / 100
        }
        return descuento
    }

    //Objetivo 4: Simular el proceso de préstamo y devolución de manera asíncrona.
    fun generarVoucherPrestamo(
        tipoUsuario: Int,
        subTotalPrestamo: Int,
        descuento: Int,
        multa: Int,
        listaSeleccion: MutableList<Int>,
        listaRecursos: MutableList<Recurso>
    ) {
        println("---------Generar prestamo---------")
        println("--------Items solicitados:--------")
        listaRecursos.withIndex().forEach { (index, item) ->
            val idx = index + 1
            var count = 0
            for (i in listaSeleccion) {
                count += 1
                if (idx == i) {
                    println("Item $count: ${item.titulo} - $${item.precioBase}")
                }
            }
        }
        println("-----------------------------")
        print("Tipo de Usuario: ")
        when (tipoUsuario) {
            1 -> println("INVITADO")
            2 -> println("ESTUDIANTE (Desc 10%)")
            3 -> println("VIP (Desc 15%)")
        }
        println("-----------Totales:------------")
        println("Subtotal: $$subTotalPrestamo")
        println("Multa por retraso: $$multa")
        println("Descuento por membresia: -$$descuento")
        val total = subTotalPrestamo - descuento + multa
        println("Total: $$total")
        println("-----------------------------")
    }
}


//cargo catalogo, lo muestro, usuario selecciona, especifico usuario,
//cargo total seleccion, aplico descuentos y multas