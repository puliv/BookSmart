package org.example.model

import kotlin.String

class Libro : Recurso() {
    init {
        categoria = "Libro"
    }
    var estadoLibro: Boolean = false //nuevo o usado

    override fun mostrarInfo() {
    println("Titulo: $titulo" +
            "\nAutor: $autor" +
            "\nPrecio: $$precioBase" +
            "\nCategoria: $categoria" +
            "\nAnio publicacion: $anioPublicacion" +
            "\nNuevo: $estadoLibro")
    }
}