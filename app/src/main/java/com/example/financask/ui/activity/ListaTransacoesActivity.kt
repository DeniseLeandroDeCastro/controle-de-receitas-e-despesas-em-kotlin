package com.example.financask.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.financask.R
import com.example.financask.model.Tipo
import com.example.financask.model.Transacao
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
        val transacoes = listOf(Transacao(valor = BigDecimal(20.50),
                                          tipo = Tipo.DESPESA,
                                          data = Calendar.getInstance()),
                                 Transacao(valor = BigDecimal(100.00),
                                           categoria = "Economia",
                                           tipo = Tipo.RECEITA,
                                           data = Calendar.getInstance()))

        lista_transacoes_listview.setAdapter(
                ListaTransacoesAdapter(transacoes, this))
    }
}