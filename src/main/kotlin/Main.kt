package org.example

import kotlinx.coroutines.runBlocking
import org.example.model.Recurso
import org.example.service.GestorBiblioteca

// Runblocking es lo que permite que la funcion se ejecute como una corutina
fun main(): Unit = runBlocking {
    val listaRecursos = mutableListOf<Recurso>() //catalogo de libros y revistas
    val listaSeleccion = mutableListOf<Int>() //seleccion de recursos por el usuario

    val gestorBiblioteca = GestorBiblioteca()

    gestorBiblioteca.cargarCatalogo(listaRecursos)
    gestorBiblioteca.mostrarCatalogo(listaRecursos)
    gestorBiblioteca.seleccionRecursos(listaSeleccion)

    val tipoUsuario = gestorBiblioteca.obtenerTipoUsuario()

    val subTotalPrestamo = gestorBiblioteca.obtenerSubTotalPrestamo(listaSeleccion, listaRecursos)
    val descuento = gestorBiblioteca.obtenerDescuento(tipoUsuario, subTotalPrestamo)
    val multa = gestorBiblioteca.fechaLimiteYMulta()

    gestorBiblioteca.generarVoucherPrestamo(tipoUsuario, subTotalPrestamo, descuento, multa, listaSeleccion, listaRecursos)
}


