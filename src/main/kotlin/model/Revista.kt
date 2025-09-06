package org.example.model

class Revista : Recurso() {
    init {
        categoria = "Revista"
    }

    var frecuencia: String = ""; //frecuencia de prestamo semanal o mensual

    override fun mostrarInfo() {
        println("Titulo: $titulo" +
                "\nAutor: $autor" +
                "\nPrecio: $$precioBase" +
                "\nCategoria: $categoria" +
                "\nAnio publicacion: $anioPublicacion" +
                "\nFrecuencia prestamo: $frecuencia")
    }
}