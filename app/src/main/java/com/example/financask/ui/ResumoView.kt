package com.example.financask.ui

import android.view.View
import com.example.financask.extension.formataParaBrasileiro
import com.example.financask.model.Resumo
import com.example.financask.model.Transacao
import kotlinx.android.synthetic.main.resumo_card.view.*

class ResumoView(private val view: View,
                 transacoes: List<Transacao>) {

    private val resumo: Resumo = Resumo(transacoes)

    /**
     * Função para adiconar os valores da receita
     * Cálculo referente a esta função está  na
     * classe Resumo.kt
     */
    fun adicionaReceita() {
        val totalReceita = resumo.receita()
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
        view.resumo_card_despesa.text = totalDespesa
                .formataParaBrasileiro()
    }
    //Função para adicionar valores ao total
    fun adicionaTotal() {
        val total = resumo.total()
        view.resumo_card_total.text = total
                .formataParaBrasileiro()
    }
}