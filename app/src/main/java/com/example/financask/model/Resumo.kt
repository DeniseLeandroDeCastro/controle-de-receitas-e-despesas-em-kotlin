package com.example.financask.model

import java.math.BigDecimal

class Resumo(private val transacoes: List<Transacao>) {

    /**
     * Utilizando single-expression function e depois
     * convertendo para property
     */
    val receita get() = somaPorTipo(Tipo.RECEITA)

    val despesa get() = somaPorTipo(Tipo.DESPESA)

    val total get() = receita.subtract(despesa)

    //Função para fazer a soma por tipo da receita ou da despesa
    private fun somaPorTipo(tipo: Tipo): BigDecimal {
        val somaDeTransacoesPeloTipo = transacoes
                .filter { it.tipo == tipo }
                .sumByDouble { it.valor.toDouble()}
        return BigDecimal(somaDeTransacoesPeloTipo)
    }
}

