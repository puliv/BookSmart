package org.example.model

class Revista: Recurso() {
    init {
        categoria = "Revista"
    }
    var frecuencia: String = ""; //Semanal o mensual

    override fun mostrarInfo(){
        print("titulo: $titulo, /n autor: $autor, /n precio base: $precioBase, /n categoria: $categoria, /n año publicacion: $anioPublicacion, frecuencia: $frecuencia")
    }
}