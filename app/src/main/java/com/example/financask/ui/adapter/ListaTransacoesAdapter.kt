package com.example.financask.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.financask.R


class ListaTransacoesAdapter(transacoes: List<String>,
                             context: Context):BaseAdapter() {

    private val transacoes = transacoes
    private val context = context


    //Função que mostra a quantidade de itens
    override fun getCount(): Int {
        return transacoes.size
    }

    //Função que devolve o item
    override fun getItem(posicao: Int): String {
        return transacoes[posicao]
    }

    //Função que devolve o Id
    override fun getItemId(position: Int): Long {
        return 0
    }

    //Função que vai criar a view
    override fun getView(posicao: Int, view: View?, parent: ViewGroup?): View {
        return LayoutInflater.from(context).inflate(R.layout.transacao_item, parent, false)
    }
}