package org.example.util

sealed class EstadoPedido {
    data class Exito(val mensaje: String) : EstadoPedido()
    data class Error(val mensaje: String) : EstadoPedido()
}