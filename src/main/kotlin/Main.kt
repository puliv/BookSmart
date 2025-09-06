package org.example
import org.example.model.Recurso
import org.example.service.GestorBiblioteca

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val listaRecursos = mutableListOf<Recurso>() //catalogo de libros y revistas
    val listaSeleccion = mutableListOf<Int>() //seleccion de recursos por el usuario

    val gestorBiblioteca = GestorBiblioteca()

    gestorBiblioteca.cargarCatalogo(listaRecursos)
    gestorBiblioteca.mostrarCatalogo(listaRecursos)
    gestorBiblioteca.procesarPrestamo(listaSeleccion)

    val tipoUsuario = gestorBiblioteca.obtenerTipoUsuario()
    val totalPrestamo = gestorBiblioteca.obtenerSubTotalPrestamo(listaSeleccion, listaRecursos)
    val descuento = gestorBiblioteca.aplicarDescuentos(tipoUsuario)


}


