package com.example.financask.extension

import java.text.SimpleDateFormat
import java.util.*

//Função para formatar a data em padrão brasileiro
fun Calendar.formataParaBrasileiro() : String {
    val formatoBrasileiro = "dd/MM/yyyy"
    val format = SimpleDateFormat(formatoBrasileiro)
    return format.format(this.time)
}