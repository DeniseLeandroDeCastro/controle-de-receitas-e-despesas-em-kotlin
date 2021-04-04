package com.example.financask.ui

import android.content.Context
import android.view.View
import androidx.core.content.ContextCompat
import com.example.financask.R
import com.example.financask.extension.formataParaBrasileiro
import com.example.financask.model.Resumo
import com.example.financask.model.Transacao
import kotlinx.android.synthetic.main.resumo_card.view.*
import java.math.BigDecimal

class ResumoView(private val context: Context,
                 private val view: View,
                 transacoes: List<Transacao>) {

    private val resumo: Resumo = Resumo(transacoes)
    private val corReceita = ContextCompat.getColor(context, R.color.receita)
    private val corDespesa = ContextCompat.getColor(context, R.color.despesa)

    fun atualiza() {
        adicionaReceita()
        adicionaDespesa()
        adicionaTotal()
    }

    /**
     * Função para adiconar os valores da receita
     * Cálculo referente a esta função está  na
     * classe Resumo.kt
     */
    private fun adicionaReceita() {
        val totalReceita = resumo.receita
        with(view.resumo_card_receita) {
            setTextColor(corReceita)
            text = totalReceita.formataParaBrasileiro()
        }
    }

    /**
     * Função para adiconar os valores da despesa
     * Cálculo referente a esta função está  na
     * classe Resumo.kt
     */
    private fun adicionaDespesa() {
        val totalDespesa = resumo.despesa
        with(view.resumo_card_despesa) {
            setTextColor(corDespesa)
            text = totalDespesa.formataParaBrasileiro()
        }
    }

    //Função para adicionar valores ao total
    private fun adicionaTotal() {
        val total = resumo.total
        val cor = corPorTipo(total)
        with(view.resumo_card_total) {
            setTextColor(cor)
            text = total.formataParaBrasileiro()
        }
    }
    private fun corPorTipo(valor: BigDecimal): Int {
        if (valor >= BigDecimal.ZERO) {
            return corReceita
        }
        return corDespesa
    }
}