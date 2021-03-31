package com.example.financask.extension

import java.text.SimpleDateFormat
import java.util.*

/**
 * (Esta é uma extension function)
 * Função para formatar a data
 * em formato brasileiro: dd/MM/yyyy
 */
fun Calendar.formataParaBrasileiro() : String {
    val formatoBrasileiro = "dd/MM/yyyy"
    val format = SimpleDateFormat(formatoBrasileiro)
    return format.format(this.time)
}
