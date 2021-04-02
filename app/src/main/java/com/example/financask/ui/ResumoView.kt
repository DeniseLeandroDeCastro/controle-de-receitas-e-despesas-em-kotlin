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

    /**
     * Função para adiconar os valores da receita
     * Cálculo referente a esta função está  na
     * classe Resumo.kt
     */
    fun adicionaReceita() {
        val totalReceita = resumo.receita()
        view.resumo_card_receita
                .setTextColor(ContextCompat.getColor(context, R.color.receita))
        view.resumo_card_receita.text = totalReceita
                .formataParaBrasileiro()
    }
    /**
     * Função para adiconar os valores da despesa
     * Cálculo referente a esta função está  na
     * classe Resumo.kt
     */
    fun adicionaDespesa() {
        val totalDespesa = resumo.despesa()
        view.resumo_card_despesa
                .setTextColor(ContextCompat.getColor(context, R.color.despesa))
        view.resumo_card_despesa.text = totalDespesa
                .formataParaBrasileiro()
    }
    //Função para adicionar valores ao total
    fun adicionaTotal() {
        val total = resumo.total()
        if(total.compareTo(BigDecimal.ZERO) >= 0) {
            view.resumo_card_total
                    .setTextColor(ContextCompat
                            .getColor(context, R.color.receita))
        } else {
            view.resumo_card_total
                    .setTextColor(ContextCompat
                            .getColor(context, R.color.despesa))
        }
        view.resumo_card_total.text = total
                .formataParaBrasileiro()
    }
}