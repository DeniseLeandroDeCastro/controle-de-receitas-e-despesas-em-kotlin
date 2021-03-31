package com.example.financask.extension

import java.math.BigDecimal
import java.text.DecimalFormat
import java.util.Locale

//Para formatar a moeda com padrão do Brasil - currencyInstance
fun BigDecimal.formataParaBrasileiro() : String {
    val formatoBrasieiro = DecimalFormat
            .getCurrencyInstance(Locale("pt", "br"))
    return formatoBrasieiro
            .format(this)
            .replace("R$", "R$")
            .replace("-R$", "R$ -")
}