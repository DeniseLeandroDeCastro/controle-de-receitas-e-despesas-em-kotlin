package com.example.financask.extension

import java.text.SimpleDateFormat
import java.util.*


/**
 * Formata o tamanho das strings, ex.:
 * a frase: Almoço de final de semana, será
 * exibida desta forma:
 * Almoço de fina...
 */
fun String.limitaEmAte(caracteres: Int) : String {
    if (this.length > caracteres) {
        val primeiroCaracter = 0
        return "${this.substring(primeiroCaracter, caracteres)}..."
    }
    return this
}

fun String.converteParaCalendar() : Calendar {
    val formatoBrasileiro = SimpleDateFormat("dd/MM/yyyy")
    val dataConvertida: Date = formatoBrasileiro.parse(this)
    val data = Calendar.getInstance()
    data.time = dataConvertida
    return data
}
