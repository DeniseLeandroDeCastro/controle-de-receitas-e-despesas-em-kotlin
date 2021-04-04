package com.example.financask.ui.activity

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.financask.R
import com.example.financask.delegate.TransacaoDelegate
import com.example.financask.extension.formataParaBrasileiro
import com.example.financask.model.Tipo
import com.example.financask.model.Transacao
import com.example.financask.ui.ResumoView
import com.example.financask.ui.adapter.ListaTransacoesAdapter
import com.example.financask.ui.dialog.AdicionaTransacaoDialog
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import kotlinx.android.synthetic.main.form_transacao.view.*
import java.lang.NumberFormatException
import java.math.BigDecimal
import java.text.SimpleDateFormat
import java.util.*

class ListaTransacoesActivity : AppCompatActivity() {

    private val transacoes: MutableList<Transacao> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)

        configuraResumo()

        configuraLista()
        //Configurar o click do fab para adicionar uma receita
        lista_transacoes_adiciona_receita
                .setOnClickListener {
                    AdicionaTransacaoDialog(window.decorView as ViewGroup, this)
                            .configuraDialog(Tipo.RECEITA, object : TransacaoDelegate {
                                override fun delegate(transacao: Transacao) {
                                    atualizaTransacoes(transacao)
                                    lista_transacoes_adiciona_menu.close(true)
                                }

                            })
                }
        lista_transacoes_adiciona_despesa
                .setOnClickListener {
                    AdicionaTransacaoDialog(window.decorView as ViewGroup, this)
                            .configuraDialog(Tipo.DESPESA, object : TransacaoDelegate {
                                override fun delegate(transacao: Transacao) {
                                    atualizaTransacoes(transacao)
                                    lista_transacoes_adiciona_menu.close(true)
                                }

                            })
                }
    }
    private fun atualizaTransacoes(transacao: Transacao) {
        transacoes.add(transacao)
        configuraLista()
        configuraResumo()
    }

    private fun configuraResumo() {
        val view: View = window.decorView
        val resumoView = ResumoView(this, view, transacoes)
        resumoView.atualiza()
    }

    private fun configuraLista() {
        lista_transacoes_listview.adapter = ListaTransacoesAdapter(transacoes, this)
    }
}