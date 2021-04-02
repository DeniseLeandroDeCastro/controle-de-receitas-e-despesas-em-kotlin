package com.example.financask.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.core.content.ContextCompat
import com.example.financask.R
import com.example.financask.extension.formataParaBrasileiro
import com.example.financask.extension.limitaEmAte
import com.example.financask.model.Tipo
import com.example.financask.model.Transacao
import kotlinx.android.synthetic.main.transacao_item.view.*


class ListaTransacoesAdapter(private val transacoes: List<Transacao>,
                             private val context: Context):BaseAdapter() {

    private val limiteDaCategoria = 14

    //Função que vai criar a view
    override fun getView(posicao: Int, view: View?, parent: ViewGroup?): View {
        val viewCriada = LayoutInflater.from(context)
                .inflate(R.layout.transacao_item, parent, false)

        val transacao = transacoes[posicao]

        //Configurando as cores de acordo com o tipo de transação
        adicionaValor(transacao, viewCriada)
        //Configurando o ícone de acordo com o tipo de transação
        adicionaIcone(transacao, viewCriada)
        //Configurando a categoria de acordo com o tipo
        adicionaCategoria(viewCriada, transacao)
        adicionaData(viewCriada, transacao)
        return viewCriada
    }

    private fun adicionaData(viewCriada: View, transacao: Transacao) {
        viewCriada.transacao_data.text = transacao.data
                .formataParaBrasileiro()
    }

    private fun adicionaCategoria(viewCriada: View, transacao: Transacao) {
        viewCriada.transacao_categoria.text = transacao.categoria
                .limitaEmAte(limiteDaCategoria)
    }

    private fun adicionaIcone(transacao: Transacao, viewCriada: View) {
        val icone = iconePorTipo(transacao.tipo)
        viewCriada.transacao_icone
                .setBackgroundResource(icone)
    }

    private fun iconePorTipo(tipo: Tipo): Int {
        if (tipo == Tipo.RECEITA) {
            return R.drawable.icone_transacao_item_receita
        }
            return R.drawable.icone_transacao_item_despesa
    }
    private fun adicionaValor(transacao: Transacao, viewCriada: View) {
        val cor : Int = corPorTipo(transacao.tipo)
        viewCriada.transacao_valor
                .setTextColor(cor)
        viewCriada.transacao_valor.text = transacao.valor
                .formataParaBrasileiro()
    }
    //Utilizando o if expression
    private fun corPorTipo(tipo: Tipo): Int {
        if (tipo == Tipo.RECEITA) {
            return ContextCompat.getColor(context, R.color.receita)
        }
            return ContextCompat.getColor(context, R.color.despesa)
    }

    //Função que mostra a quantidade de itens
    override fun getCount(): Int {
        return transacoes.size
    }

    //Função que devolve o item
    override fun getItem(posicao: Int): Transacao {
        return transacoes[posicao]
    }

    //Função que devolve o Id
    override fun getItemId(position: Int): Long {
        return 0
    }
}