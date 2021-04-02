package com.example.financask.model

import android.view.View
import java.math.BigDecimal

class Resumo(private val transacoes: List<Transacao>) {

    fun receita() : BigDecimal {
        var totalReceita = BigDecimal.ZERO
        for (transacao in transacoes) {
            if (transacao.tipo == Tipo.RECEITA) {
                totalReceita = totalReceita.plus(transacao.valor) //soma o total da receita com o valor da transação
            }
        }
        return totalReceita
    }

    fun despesa() : BigDecimal {
        var totalDespesa = BigDecimal.ZERO
        for (transacao in transacoes) {
            if (transacao.tipo == Tipo.DESPESA) {
                totalDespesa = totalDespesa.plus(transacao.valor) //soma o total da despesa com o valor da transação
            }
        }
        return totalDespesa
    }
    fun total() : BigDecimal {
        return receita().subtract(despesa())
    }
}