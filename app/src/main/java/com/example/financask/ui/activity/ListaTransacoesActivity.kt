package com.example.financask.ui.activity

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.financask.R
import com.example.financask.extension.formataParaBrasileiro
import com.example.financask.model.Tipo
import com.example.financask.model.Transacao
import com.example.financask.ui.ResumoView
import com.example.financask.ui.adapter.ListaTransacoesAdapter
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import kotlinx.android.synthetic.main.form_transacao.view.*
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
        //Configurar o click do fab para adicionar uma receita
        lista_transacoes_adiciona_receita
                .setOnClickListener {
                    val view : View = window.decorView
                    //Criar o layout do AlertDialog
                    val viewCriada = LayoutInflater.from(this)
                            .inflate(R.layout.form_transacao,
                                    view as ViewGroup,
                                    false)

                    val ano = 2021
                    val mes = 3
                    val dia = 4


                    val hoje = Calendar.getInstance()
                    viewCriada.form_transacao_data
                            .setText(hoje.formataParaBrasileiro())
                    viewCriada.form_transacao_data
                            .setOnClickListener {
                                DatePickerDialog(this,
                                        { view, ano, mes, dia ->
                                            val dataSelecionada = Calendar.getInstance()
                                            dataSelecionada.set(ano, mes, dia)
                                            viewCriada.form_transacao_data
                                                    .setText(dataSelecionada
                                                            .formataParaBrasileiro())
                                        }

                                        , ano, mes, dia)
                                        .show()
                            }

                    val adapter = ArrayAdapter
                            .createFromResource(this,
                                    R.array.categorias_de_receita,
                                    android.R.layout.simple_spinner_dropdown_item)

                    viewCriada.form_transacao_categoria.adapter = adapter

                    AlertDialog.Builder(this)
                            .setTitle(R.string.adiciona_receita) //Adiciona o título
                            .setView(viewCriada)
                            .setPositiveButton("Adicionar", null)
                            .setNegativeButton("Cancelar", null)
                            .show()
                }
    }

    private fun configuraResumo(transacoes: List<Transacao>) {
        val view: View = window.decorView
        val resumoView = ResumoView(this, view, transacoes)
        resumoView.atualiza()
    }

    private fun configuraLista(transacoes: List<Transacao>) {
        lista_transacoes_listview.adapter = ListaTransacoesAdapter(transacoes, this)
    }

    private fun transacoesDeExemplo() = listOf(Transacao(valor = BigDecimal(100.00),
            tipo = Tipo.DESPESA,
            categoria = "Almoço de final de semana",
            data = Calendar.getInstance()),

            Transacao(valor = BigDecimal(100.00),
                    categoria = "Economia",
                    tipo = Tipo.RECEITA,
                    data = Calendar.getInstance()),

            Transacao(valor = BigDecimal(200.00),
                    tipo = Tipo.DESPESA),
            Transacao(valor = BigDecimal(200.00),
                    categoria = "Prêmio",
                    tipo = Tipo.RECEITA))
}