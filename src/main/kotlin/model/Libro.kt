package org.example.model

import kotlin.String

class Libro: Recurso() {
    init {
        categoria = "Libro"
    }
    var estadoLibro: String = "" //nuevo o usado

    override fun mostrarInfo() {
        print("titulo: $titulo, /n autor: $autor, /n precio base: $precioBase, /n categoria: $categoria, /n año publicacion: $anioPublicacion, estado libro: $estadoLibro")
    }
}