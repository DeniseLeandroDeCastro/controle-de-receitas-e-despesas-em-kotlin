package com.example.financask.extension


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
