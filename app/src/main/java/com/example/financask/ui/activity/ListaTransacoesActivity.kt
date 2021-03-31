package com.example.financask.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.financask.R
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

        //Criando a lista de receitas e despesas
        val transacoes = listOf(Transacao(BigDecimal(20.50),
                                          "Comida", Calendar.getInstance()),
                                 Transacao(BigDecimal(100.00),
                                          "Economia", Calendar.getInstance()))

        lista_transacoes_listview.setAdapter(
                ListaTransacoesAdapter(transacoes, this))
    }
}