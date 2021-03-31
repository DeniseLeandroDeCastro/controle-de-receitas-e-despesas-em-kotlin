package com.example.financask.extension


/**
 * Formata o tamanho das strings, ex.:
 * a frase: Almoço de final de semana, será
 * exibida desta forma:
 * Almoço de fina...
 */
fun String.limitaEmAte(caracteres: Int) : String {
    if (this.length > caracteres) {
        return "${this.substring(0, caracteres)}..."
    }
    return this
}
