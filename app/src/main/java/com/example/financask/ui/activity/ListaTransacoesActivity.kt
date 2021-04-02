package com.example.financask.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.financask.R
import com.example.financask.extension.formataParaBrasileiro
import com.example.financask.model.Tipo
import com.example.financask.model.Transacao
import com.example.financask.ui.adapter.ListaTransacoesAdapter
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import kotlinx.android.synthetic.main.resumo_card.*
import java.math.BigDecimal
import java.util.*

class ListaTransacoesActivity : AppCompatActivity() {

    /**
     * Em Kotlin, em vez de métodos, utilizamos funções
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)

        /**
         * Utilizando o construtor sobrecarregado, não importa
         * em que ordem estão os atributos
         */
        val transacoes: List<Transacao> = transacoesDeExemplo()

        adicionaReceitaNoResumo(transacoes)

        configuraLista(transacoes)
    }

    private fun adicionaReceitaNoResumo(transacoes: List<Transacao>) {
        var totalReceita = BigDecimal.ZERO
        for (transacao in transacoes) {
            if (transacao.tipo == Tipo.RECEITA) {
                totalReceita = totalReceita.plus(transacao.valor) //soma o total da receita com o valor da transação
            }
        }
        resumo_card_receita.text = totalReceita.formataParaBrasileiro()
    }

    private fun configuraLista(transacoes: List<Transacao>) {
        lista_transacoes_listview.adapter = ListaTransacoesAdapter(transacoes, this)
    }

    private fun transacoesDeExemplo() = listOf(Transacao(valor = BigDecimal(20.50),
            tipo = Tipo.DESPESA,
            categoria = "Almoço de final de semana",
            data = Calendar.getInstance()),

            Transacao(valor = BigDecimal(100.00),
                    categoria = "Economia",
                    tipo = Tipo.RECEITA,
                    data = Calendar.getInstance()),

            Transacao(valor = BigDecimal(200.00),
                    tipo = Tipo.DESPESA),
            Transacao(valor = BigDecimal(500.00),
                    categoria = "Prêmio",
                    tipo = Tipo.RECEITA))
}