package org.example.model

abstract class Recurso {
    var titulo: String = "";
    var autor: String = "";
    var precioBase: Int = 0;
    var categoria: String = "";
    var anioPublicacion: Int = 0;

    abstract fun mostrarInfo();
}