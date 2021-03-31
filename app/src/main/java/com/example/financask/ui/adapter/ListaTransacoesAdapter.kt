package com.example.financask.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.core.content.ContextCompat
import com.example.financask.R
import com.example.financask.extension.formataParaBrasileiro
import com.example.financask.model.Tipo
import com.example.financask.model.Transacao
import kotlinx.android.synthetic.main.transacao_item.view.*


class ListaTransacoesAdapter(transacoes: List<Transacao>,
                             context: Context):BaseAdapter() {

    private val transacoes = transacoes
    private val context = context

    //Função que vai criar a view
    override fun getView(posicao: Int, view: View?, parent: ViewGroup?): View {
        val viewCriada = LayoutInflater.from(context)
                .inflate(R.layout.transacao_item, parent, false)

        val transacao = transacoes[posicao]
        //Configurando as cores de acordo com o tipo de transação
        if(transacao.tipo == Tipo.RECEITA) {
            viewCriada.transacao_valor
                    .setTextColor(ContextCompat.getColor(context, R.color.receita))
        } else {
            viewCriada.transacao_valor
                    .setTextColor(ContextCompat.getColor(context, R.color.despesa))
        }
        //Configurando o ícone de acordo com o tipo de transação
        if(transacao.tipo == Tipo.RECEITA) {
            viewCriada.transacao_icone
                    .setBackgroundResource(R.drawable.icone_transacao_item_receita)
        } else {
            viewCriada.transacao_icone
                    .setBackgroundResource(R.drawable.icone_transacao_item_despesa)
        }

        viewCriada.transacao_valor.text = transacao.valor.toString()
        viewCriada.transacao_categoria.text = transacao.categoria
        viewCriada.transacao_data.text = transacao.data.formataParaBrasileiro()

        return viewCriada
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