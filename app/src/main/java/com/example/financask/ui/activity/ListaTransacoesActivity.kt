package com.example.financask.ui.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.financask.R
import com.example.financask.model.Tipo
import com.example.financask.model.Transacao
import com.example.financask.ui.ResumoView
import com.example.financask.ui.adapter.ListaTransacoesAdapter
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
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
        //Pegando um objeto do tipo view
        configuraResumo(transacoes)

        configuraLista(transacoes)
    }

    private fun configuraResumo(transacoes: List<Transacao>) {
        val view: View = window.decorView
        val resumoView = ResumoView(this, view, transacoes)
        resumoView.adicionaReceita()
        resumoView.adicionaDespesa()
        resumoView.adicionaTotal()
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

            Transacao(valor = BigDecimal(700.00),
                    tipo = Tipo.DESPESA),
            Transacao(valor = BigDecimal(500.00),
                    categoria = "Prêmio",
                    tipo = Tipo.RECEITA))
}