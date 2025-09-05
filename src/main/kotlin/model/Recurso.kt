package org.example.model

abstract class Recurso {
    var titulo: String = "";
    var autor: String = "";
    var precioBase: Int = 0;
    var categoria: String = "";
    var anioPublicacion: String = "";

    abstract fun mostrarInfo();
}